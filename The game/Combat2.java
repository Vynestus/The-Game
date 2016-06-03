/*
 * AbsoluteLayoutDemo.java requires no other files.
 */
import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import java.util.*;

public class Combat2 extends JPanel
{
   static JButton b1, b2, b3, b4;
   
 //  static CombatInitiator startCombat;
   static ImageIcon monster;
   static String[] stat;
   public static boolean done;
   public int clicks = 0;
   private static boolean independant=false;
   private static Wizard wiz = new Wizard("");
   static ImageIcon weezard = new ImageIcon("wiz.png");
   private int number, count;
  
   public static void addComponentsToPane(Container pane)
   {
      //set the layout
      pane.setLayout(null);
   
      //create all buttons labels and combobox
      b1 = new JButton("Fight");
      b1.setFont(new Font("Agency FB Bold",1,20));
          
      b2 = new JButton("Items");     
      b2.setFont(new Font("Agency FB Bold",1,20));
      
      b3 = new JButton("Run");
      b3.setFont(new Font("Agency FB Bold",1,20));
      
      JLabel l1 = new JLabel("What will you do?");
      l1.setFont(new Font("Agency FB Bold",1,25));
      
      String[] temp= new String[wiz.getAbilities().size()];
      wiz.getAbilities().toArray(temp);
      JComboBox<String> abilities = new JComboBox<String>(temp);
     
      System.out.println(1+wiz.getItems().size());
      temp = new String[1+wiz.getItems().size()];
     
      if (wiz.currentPotions!=0)
         temp[0]="Health Potion";
      for (int x=0;x<wiz.getItems().size();x++)
      {
         temp[x+1]=wiz.getItems().get(x);
      }
      JComboBox<String> items = new JComboBox<String>(temp);
      
      //add the buttons labels etc..
      pane.add(b1);
      pane.add(b2);
      pane.add(b3);
      pane.add(l1);
      pane.add(abilities);
      pane.add(items);
   
      Insets insets = pane.getInsets();
      
      //set the button label location and dimensions
      Dimension size = b1.getPreferredSize();
      b1.setBounds(605 + insets.left, 325 + insets.top,
                   44 + size.width, size.height);
               
      Dimension size1 = b2.getPreferredSize();
   
                   
      size = b3.getPreferredSize();
      b3.setBounds(835 + insets.left, 325 + insets.top,
                   5 +size.width, size.height);    
      
      size = l1.getPreferredSize();
      l1.setBounds(690 + insets.left, 50 + insets.top,
                   20 + size.width, 20 + size.height);
                   
      size = abilities.getPreferredSize();
      abilities.setBounds(605 + insets.left, 370 + insets.top,
                          size.width, size.height);   
                          
      size = items.getPreferredSize();
      items.setBounds(720 + insets.left, 370 + insets.top,
                      size.width, size.height); 
                      
      b2.setBounds(720 + insets.left, 325 + insets.top,
                   size.width, size1.height);                                                
   // adding the action listeners for the butons
      b1.addActionListener(new fightButton());
      b2.addActionListener(new itemsButton());
      b3.addActionListener(new runButton());
   }
   private static class fightButton implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
      }    
   }
   private static class itemsButton implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
      }    
   }
   private static class runButton implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (Math.random()<.6)
            done=true;
         //else
         
      }    
   }
   
   public static boolean deadYet()
   {
      return done;
   }
   
   /**
    * Create the GUI and show it.  For thread safety,
    * this method should be invoked from the
    * event-dispatching thread.
    */
   private static void createAndShowGUI()
   {
      //Create and set up the window.
      JFrame frame = new JFrame("Combat Has Started!!! ");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
      //Set up the content pane.
      addComponentsToPane(frame.getContentPane());
   
      //Size and display the window.
      Insets insets = frame.getInsets();
      frame.setSize(1000 + insets.left + insets.right,
                   500 + insets.top + insets.bottom);
      frame.setVisible(true);
   }
   public static void main(String[] args)
   {
      //Schedule a job for the event-dispatching thread:
      //creating and showing this application's GUI.
      javax.swing.SwingUtilities.invokeLater(
            new Runnable()
            {
               public void run() 
               {
                  createAndShowGUI();
               }
            });
   }
}