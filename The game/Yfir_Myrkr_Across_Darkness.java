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
import java.util.*;
public class Yfir_Myrkr_Across_Darkness extends JPanel
{
   static CharacterCreation cc;
   static int frameHeight=700;
   static int frameWidth=1200;
   static Scanner scan= new Scanner(System.in);
   static ImageIcon fog = new ImageIcon("pictures\\Exeriarsis.png");
   private static Wizard wiz;
   private static Game2 dungeon;
   public static JFrame frame,cFrame; 
   public static int dungeonNum=0;
   public void paint(Graphics g)
   {
   
      Graphics2D g2d = (Graphics2D) g;
      g2d.drawImage(fog.getImage(),0,0,frameWidth,frameHeight,null);
   }
   public static void dungeon(int num)
   {
   
   
      frame.setVisible(false);
      
      
   
      switch(num)
      {
         case 0:
            dungeon.dungeonTime(3,"plains",0,10);
         case 1:
            dungeon.dungeonTime(5,"plains",1,20);
            break;
         case 2:
         
            break;
         case 3:
         
            break;
         case 4:
         
            break;
         case 5:
         
            break;
         case 6:
         
            break;
         case 7:
         
            break;
      }
      frame.setVisible(true);
   }
   public static Wizard getPlayer()
   {
      return wiz;
   }
   public static void createPlayer()
   {
      cc.characterCreate();
   }
   public static void main(String[] args) 
   {
      boolean doneYet=false;
      createPlayer();
      while(!doneYet)
      {
         try {
            Thread.sleep(10);
            //if (doneYet)System.out.println("kill");
            //System.out.println(CharacterCreation.done());
            doneYet=cc.done();
         } 
         catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
         }
      }
      /*System.out.println(cc.getCharName());
      System.out.println(cc.getCharClass());
      System.out.println(cc.getSex());*/
      wiz=new Wizard(cc.getCharName()/*,cc.getCharClass(),1,cc.getSex()*/);
      //cFrame.setVisible(false);
      frame = new JFrame("Yfir Myrkr");
      frame.add(new Yfir_Myrkr_Across_Darkness());
      int windowy=1024/2-(frameHeight/2);
      int windowx=1280/2-(frameWidth/2);
      frame.setSize(frameWidth,frameHeight);
      frame.setLocation(windowx,windowy);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      String input="";
      
      while (!input.equals("exit"))
      {
         input = scan.next();
         if (input.equals("test"))
         {
            dungeon(dungeonNum);
            dungeonNum++;
         }
      
      }
   }
}