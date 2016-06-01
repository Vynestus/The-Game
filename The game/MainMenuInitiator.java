import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.lang.reflect.Array;
import java.lang.Object;

import java.util.*;

public class MainMenuInitiator extends JPanel 
{
   private JLabel label1, label2;
   private JTextField box;
   public static boolean skip=false;
   public static boolean cheat=false;
   private static boolean tempBoolean=false;
   static ImageIcon extra = new ImageIcon("pictures\\Mainmenu Image.jpg");
   static ImageIcon menuImage = new ImageIcon("pictures\\Exeriarsis.png");

   public MainMenuInitiator()
   {  
      JPanel panel = new JPanel();
      
      panel.setLayout(new GridLayout(2,2, 0, 0));
      
      JButton startButton = new JButton("Start Game");
      startButton.addActionListener(new SB());
      JButton skipButton = new JButton("Skip CC");
      skipButton.addActionListener(new Skip());
      JButton skipperButton = new JButton("Skip Intro");
      skipperButton.addActionListener(new Skipper());
      JButton quitButton = new JButton("Quit Game");
      quitButton.addActionListener(new QB());
      
      add(panel, BorderLayout.NORTH);
   
      panel.add(startButton, BorderLayout.NORTH);
      panel.add(quitButton, BorderLayout.NORTH);   
      panel.add(skipButton, BorderLayout.NORTH);
      panel.add(skipperButton,BorderLayout.NORTH);
   }
   
   public static String getRandStr()
   {
      String[] str = new String[10];
      str[0] = "Yfir Myrkr: Across Darkness";
      str[1] = "Yfir Myrkr: Across Dankness";
      str[2] = "Youfur Murky: Crossing The Alley.";
      str[3] = "Yfir Myrkr: DARK-NESS?";
      str[4] = "Yfir Myrkr: The Titillating Experience~";
      str[5] = "Yfir Myrkr: bodeboop, ding, ding";
      str[6] = "Yfir Myrkr: It will make you cry . . .";
      str[7] = "Yfir Myrkr: Valley Capstone";
      str[8] = "Yfir Myrkr: Yfir Myrkr: Yfir Myrkr: ";
      str[9] = "Yfir Myrkr: Make Exeriarsis Great Again!";
      
      
      int i = (int)(Math.random()*str.length);
      return str[i];
   }
   
   public void paintComponent(Graphics g)
   {
      
      
      super.paintComponent(g);
      double temp=Math.random();
     // System.out.println(temp);
      if(temp>.05)
         g.drawImage(menuImage.getImage(),0,0,1000,500,null);
      else
         g.drawImage(extra.getImage(),0,0,1000,500,null);  
      
   }
   public static boolean finisher()
   {
      return tempBoolean;
   }
   private static class SB implements ActionListener  
   {
      public void actionPerformed(ActionEvent e)
      {
                 
         tempBoolean=true;
      }
   }
   public static boolean getCheat()
   {
   return cheat;
   }
   public static boolean getSkip()
   {
   return skip;
   }
      private static class QB implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }
   private static class Skip implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         cheat=true;
         tempBoolean=true;
      }
   }
   private static class Skipper implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         cheat=true;
         skip=true;
         tempBoolean=true;
      }
   }
}