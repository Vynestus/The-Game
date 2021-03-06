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
import javax.swing.JFileChooser;
import java.io.*;
import sun.audio.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
//import javafx.scene.media.MediaPlayer;
public class Yfir_Myrkr_Across_Darkness extends JPanel
{
   static CharacterCreation cc;
   static MainMenuInitiator mmi;
   static int frameHeight=(int)(855);
   static int frameWidth=1280;
   public static boolean soundOn=true;
   public static String town;
   public static boolean skip=false;
   public static Clip clip;
   public static boolean doneYet;
   public static File soundFile;
   public static String biome="Plains";
   public static AudioInputStream audioIn;
   static Scanner scan= new Scanner(System.in);
   static ImageIcon map = new ImageIcon("pictures\\Exeriarsis.png");
   static ImageIcon townBackground;
   public static int questPos=1;
   private static Wizard wiz;
   public static String input;
   private static Game2 dungeon= new Game2();
   public static JFrame frame,cFrame,tFrame; 
   public static JPanel p1;
   public static JButton dungeonOne,dungeonTwo,dungeonThree,dungeonFour,dungeonFive,dungeonSix,dungeonSeven,townTwo,townThree;
   public static int dungeonNum=0;               
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.drawImage(map.getImage(),0,0,frameWidth,frameHeight-30,null);
   }
   public Yfir_Myrkr_Across_Darkness()
   {
      this.setLayout(new BorderLayout());
      p1 = new JPanel(new GridLayout(1, 7,0,12));
      this.add(p1,BorderLayout.PAGE_END);
      
      JButton trainingDungeon = new JButton("Training Dungeon");
      trainingDungeon.setFont(new Font("Agency FB Bold",1,11));
      trainingDungeon.addActionListener(new TrainerDungeon());
      p1.add(trainingDungeon);
      
      dungeonOne = new JButton("First Dungeon");
      dungeonOne.setFont(new Font("Agency FB Bold",1,13));
      dungeonOne.addActionListener(new DungeonOne());
      
      JButton townOne = new JButton("Harvikir");
      townOne.setFont(new Font("Agency FB Bold",1,20));
      townOne.addActionListener(new TownOne());
      
      dungeonTwo = new JButton("Dungeon Two");
      dungeonTwo.setFont(new Font("Agency FB Bold",1,13));
      dungeonTwo.addActionListener(new DungeonTwo());
      dungeonTwo.setEnabled(false);
      
      
      townTwo = new JButton("Isteroth");
      townTwo.setFont(new Font("Agency FB Bold",1,20));
      townTwo.addActionListener(new TownTwo());
      townTwo.setEnabled(false);
      
      dungeonThree = new JButton("Dungeon Three");
      dungeonThree.setFont(new Font("Agency FB Bold",1,13));
      dungeonThree.addActionListener(new DungeonThree());
      dungeonThree.setEnabled(false);
   
      
      dungeonFour = new JButton("Dungeon Four");
      dungeonFour.setFont(new Font("Agency FB Bold",1,13));
      dungeonFour.addActionListener(new DungeonFour());
      dungeonFour.setEnabled(false);
   
      
      townThree = new JButton("Skelvaska");
      townThree.setFont(new Font("Agency FB Bold",1,20));
      townThree.addActionListener(new TownThree());
      townThree.setEnabled(false);
      
      dungeonFive = new JButton("Dungeon Five");
      dungeonFive.setFont(new Font("Agency FB Bold",1,13));
      dungeonFive.addActionListener(new DungeonFive());
      dungeonFive.setEnabled(false);
   
      
      dungeonSix = new JButton("Dungeon Six");
      dungeonSix.setFont(new Font("Agency FB Bold",1,13));
      dungeonSix.addActionListener(new DungeonSix());
      dungeonSix.setEnabled(false);
   
      
      dungeonSeven = new JButton("Dungeon Seven");
      dungeonSeven.setFont(new Font("Agency FB Bold",1,13));
      dungeonSeven.addActionListener(new DungeonSeven());
      dungeonSeven.setEnabled(false);
   
      
      p1.add(townOne);
      p1.add(dungeonOne);
      p1.add(dungeonTwo);
      p1.add(townTwo);
      p1.add(dungeonThree);
      p1.add(dungeonFour);
      p1.add(townThree);
      p1.add(dungeonFive);
      p1.add(dungeonSix);
      p1.add(dungeonSeven);
      
   }
   private static class DungeonOne implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (questPos>1)
         {
            JOptionPane.showMessageDialog(frame, "You have already retrieved the sword from this dungeon.");
         }
         else
         {
            if( JOptionPane.showConfirmDialog(
            frame,
            "Are you sure you want to enter the dungeon of .....?",
            "Dungeon of the ....",
            JOptionPane.YES_NO_OPTION)==0)
            {
               input = "one";
            }
            dungeonTwo.setEnabled(true);
         }
      }
   }
   private static class DungeonTwo implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (questPos>2)
         {
            JOptionPane.showMessageDialog(frame, "You have already retrieved the sword from this dungeon.");
         }
         else if (questPos<2)
         {
            JOptionPane.showMessageDialog(frame, "You still have more swords to retrieve before this one");
         }
         else
         {
            if( JOptionPane.showConfirmDialog(
            frame,
            "Are you sure you want to enter the dungeon of .....? The dungeon level is 2",
            "Dungeon of the ....",
            JOptionPane.YES_NO_OPTION)==0)
            {
               input = "two";
            }
            townTwo.setEnabled(true);
         }
      }
   }
   private static class DungeonThree implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (questPos>3)
         {
            JOptionPane.showMessageDialog(frame, "You have already retrieved the sword from this dungeon.");
         }
         else if (questPos<3)
         {
            JOptionPane.showMessageDialog(frame, "You still have more swords to retrieve before this one");
         }
         else
         {
            if( JOptionPane.showConfirmDialog(
            frame,
            "Are you sure you want to enter the dungeon of .....? The dungeon level is 4",
            "Dungeon of the ....",
            JOptionPane.YES_NO_OPTION)==0)
            {
               input = "three";
            }
            dungeonFour.setEnabled(true);
         }
      }
   }
   private static class DungeonFour implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (questPos>4)
         {
            JOptionPane.showMessageDialog(frame, "You have already retrieved the sword from this dungeon.");
         }
         else if (questPos<4)
         {
            JOptionPane.showMessageDialog(frame, "You still have more swords to retrieve before this one");
         }
         else
         {
            if( JOptionPane.showConfirmDialog(
            frame,
            "Are you sure you want to enter the dungeon of .....? The dungeon level is 5",
            "Dungeon of the ....",
            JOptionPane.YES_NO_OPTION)==0)
            {
               input = "four";
            }
            townThree.setEnabled(true);
         }
      }
   }
   private static class DungeonFive implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (questPos>5)
         {
            JOptionPane.showMessageDialog(frame, "You have already retrieved the sword from this dungeon.");
         }
         else if (questPos<5)
         {
            JOptionPane.showMessageDialog(frame, "You still have more swords to retrieve before this one");
         }
         else
         {
            if( JOptionPane.showConfirmDialog(
            frame,
            "Are you sure you want to enter the dungeon of .....? The dungeon level is 7",
            "Dungeon of the ....",
            JOptionPane.YES_NO_OPTION)==0)
            {
               input = "five";
            }
            dungeonSix.setEnabled(true);
         }
      }
   }
   private static class DungeonSix implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (questPos>6)
         {
            JOptionPane.showMessageDialog(frame, "You have already retrieved the sword from this dungeon.");
         }
         else if (questPos<6)
         {
            JOptionPane.showMessageDialog(frame, "You still have more swords to retrieve before this one");
         }
         else
         {
            if( JOptionPane.showConfirmDialog(
            frame,
            "Are you sure you want to enter the dungeon of .....? The dungeon level is 8",
            "Dungeon of the ....",
            JOptionPane.YES_NO_OPTION)==0)
            {   
               input = "six";
            }
            dungeonSeven.setEnabled(true);
         }
      }
   }
   private static class DungeonSeven implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (questPos>7)
         {
            JOptionPane.showMessageDialog(frame, "You have already retrieved the sword from this dungeon.");
         }
         else if (questPos<7)
         {
            JOptionPane.showMessageDialog(frame, "You still have more swords to retrieve before this one");
         }
         else
         {
            if( JOptionPane.showConfirmDialog(
            frame,
            "Are you sure you want to enter the dungeon of .....? The dungeon level is 10",
            "Dungeon of the ....",
            JOptionPane.YES_NO_OPTION)==0)
            {
               input = "seven";
            }
         }
      }
   }
   private static class TrainerDungeon implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         JOptionPane optionPane;
         if( JOptionPane.showConfirmDialog(
         frame,
         "The training dungeon is a dungeon in which you won't recieve gold or treasure, but you will find more"+
         "\n monsters to fight, and potentially level up faster. Are you sure you would"+
         " like to enter this dungeon?",
         "Training Dungeon",
         JOptionPane.YES_NO_OPTION)==0)
         {   
            input = "ten";
         }
      }
   }
   private static class TownOne implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
         input="tone";
      }
   }
   private static class TownTwo implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
         input="ttwo";
         dungeonThree.setEnabled(true);
         
      }
   }
   private static class TownThree implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
         input="tthree";
         dungeonFive.setEnabled(true);
         
      }
   }
   public static void dungeons(int num)
   {
      frame.setVisible(false);
      dungeon=new Game2();
      switch(num)
      {
         case 0:
            //System.out.println("testing");
            if (wiz.getLevel()>10)
            {
               dungeon.dungeonTime(10,biome,10,0,1);
            }
            else
               dungeon.dungeonTime(10,biome,wiz.getLevel(),0,1);
            break;
         case 1:
            biome="Plains";
            dungeon.dungeonTime(3,biome,1,10,1);
            break;
         case 2:
            biome="Desert";
            dungeon.dungeonTime(7,biome,2,15,2);
            break;
         case 3:
            biome="Forest";
            dungeon.dungeonTime(10,biome,4,20,3);
            break;
         case 4:
            biome="Icy";
            dungeon.dungeonTime(13,biome,5,20,4);
            break;
         case 5:
            biome="Swamp";
            dungeon.dungeonTime(15,biome,7,30,5);
            break;
         case 6:
            biome="Mountain";
            dungeon.dungeonTime(20,biome,8,0,6);
            break;
         case 7:
            biome="Desolate";
            dungeon.dungeonTime(25,biome,10,0,7);
            break;
         
            
      }
      frame.setVisible(true);
   }
   public static boolean mainMenu()
   {
      cFrame = new JFrame(MainMenuInitiator.getRandStr());
      cFrame.setSize(1000, 500);
      //cFrame.setBackground();
      cFrame.setLocation(1280/2-500, 1024/2-250);
      cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      cFrame.setContentPane(new MainMenuInitiator());
      cFrame.setVisible(true);
      boolean tempBoolean=false;
      while (!tempBoolean)
      {
         tempBoolean=MainMenuInitiator.finisher();
      }
      cFrame.setVisible(false);
      return true;
   }
   public static boolean townTalk(String place)
   {
      town=place;
   //System.out.println(town);
     /* String temp="pictures\\"+place+".jpg";
      townBackground= new ImageIcon(temp);
      tFrame = new JFrame(place);
      tFrame.setSize(1100, 700);
      //cFrame.setBackground();
      tFrame.setLocation(1280/2-500, 1024/2-250);
      tFrame.setBackground(Color.BLACK);
      tFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      tFrame.setContentPane(new TownTalkMenu());
      tFrame.setVisible(true);*/
      TownTalkMenu.doTownStuff(place);
      boolean tempBoolean=false;
      while (!tempBoolean)
      {
         tempBoolean=MainMenuInitiator.finisher();
      }
      cFrame.setVisible(false);
      
      return true;
   }
   public static Wizard getPlayer()
   {
      return wiz;
   }
   public static String getTown()
   {
      return town;
   }
   public static ImageIcon getTownImage()
   {
      return townBackground;
   }
   public static void createPlayer()
   {
      cc.characterCreate();
   }
   private static void playSound(String song)
   {
      
      if (clip.isRunning()) 
         clip.stop();
      else
      {
         getSound(song);
         clip.start();
      }
   }
   private static void getSound(String song) 
   {
      try {
         // Open an audio input stream.
         String songs=song+".wav";
         File soundFile = new File(songs);
         System.out.println(soundFile.length());
         audioIn = AudioSystem.getAudioInputStream(soundFile);
         // Get a sound clip resource.
         clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         
         
      } 
      catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } 
      catch (IOException e) {
         e.printStackTrace();
      } 
      catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }
   public static void setTown(String townTitle)
   {
      frame.setVisible(false);
      townTalk(townTitle);
      doneYet=false;
      while(!doneYet)
      {
         try {
            Thread.sleep(10);
            //if (doneYet)System.out.println("kill");
            //System.out.println(CharacterCreation.done());
            doneYet=TownTalkMenu.finisher();
         } 
         catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
         }
      }
      frame.setVisible(true);     
   }
   public static void main(String[] args) 
   {
      getSound("Tavern");  
      /*
      String bip = "bip.mp3";
      Media hit = new Media(bip);
      MediaPlayer mediaPlayer = new MediaPlayer(hit);
      mediaPlayer.play();*/
      mainMenu();
      boolean cheat=mmi.getCheat();
      boolean skip=mmi.getSkip();
      doneYet=false;
      if (!cheat)
      {
         if (soundOn)
         {
            playSound("Intro");
            JFrame tframe = new JFrame("Intro");
            tframe.setSize(1000,500);
            tframe.setLocation(1280/2-500,1024/2-250);
           tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      tframe.setContentPane(new Intro());
      tframe.setVisible(true);
            try{
               Thread.sleep(102000);
            }
            catch(InterruptedException ex) {
               Thread.currentThread().interrupt();
            }
         }
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
         wiz=new Wizard(cc.getCharName(),cc.getCharClass(),1,cc.getSex());
      }
      else 
      {
         wiz = new Wizard("test","Warrior",1,false);
      }
      //cFrame.setVisible(false);
      
      input="";
      
      frame = new JFrame("Yfir Myrkr");
      frame.add(new Yfir_Myrkr_Across_Darkness());
      int windowy=1024/2-(frameHeight/2);
      int windowx=1280/2-(frameWidth/2);
      frame.setBackground(Color.BLACK);
      frame.setSize(frameWidth,frameHeight);
      frame.setLocation(windowx,windowy);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Yfir_Myrkr_Across_Darkness());
      frame.setVisible(true);
      if (!skip)
      {
         setTown("Intro");
         if (soundOn) playSound("Tavern");
         setTown("Festival");
         if (soundOn) playSound("Tavern");
         setTown("Harvikir");
      } 
      while (!input.equals("exit"))
      {
         //input = scan.next();
         //System.out.println(input);
         try{
            Thread.sleep(10);
         }
         catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
         }
         switch (input)
         {
            case "one":
               dungeons(1);
               questPos=2;
               break;
            case "two":
               dungeons(2);
               questPos=3;
               break;
            case "three":
               dungeons(3);
               questPos=4;
               break;
            case "four":
               dungeons(4);
               questPos=5;
               break;
            case "five":
               dungeons(5);
               questPos=6;
               break;
            case "six":
               dungeons(6);
               questPos=7;
               break;
            case "seven":
               dungeons(7);
               break;
            case "ten":
               dungeons(0);
               break;
            case "tone":
               setTown("Harvikir");
               break;
            case "ttwo":
               setTown("Isteroth");
               break;
            case "tthree":
               setTown("Skelvaska");
               break;
         
         
         
         
         
         }
         input="";
      
      }
      
   }
}