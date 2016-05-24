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
import java.io.*;
import java.util.*;

public class TownTalkMenu extends JPanel 
{
   private JLabel label1, label2;
   private JTextField box;
   static String tempDrawn="";
   static String oldText="",oldText2="",oldText3="";
   static String place="Atrian";
   static String tempFile;
   static boolean reader=true;
   static Scanner sc;
   static JButton reset,shop,resting,talk;
   static JPanel p1;
   static JFrame tFrame;
   private static boolean tempBoolean=false;
   static ImageIcon background= new ImageIcon("pictures\\Atrian.jpg");
   public TownTalkMenu() 
   {
      this.setLayout(new BorderLayout());
      p1 = new JPanel(new GridLayout(1, 5,40,12));
      this.add(p1,BorderLayout.PAGE_END);
   
      reset = new JButton("leave");
      reset.addActionListener(new Reset());
      shop = new JButton("Shop");
      //shop.addActionListener(new Shoppe());
      resting = new JButton("Rest");
      talk = new JButton("Talk again");
      talk.addActionListener(new talkAgain());
     p1.add(reset);
      p1.add(shop);
      p1.add(resting);
      p1.add(talk);
      
      
   }
  
   private static class Reset implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         tempBoolean=true;
      }
   }
   private static class talkAgain implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      
      }
   }
   private static class TalkTimer implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         tempBoolean=true;
      }
   }
   public void paintComponent(Graphics g)
   {
      
      
      super.paintComponent(g);
      double temp=Math.random();
      //System.out.println(temp);
      
      //background = Yfir_Myrkr_Across_Darkness.getTownImage();
   
      g.drawImage(background.getImage(),0,0,1200,500,null);  
      g.setColor(Color.BLACK);
      g.fillRect(0,500,1200,700);
      g.setColor(Color.WHITE);
      g.setFont(new Font("Agency FB Bold",1,20));
      
      
      
      //getText();
      g.drawString(oldText3,0,530);
      g.drawString(oldText2,0,560);
      g.drawString(oldText,0,590);
      g.drawString(tempDrawn,0,620);
   
   }
   public static void timer()
   {
      
      try { 
         typeText();
         Thread.sleep(500);
      }
      catch(InterruptedException ex) {
         Thread.currentThread().interrupt();
      }
   }
   public static void getText()
   {
      
      
      tempFile="TownText\\\\"+place+".txt";
      try{
         File textList = new File(tempFile);
         sc = new Scanner(textList);
      }
      catch (FileNotFoundException e) 
      { 
         e.printStackTrace();
      }
   }
   public static void typeText()
   {
      String temp=sc.nextLine();
      if (!temp.equals("END"))
      {
         oldText3=oldText2;
         oldText2=oldText;
         oldText=tempDrawn;
         tempDrawn=temp;
      }
      else
      reader=false;
      }
   public static void startTyping()
   {
      while(reader)
      {
         tFrame.repaint();
         timer();
            
      }
   }
   public static boolean finisher()
   {
      if (tempBoolean==true)
         tFrame.setVisible(false);
      return tempBoolean;
   }
   public static void main(String[] args)
   {
      tFrame = new JFrame(place);
      tFrame.setSize(1100, 700);
      tFrame.setLocation(0, 0);
      tFrame.setBackground(Color.BLACK);
      tFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      tFrame.setContentPane(new TownTalkMenu());
      tFrame.setVisible(true);
      getText();
      startTyping();
   }
   public static void doTownStuff(String space)
   {
      place=space;
      String temp="pictures\\"+place+".jpg";
      background= new ImageIcon(temp);
      main(new String[3]);
   }
}

