

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
   public int clicks = 0;
   private static Wizard wiz;
   static ImageIcon weezard = new ImageIcon("wiz.png");
   private int number, count;
   public Combat()
   {
      setLayout(new FlowLayout());
      count = 0;
      done=false;
      stat=CombatInitiator.stats;
      
      monster=new ImageIcon(stat[6]);
      //System.out.println("||"+stat[6]+"||");
      
     
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());
      add(panel,BorderLayout.SOUTH);
      /*
      box = new JTextField("37", 5);
      box.setHorizontalAlignment(SwingConstants.RIGHT);
      panel.add(box);
      
      JComboBox attackList = new JComboBox(wiz.getAbilities().toArray());
      ComboBoxRenderer renderer= new ComboBoxRenderer();
      renderer.setPreferredSize(new Dimension(200, 130));
      petList.setRenderer(renderer);
      petList.setMaximumRowCount(3);
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
   */JLabel label1 = new JLabel(Game2.wiz.getName());
      panel.add(label1);
      String[] temp= new String[Game2.wiz.getAbilities().size()];
      Game2.wiz.getAbilities().toArray(temp);
      JComboBox<String> abilities = new JComboBox<String>(temp);
      /*for(String s:Game2.wiz.getAbilities())
      {
         abilities.addItem(s);
      }*/
      panel.add(abilities);
      panel.add(new JLabel("test"));
   }
   private class stats implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // 0 is name, 1-health, 2-damage,3-speed,4-defense,5-exp,6-image
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