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
   static Wizard wiz;
   static boolean independant=true;
   static String tempDrawn="";
   static String oldText="",oldText2="",oldText3="";
   static String place="Atrian";
   static String tempFile;
   static JLabel gold;
   static JFrame cFrame; 
   public static Shoppe shopper;
   static boolean reader=true;
   static Scanner sc;
   static JButton reset,shop,resting,talk;
   static JPanel p1;
   static int delay=3000;
   static JFrame tFrame;
   private static boolean tempBoolean=false;
   static ImageIcon background= new ImageIcon("pictures\\Isteroth.jpg");
   public TownTalkMenu() 
   {
      this.setLayout(new BorderLayout());
      p1 = new JPanel(new GridLayout(1, 5,0,12));
      this.add(p1,BorderLayout.PAGE_END);
      if (!place.equals("Festival")&&!place.equals("Intro"))
      {
         reset = new JButton("leave");
         reset.setFont(new Font("Agency FB Bold",1,15));
         reset.addActionListener(new Reset());
         shop = new JButton("Shop");
         shop.setFont(new Font("Agency FB Bold",1,15));
         shop.addActionListener(new Shoppe());
         resting = new JButton("Rest in inn for a night(5 gold)");
         resting.addActionListener(new rester());
         resting.setFont(new Font("Agency FB Bold",1,15));
         gold = new JLabel("Current Gold: "+wiz.getGold());
         gold.setFont(new Font("Agency FB Bold",1,15));
      }
      else
      {
         reset = new JButton("Next");
         reset.setFont(new Font("Agency FB Bold",1,15));
         reset.addActionListener(new Reset());
         shop = new JButton("");
         resting = new JButton("");
         gold = new JLabel("");
      }
      talk = new JButton("Skip");
      talk.setFont(new Font("Agency FB Bold",1,15));
      talk.addActionListener(new skipper());
   
      p1.add(gold);
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
         reader=true;
         tempDrawn="";
         oldText="";
         oldText2="";
         oldText3="";
         tFrame.repaint();
         getText();
         startTyping();
      }
   }
   private static class skipper implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         delay=0;
      }
   }
   private static class Shoppe implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      shopper=new Shoppe();
         int shopTemp=1;
         if (place.equals("Isteroth"))
            shopTemp=2;
         else if (place.equals("Skelvaska"))
            shopTemp=3;
         boolean tempBoolean=false;
         shopper.start(shopTemp);
      
      
      }
   }
   private static class rester implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (wiz.getGold()>=5)
         {
            wiz.giveGold(-5);
            for (int z=0;z<7;z++)
            {
               wiz.rest();
            }
            message("You sleep in the inn for the night. You have "+wiz.getGold()+" gold left.");
         }
         else 
            message("You have "+wiz.getGold()+" gold. Not enough for a room");
         gold.setText("Current Gold: "+wiz.getGold());
      }
   }
   private static class TalkTimer implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         tempBoolean=true;
      }
   }
   public static void message(String said)
   {
      oldText3=oldText2;
      oldText2=oldText;
      oldText=tempDrawn;
      tempDrawn=said;
      tFrame.repaint();
      p1.repaint();
   
   }
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.drawImage(background.getImage(),0,0,1200,500,null);  
      g.setColor(Color.BLACK);
      g.fillRect(0,500,1200,700);
      g.setColor(Color.WHITE);
      g.setFont(new Font("Agency FB Bold",1,20));
      
      String tempor="Current Gold: "+wiz.getGold();
      int distance = g.getFontMetrics().stringWidth(tempor);
      //g.drawString(tempor,1100-distance-20,630);
      g.drawString(oldText3,0,530);
      g.drawString(oldText2,0,560);
      g.drawString(oldText,0,590);
      g.drawString(tempDrawn,0,620);
   
   }
   public static void timer()
   {
      
      try { 
         typeText();
         Thread.sleep(delay);
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
         System.out.println(tempFile);
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
         message(temp);
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
      tempBoolean=false;
      reader=true;
      tFrame = new JFrame(place);
      tFrame.setSize(1100, 700);
      tFrame.setLocation(1280/2-1100/2, 1024/2-700/2);
      tFrame.setBackground(Color.BLACK);
      tFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      tFrame.setContentPane(new TownTalkMenu());
      tFrame.setVisible(true);
      if (!independant)
         wiz=Yfir_Myrkr_Across_Darkness.getPlayer();
      else
         wiz=new Wizard("test");
      getText();
      startTyping();
   }
   public static void doTownStuff(String space)
   {
      delay=3000;
      independant=false;
      wiz=Yfir_Myrkr_Across_Darkness.getPlayer();
      place=space;
      String temp="pictures\\"+place+".jpg";
      background= new ImageIcon(temp);
      main(new String[3]);
   }
}

