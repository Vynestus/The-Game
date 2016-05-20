import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.util.Timer;
import java.awt.Graphics;
//import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.io.*;
import java.util.*;

public class Game2 extends JPanel {
   //private static MazeGenerator map= null;
   public static Wizard wiz;
   static CombatInitiator startCombat; 
   static Scanner c= new Scanner(System.in);
   public static int [][] north;
   public static int [][] south;
   public static int [][] west;
   public static int [][] east;
   public static int [][] items;
   public static boolean [][] light;
   public static ArrayList<MazeGenerator> mapList = new ArrayList<MazeGenerator>();
   public static int currentMap=0; 
   static int[] stairs;
   static int width;
   public static int direction=0;
   private static boolean draw=false;
   static int height;
   static int maxHeight=21;
   static int maxWidth=22;
   static int minHeight=10;
   static int minWidth=11;
   static int maxLevel;
   public static int helpMenu=250;
   static int monsterLevel;
   static String input;
   public static int windowx;
   public static int windowy;
   public static boolean independant=false;
   public static boolean combat=false;
   static int counter=0;
   static int movingl=0;
   static int movingu=0;
   public static boolean buttons=false;
   static ImageIcon stairsUp = new ImageIcon("pictures\\stairsup.png");
   static ImageIcon stairsDown = new ImageIcon("pictures\\stairsdown.png");
   static ImageIcon wall = new ImageIcon("pictures\\wall3.jpg");
   static ImageIcon fog = new ImageIcon("pictures\\Fog clone.png");
   static Color wallColor = new Color(0,0,0);
   static Color fogColor = new Color(100,100,100);
   public static JFrame frame; 
   public static double encounterChance;
   public void paint(Graphics g) 
   {
      Scanner c= new Scanner(System.in);
     //print background wall
      Graphics2D g2d = (Graphics2D) g;
      //g2d.setColor(new Color(127,255,0));
      g2d.setColor(wallColor);	
      for (int y=0;y<(height)/2;y++)
      {
         for (int x=0;x<(width)/2;x++)
         {
         
            g2d.drawImage(wall.getImage(),x*100,y*100,100,100,null);
         }
         
      }	
      g2d.setFont(new Font("Ariel",1,15));
      g2d.fillRect(0,0,26,height*50);
      g2d.fillRect(0,0,width*50,26);
      g2d.fillRect(width*50-74,0,275,height*50);
      g2d.fillRect(0,height*50-74,width*50,25);
      if (helpMenu>0)
      {
      g2d.setColor(Color.WHITE);
      g2d.drawString("Use the arrow keys to move",width*50-64,20);
         g2d.drawString("Click 'H' to turn off the this menu",width*50-64,40);
      }
      g2d.setColor(wallColor);	
      for (int y=1;y<height-1;y++)
      {
         for (int x=1;x<width-1;x++)
         {
            if (!light[y][x])
            {
               g2d.setColor(fogColor);
            }
            
            else
               g2d.setColor(wallColor);
            if (!light[y][x])
            {
               //g2d.fillRect(x*50-24,y*50-24,50,50);
               g2d.drawImage(fog.getImage(),x*50-24,y*50-24,50,50,null);
            }
            // east wall
            //g2d.setColor(Color.BLACK);
            try {
               if (east[y][x]==1&&light[y][x])
                  g2d.fillRect(x*50+25,y*50-25,1,50);
               //g2d.drawImage(fog.getImage(),x*50-24,y*50-24,50,50,null);
            // North
            
            //g2d.setColor(Color.BLUE);
               if (north[y][x]==1&&light[y][x])
                  g2d.fillRect(x*50-25,y*50-25,50,2);
               //g2d.drawImage(fog.getImage(),x*50-24,y*50-24,50,50,null);
            // South
            
            //g2d.setColor(Color.GREEN);
               if (south[y][x]==1&&light[y][x])
                  g2d.fillRect(x*50-25,y*50+24,50,2);
               //g2d.drawImage(fog.getImage(),x*50-24,y*50-24,50,50,null);
            // West
            //g2d.setColor(new Color(127,255,0));
               if (west[y][x]==1&&light[y][x])
                  g2d.fillRect(x*50-24,y*50-25,1,50);
               //g2d.drawImage(fog.getImage(),x*50-24,y*50-24,50,50,null);
            }
            catch (ArrayIndexOutOfBoundsException e) 
            { 
               e.printStackTrace();
            }
            
         }
      }
      //sux,suy,sdx,sdy
      if (light[stairs[3]][stairs[2]])
         g2d.drawImage(stairsDown.getImage(),stairs[2]*50-23,stairs[3]*50-23,48,48,null);
      if (light[stairs[1]][stairs[0]])
         g2d.drawImage(stairsUp.getImage(),stairs[0]*50-23,stairs[1]*50-23,48,48,null);
      //if (movingr>0||movingu>0)   
      int wizplacex=wiz.getX()*50-25+movingl;
      //System.out.println(wizplacex);
      int wizplacey=wiz.getY()*50-23+movingu;
      g2d.drawImage(wiz.getPic().getImage(),wizplacex,wizplacey,48,48,null);
      if (buttons)
      {
         JPanel panel = new JPanel();
         panel.setLayout(new FlowLayout());
         add(panel,BorderLayout.EAST);
         JButton button1 = new JButton("test");
         button1.addActionListener(new stats());
         panel.add(button1);
         buttons=false;
      }
   
   }
   private class stats implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // 0 is name, 1-health, 2-damage,3-speed,4-defense,5-exp,6-image)
         for (int x=0;x<7;x++)
         {
            System.out.println("test");
         }
      }
   }
    // 1 means wall
         // 0 means empty
   public int[][] getNorth()
   {
      return north;
   }
   public int[][] getEast()
   {
      return east;
   }
   public int[][] getSouth()
   {
      return south;
   }
   public int[][] getWest()
   {
      return west;
   }
   public static void changeLevel()
   {
      north=mapList.get(currentMap).getNorth();
      south=mapList.get(currentMap).getSouth();
      west=mapList.get(currentMap).getWest();
      east=mapList.get(currentMap).getEast();
      height=mapList.get(currentMap).getHeight();
      width=mapList.get(currentMap).getWidth();
      stairs=mapList.get(currentMap).getStairs();
      items=mapList.get(currentMap).getItems();
      light = new boolean[north.length][north[1].length];
      //System.out.println(stairs[0]+" "+stairs[1]+" "+stairs[2]+" "+ stairs[3]);
      //System.out.println(currentMap+" is "+width+" "+height + " compared "+mapList.get(currentMap).getWidth()+" "+mapList.get(currentMap).getHeight());
     // mapList.get(currentMap).printWalls();
      
   }
   public static void newMap(int h, int w)
   {
      height=h;
      width=w;
      light = new boolean[h][w];
    //MazeGenerator map= new MazeGenerator(width,height);
      //map.setName("map " + mapList.size());
      //mapList.add(new MazeGenerator());
      mapList.add(new MazeGenerator(width,height,"map "+mapList.size()));
      //mapList.get(currentMap).startingItems();
      //mapList.get(mapList.size()-1)=new MazeGenerator(width,height,"map "+mapList.size());
      //map=null;
      
      //System.out.println(
      //counter++;
      height=mapList.get(mapList.size()-1).getHeight();
      width=mapList.get(mapList.size()-1).getWidth();
      
      changeLevel();
         /*if (mapList.get(currentMap).getName().equals("map 0"))
      {
         for(int x=0;x<items[0].length;x++)
         {
            for(int y=0;y<items.length;y++)
            {
            if(items[y][x]==1)
            items[y][x]=1;
            }
         }
      }*/
      
   }
   public static void goUp()
   {
      if (currentMap==0)
      {
         System.out.println("You can't leave now! You have swords to collect and a world to save!");
         /*String input = c.next();
         if (input.equals("y"))
         {
            System.out.println("Goodbye, we hope you had fun, come again!!");
            System.exit(0);
         }*/
      }
      else
      {
         currentMap--;
         changeLevel();
         wiz.setXY(stairs[2],stairs[3]);
      }
   }
   public static void goDown()
   {
      if (currentMap==maxLevel)
      {
         System.out.println("In the darkness of this stairwell, you see a bright light. There lays, a sword on a pedastal. This is it.");
         input="exit";
      }
      else
      {
         currentMap++;
         if (currentMap==mapList.size())
         {
            int tempHeight=(int)(Math.random()*(maxHeight-minHeight)+minHeight+1);
            int tempWidth=(int)(Math.random()*(maxWidth-minWidth)+minWidth+1);
            newMap(tempHeight,tempWidth);
         }
         else 
            changeLevel();
         wiz.setXY(stairs[0],stairs[1]);
         draw();
         draw();
      }
   }
  
   public static void combat(String monster)
   {
      frame.setVisible(false);
      if (startCombat.startCombat(monster));
      startCombat.endCombat();
      frame.setVisible(true);
   }
   public static void printing()
   {
      for(int i=0;i<mapList.size();i++)
      {
         mapList.get(i).printWalls();
      }
   }
   public static void draw()
   {
      if (!draw)
      {
         for (int x=0;x<light.length;x++)
         {
            for (int y=0;y<light[0].length;y++)
            {
               light[x][y]=true;
            }
         }
         draw=true;
      } 
      else 
         draw=false;
   }
   public static void move(String mover)
   {
      int steps=50;
      int sub=5;
      double secondsToMove=.5;
      
      if (wiz.go(mover))
      {
      
         if (mover.equals("south")||mover.equals("down")||mover.equals("s"))
         {
            movingu=-1*steps;
            direction=0;
         }
         else if (mover.equals("up")||mover.equals("north")||mover.equals("n"))
         {
            direction=1;
            movingu=steps;
         }
         else if (mover.equals("east")||mover.equals("right")||mover.equals("e"))
         {
            movingl=-1*steps;
         }
         else if (mover.equals("left")||mover.equals("west")||mover.equals("w"))
         {
            movingl=steps;
         }
         encounter(false);
            
            //System.out.println(movingu+" "+movingl);
        // while (movingl+movingu!=0)
         steps=steps/sub;
         while (steps!=0)
         {
            //frame.repaint();
            try {
               Thread.sleep((int)((secondsToMove*1000)/(50/sub)));
            }
            catch(InterruptedException ex) {
               Thread.currentThread().interrupt();
            }
            wiz.setImage(direction,steps%4);
            if (movingl>0)
               movingl-=sub;
            if (movingl<0)
               movingl+=sub;
            if (movingu>0)
               movingu-=sub;
            if (movingu<0)
               movingu+=sub;
            refresh();   
            steps--; 
         }
         wiz.setImage(direction,0);
      }
   }
   public static void refresh()
   {
      doLighting();
      frame.repaint();
      
   }
   
   public static void lighter()
   {
      int[][] pathing = new int[height][width];
     //System.out.println(" test" +height+" "+ width);
      for(int x=0;x<height;x++)
      {
         for(int y=0;y<width;y++)
         {
            pathing[x][y]=0;
         }
      }
      lighting(stairs[3],stairs[2],1,pathing);
      
      System.out.println("final form");
      for(int x=1;x<height-1;x++)
      {
         for(int y=1;y<width-1;y++)
         {
            System.out.print(pathing[x][y]+"\t");
         }
         System.out.println();
      }
      System.out.println(wiz.getY()+" "+wiz.getX());
      while(stairs[3]!=wiz.getY()||stairs[2]!=wiz.getX())
      {
         int p=pathing[wiz.getY()][wiz.getX()];
         //System.out.println(p);
         if(north[wiz.getY()][wiz.getX()]==0&&pathing[wiz.getY()-1][wiz.getX()]<p)
         {
            p=pathing[wiz.getY()-1][wiz.getX()];
            move("n");
         }
         System.out.println(pathing[wiz.getY()-1][wiz.getX()]);
         if(south[wiz.getY()][wiz.getX()]==0&&pathing[wiz.getY()+1][wiz.getX()]<p)
         {
            p=pathing[wiz.getY()+1][wiz.getX()];
            move("s");
         }
         System.out.println(pathing[wiz.getY()+1][wiz.getX()]);
         if(east[wiz.getY()][wiz.getX()]==0&&pathing[wiz.getY()][wiz.getX()-1]<p)
         {
            p=pathing[wiz.getY()][wiz.getX()-1];
            move("e");
         }
         System.out.println(pathing[wiz.getY()][wiz.getX()-1]);
         if(west[wiz.getY()][wiz.getX()]==0&&pathing[wiz.getY()][wiz.getX()+1]<p)
         {
            p=pathing[wiz.getY()-1][wiz.getX()+1];
            move("w");
         }
         System.out.println(pathing[wiz.getY()][wiz.getX()+1]);
      }
   
   }
   public static void lighting(int ypos,int xpos, int light, int[][] pathing)
   {
      
      if (pathing[ypos][xpos]>light||pathing[ypos][xpos]==0)
      {
         pathing[ypos][xpos]=light;
         if (north[ypos][xpos]==0)
         {
         //System.out.println(ypos+" "+xpos+" "+light);
            lighting(ypos-1,xpos,light+1,pathing);
         }
         if (south[ypos][xpos]==0)
         {
         //System.out.println(ypos+" "+xpos+" "+light);
            lighting(ypos+1,xpos,light+1,pathing);
         }
         if (east[ypos][xpos]==0)
         {
         //System.out.println(ypos+" "+xpos+" "+light);
            lighting(ypos,xpos+1,light+1,pathing);
         }
         if (west[ypos][xpos]==0)
         {
         //System.out.println(ypos+" "+xpos+" "+light);
            lighting(ypos,xpos-1,light+1,pathing);
         }
      }
      
               
   }

   public static void doLighting()
   {
      if (!draw)
      {
         int tempx=wiz.getX(),tempy=wiz.getY(),counter=0;
         boolean waller = true;
         for (int x=0;x<light.length;x++)
         {
            for (int y=0;y<light[0].length;y++)
            {
               light[x][y]=false;
            }
         }
         light[wiz.getY()][wiz.getX()]=true;
         int max=3;
         for (int x=0;x<4;x++)
         {//0=down, 1=up, 2=left, 3=right
            tempx=wiz.getX();
            tempy=wiz.getY();
            counter=0;
            int tempCount;
            waller=true;
            if (x==0)
            {
            // south
               while(counter<max&&south[tempy][tempx]==0)
               {
                  tempy++;
                  light[tempy][tempx]=true;
                  tempCount=0;
                  while(tempCount<max-counter-1)
                  {
                     if (east[tempy][tempx+tempCount]==0)
                        light[tempy][tempx+tempCount+1]=true;
                     else 
                        tempCount=max-counter;
                     tempCount++;
                  }
                  tempCount=0;
                  while(tempCount<max-counter-1)
                  {  
                     
                     if (west[tempy][tempx-tempCount]==0)
                        light[tempy][tempx-tempCount-1]=true;
                     else 
                        tempCount=max-counter;
                     tempCount++;
                  }
                  counter++;
               }
            }
            else if (x==1)
            {
            //north
               while(counter<max&&north[tempy][tempx]==0)
               {
                  tempy--;
                  light[tempy][tempx]=true;
                  tempCount=0;
                  while(tempCount<max-counter-1)
                  {
                     if (east[tempy][tempx+tempCount]==0)
                        light[tempy][tempx+tempCount+1]=true;
                     else 
                        tempCount=max-counter;
                     tempCount++;
                  }
                  tempCount=0;
                  while(tempCount<max-counter-1)
                  {
                     if (west[tempy][tempx-tempCount]==0)
                        light[tempy][tempx-tempCount-1]=true;
                     else 
                        tempCount=max-counter; 
                     tempCount++;                   
                  }
                  counter++;
               }
            }
            else if (x==2)
            {//west
               while(counter<max&&west[tempy][tempx]==0)
               {
                  tempx--;
                  light[tempy][tempx]=true;
                  tempCount=0;
                  while(tempCount<max-counter-1)
                  {
                     if (north[tempy-tempCount][tempx]==0)
                        light[tempy-tempCount-1][tempx]=true;
                     else 
                        tempCount=max-counter;
                     tempCount++;
                  }
                  tempCount=0;
                  while(tempCount<max-counter-1)
                  {
                     if (south[tempy+tempCount][tempx]==0)
                        light[tempy+tempCount+1][tempx]=true;
                     else 
                        tempCount=max-counter;
                     tempCount++;
                  }
                  counter++;
               }
            }
            else if (x==3)
            {//east
               while(counter<max&&east[tempy][tempx]==0)
               {
                  tempx++;
                  light[tempy][tempx]=true;
                  tempCount=0;
                  while(tempCount<max-counter-1)
                  {
                     if (north[tempy-tempCount][tempx]==0)
                        light[tempy-tempCount-1][tempx]=true;
                     else 
                        tempCount=max-counter;
                     tempCount++;
                  }
                  tempCount=0;
                  while(tempCount<max-counter-1)
                  {
                     if (south[tempy+tempCount][tempx]==0)
                        light[tempy+tempCount+1][tempx]=true;
                     else 
                        tempCount=max-counter;
                     tempCount++;
                  }
                  counter++;
               }
            }
         }
      }
   }
   public static void encounter(Boolean safe)
   {
      double encounter=Math.random();
      //System.out.println(encounter+" "+encounterChance);
      String scanner="";
      String target="level"+monsterLevel;
      //System.out.println(target);
      double tempEncounterChance;
      if (safe)
         tempEncounterChance=encounterChance/4;
      else
         tempEncounterChance=encounterChance;
      if (encounter<tempEncounterChance)
      {
         File list = new File("MonsterLevel.txt");
         try {
            //System.out.println("SomethingHappend!");
            Scanner sc = new Scanner(list);
            while(!scanner.equalsIgnoreCase(target)&&!scanner.equals("End"))
            {
               scanner=sc.next();
               //System.out.println(scanner);
            }
            if(scanner.equals("End"))
            {
               System.out.println("That level of monster doesn't exist");
            }
            else
            {
               int numMonsters=Integer.parseInt(sc.next());
               //System.out.println(numMonsters);
               encounter=(int)(Math.random()*numMonsters+1);
               //System.out.println(encounter);
               for (int xyz=1;xyz<encounter;xyz++)
               {
                  sc.next();
               }
               String monster=sc.next();
              //System.out.println(monster);
              
               combat(monster);
            }
         }   
         catch (FileNotFoundException e) 
         { 
            e.printStackTrace();
         }
      }
   }
   public static class KL extends KeyAdapter{ 
      public void keyPressed(KeyEvent e){
         int keyCode = e.getKeyCode();
         if(keyCode == e.VK_UP)
         {
            //move("up");
            input="up";
         }
         else if(keyCode == e.VK_DOWN)
         {
            //move("down");
            //System.out.println("testing123");
            input="down";
         }
         else if(keyCode == e.VK_RIGHT)
         {
            input="right";
            //move("right");
         }
         else if(keyCode == e.VK_LEFT)
         {
            //move("left");
            input="left";
         }
         else if(keyCode == e.VK_R)
         {
            input="cheatCommand";
         }
         else if(keyCode == e.VK_Z)
         {
            input="draw";
         }
         else if (keyCode==e.VK_H)
         {
         if(helpMenu==250)
         helpMenu=0;
         else
         helpMenu=250;
         }
         else if(keyCode == e.VK_ENTER)
         {
            input="stairs";
            /*if(items[wiz.getY()][wiz.getX()]==2)
               goDown();
            else if (items[wiz.getY()][wiz.getX()]==1)
               goUp();*/
         }
         wiz.restoreMana(1);
         windowx=width*50-50*3/4+250;
         windowy=height*50-50/4;
         frame.setSize(windowx,windowy);
         frame.setLocation(1280/2-windowx/2, 1024/2-windowy/2);
         refresh(); 
      }
      public void keyReleased(KeyEvent e){
      
      }
   }
   public static boolean dungeonTime(int depth,String biome,int level, double encounter) 
   {
      //mapList= new ArrayList<MazeGenerator>();
      encounterChance=encounter/100;
      maxLevel=depth-1;
      monsterLevel=level;
      Scanner c= new Scanner(System.in);
      newMap(10,15);
      if (independant)
         wiz= new Wizard("player"/*,width,height*/);
      else
         wiz= Yfir_Myrkr_Across_Darkness.getPlayer();
      //t.printWalls();
      frame = new JFrame("Dungeon");
      frame.add(new Game2());
      windowx=width*50-50*3/4;
      windowy=height*50-50/4;
      frame.setSize(windowx,windowy);
      frame.setLocation(1280/2-windowx/2, 1024/2-windowy/2);
      frame.setVisible(true);
      if (independant)
      {
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //System.out.println("it works");
      }
      else
      {
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         //System.out.println("it doesn't works");
      }
      int waiting=0;
      input="";
      frame.addKeyListener(new KL());
      wiz.setXY(stairs[0],stairs[1]);
      while (!input.equals("exit"))
      {input="";
         if (combat)
            System.out.println("test");
         if (combat)
            frame.setVisible(false);
         else 
            frame.setVisible(true);
         //frame.addKeyListener(new KL());    
       //System.out.println(wiz.getEnergy());
         //int waiting=0;
         
         if (waiting==0&&!combat)
         {
            refresh();
            //input = c.next();
           // input = "";
            //wiz.restoreEnergy();
            //System.out.println("hello there");
            if (input.equalsIgnoreCase("cheatcommand"))
               input=c.next();
            switch(input)
            {
               case "move":
               case "go":
                  String movement=c.next();
                  move(movement);
                  
                  break;
               case "up":
               case "w":
                  move("up");
                  break;
               case "down":
               case "s":
                  move("down");
                  break;
               case "left":
               case "a":
                  move("left");
                  break;
               case "right":
               case "d":
                  move("right");
                  break;
               case "teleport":
                  System.out.println("You were at "+wiz.getX()+","+wiz.getY());
                  wiz.teleport(c.nextInt(),c.nextInt());
                  
                  break;
               case "wait":
                  case "sleep":
                  case "rest":
                  waiting=(int)(c.nextDouble());
                  System.out.println("You are resting");
                  break;
               case "help":
                  case "?":
                  System.out.println ("move(direction)/go (direction)/w-a-s-d/right-left-up-down"+" "+ 
                     "  \n teleport \n rest/sleep/wait \n stairs");
                  break;
               case "stairs":
                  //System.out.println(wiz.getY()+" "+wiz.getX()+" "+items[wiz.getY()][wiz.getX()]);
                  if(items[wiz.getY()][wiz.getX()]==2)
                     goDown();
                  else if (items[wiz.getY()][wiz.getX()]==1)
                     goUp();
                  
                  break;
               case "repaint":
                  refresh();
                  break;
               case "cheatDown":
                  goDown();
                  break;
               case "path":
                  lighter();
                  break;
               case "print":
                  printing();
                  break;
               case "draw":
                  draw();
                  break;
               case "test":
                  String tempMonster=c.next();
                  combat(tempMonster);
                  break;
                
            }
            refresh();
         }
         else 
         {
            encounter(true);
            waiting--;
         }
         wiz.restoreMana(1);
         windowx=width*50-50*3/4+helpMenu;
         windowy=height*50-50/4;
         frame.setSize(windowx,windowy);
         frame.setLocation(1280/2-windowx/2, 1024/2-windowy/2);
         //input="";
         //frame.repaint();
      }
      frame.dispose();
      return true;
   }
   public static void main(String[] args) 
   {
      independant=true;
      if (dungeonTime(3,"plains",0,0))
         System.exit(1);
   }
}