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
   static int frameHeight=700;
   static int frameWidth=1200;
   public static boolean soundOn=false;
   public static String town;
   public static Clip clip;
   public static File soundFile;
   public static AudioInputStream audioIn;
   static Scanner scan= new Scanner(System.in);
   static ImageIcon map = new ImageIcon("pictures\\Exeriarsis.png");
   static ImageIcon townBackground;

   private static Wizard wiz;
   private static Game2 dungeon;
   public static JFrame frame,cFrame,tFrame; 
   public static int dungeonNum=0;
   public void paint(Graphics g)
   {
   
      Graphics2D g2d = (Graphics2D) g;
      g2d.drawImage(map.getImage(),0,0,frameWidth,frameHeight,null);
   }
   public static void dungeon(int num)
   {
   
   
      frame.setVisible(false);
      
      
   
      switch(num)
      {
         case 0:
            //System.out.println("testing");
            dungeon.dungeonTime(1,"plains",0,0);
            break;
         case 1:
            System.out.println("testin two");
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
   private static void playSound()
   {
      
      if (clip.isRunning()) 
         clip.stop();
      else
         clip.start();
            //System.out.println(clip.getFrameLength());
         //clip.setFramePosition(0);
         //clip.start();
      
   }
   private static void getSound() 
   {
      try {
         // Open an audio input stream.
         File soundFile = new File("tavern.wav");
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
   public static void main(String[] args) 
   {
      getSound();
      /*
      String bip = "bip.mp3";
      Media hit = new Media(bip);
      MediaPlayer mediaPlayer = new MediaPlayer(hit);
      mediaPlayer.play();*/
      mainMenu();
      boolean cheat=mmi.getCheat();
      boolean doneYet=false;
      if (!cheat)
      {
         if (soundOn)playSound();
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
         if (soundOn)playSound();
         wiz=new Wizard(cc.getCharName(),cc.getCharClass(),1,cc.getSex());
      }
      else 
      {
               wiz = new Wizard("test","Warrior",1,false);
               }
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
     
      frame.setVisible(false);
            townTalk("Harvikir");
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
   
     
     
      while (!input.equals("exit"))
      {
         input = scan.next();
         //System.out.println(input);
         if (input.equals("test"))
         {
            dungeon(dungeonNum);
            dungeonNum++;
         }
         else if (input.equals("what"))
         {
         System.out.println(wiz.getLevel());
         }
         input="";
      
      }
   }
}