

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

import java.util.*;

public class Combat extends JPanel {
   private JLabel label1, label2;
   private JTextField box;
   static ImageIcon monster;
   static String[] stat;
   public static boolean done;
   static ImageIcon weezard = new ImageIcon("wiz.png");
   private int number, count;
   public Combat()
   {
      setLayout(new FlowLayout());
      number = 37;
      count = 0;
      done=false;
      stat=CombatInitiator.stats;
      
      monster=new ImageIcon(stat[5]);
      
     /*
      label1 = new JLabel("37");
      label1.setFont(new Font("Serif", Font.BOLD, 100)); 
      label1.setForeground(Color.blue);
      add(label1);
      */
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());
      add(panel,BorderLayout.SOUTH);
      /*
      box = new JTextField("37", 5);
      box.setHorizontalAlignment(SwingConstants.RIGHT);
      panel.add(box);
      */
      JButton button1 = new JButton(monster);
      button1.addActionListener(new stats());
      panel.add(button1);
      
      JButton button2 = new JButton("Quit Completely");
      button2.addActionListener(new quitcompletely());
      panel.add(button2,BorderLayout.SOUTH);
      
      JButton button3 = new JButton("Quit");
      button3.addActionListener(new quit());
      panel.add(button3,BorderLayout.EAST);
      /*
      label2 = new JLabel("Iterations: 0");
      add(label2);
   */
   }
   private class stats implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // 0 is name, 1-health, 2-damage,3-speed,4-defense,5-exp,6-image)
         	for (int x=0;x<7;x++)
            {
            System.out.println(CombatInitiator.stats[x]);
         }
      }
   }
   private class quitcompletely implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
         System.exit(1);
         
      }
   }
   private class quit implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
         done=true;
         
      }
   }   
   public static boolean deadYet()
   {
      return done;
   }
}