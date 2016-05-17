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
   static int frameHeight=700;
   static int frameWidth=1200;
   static Scanner scan= new Scanner(System.in);
   static ImageIcon fog = new ImageIcon("pictures\\Exeriarsis.png");
   private static Wizard wiz;
   private static Game2 dungeon;
   public static JFrame frame; 
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
            dungeon.dungeonTime(3,"plains",0);
         case 1:
            dungeon.dungeonTime(5,"plains",1);
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

   public static void main(String[] args) 
   {
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
            dungeonNum++;
            dungeon(dungeonNum);
         }
      
      }
   }
}