
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import java.util.*;

public class CharacterCreation extends JPanel {
   private JLabel label1, label2;
   private JTextField namer;
   static String[] stat;
   public static boolean done=false;
   private static int counter;
   private static boolean sex;
   JComboBox<String> question;
   //String[] questions;
   public static JFrame cFrame;
   static String charClass;
   JPanel panel;
   public static String tempClass;
   public static String name;
   public static boolean questionnaire = false;
   public static String[] temp;
   public static int questionNum=0;
   public static String[] classQuestions= new String[4];
   public static int[] classWinner= new int[4];
  //archer,mage,rogue,warrior
   public static ArrayList<String> questions= new ArrayList<String>();
   public CharacterCreation()
   {
      panel = new JPanel();
      panel.setLayout(new FlowLayout());
      add(panel,BorderLayout.SOUTH);
      //System.out.println(counter);
      questions.clear();
      switch(counter)
      {
         case 0:
            panel.add(new JLabel("What is your name?"));
            namer = new JTextField(20);
            panel.add(namer);
            break;
         case 1:
            panel.add(new JLabel("Sex?"),BorderLayout.NORTH);
            questions.add("Female");
            questions.add("Male");
            break;
         case 2:
            panel.add(new JLabel("You May now either answer questions to choose a class, or skip and just choose your class"),BorderLayout.NORTH);
            questions.add("Answer Questions");
            questions.add("Skip Questions");
            break;
         case 3:
            String scanner="";
            File list = new File("Questions.txt");
            try {
               Scanner sc = new Scanner(list);
               for (int zy=0;zy<questionNum*10;zy++)
                  sc.nextLine();
               scanner=sc.nextLine();
               //System.out.println(scanner);
               
               
               //System.out.println(scanner+ " t");
               panel.add(new JLabel(scanner));
               for (int yz=0;yz<4;yz++)
               {
                  questions.add(sc.nextLine());
                  classQuestions[yz]=sc.nextLine();
               }
               
            /*for (int yz=0;yz<4;yz++)
                  {
                     System.out.println(classQuestions[yz]);
                  }*/
               if (!sc.hasNext()) counter=4;
                  
            }
            catch (FileNotFoundException e) 
            { 
               e.printStackTrace();
            }
            questionNum++;
            break;
         case 4:
            
            if (classWinner[0]>classWinner[1]&&classWinner[0]>classWinner[2]&&classWinner[0]>classWinner[3])
               tempClass="Archer";
            else if (classWinner[1]>classWinner[0]&&classWinner[1]>classWinner[2]&&classWinner[1]>classWinner[3])
               tempClass="Mage";
            else if (classWinner[2]>classWinner[1]&&classWinner[2]>classWinner[0]&&classWinner[2]>classWinner[3])
               tempClass="Rogue";
            else
               tempClass="Warrior";
            panel.add(new JLabel("The class suggested for you is "+tempClass));
            questions.add("Keep suggested class");
            questions.add("Choose your class");
            break;
         case 5:
            questions.add("Warrior");
            questions.add("Archer");
            questions.add("Rogue");
            questions.add("Mage");
            panel.add(new JLabel("Which class would you like to be?"),BorderLayout.NORTH);
            break;
      
      
      
      
      }
      if (counter>0)
      {
         temp=new String[questions.size()];
         questions.toArray(temp);
         question = new JComboBox<String>(temp);
         panel.add(question,BorderLayout.NORTH);
      }
      JButton doneYet= new JButton("Click to move on");
      doneYet.addActionListener(new MoveOn());
      panel.add(doneYet,BorderLayout.PAGE_END);
   }
   private class MoveOn implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      //JComboBox temp = (JComboBox)e.getSource();
         //System.out.println(counter);
         switch(counter)
         {
            case 0:
               name=namer.getText();
            //System.out.println(name);
               break;
            case 1:
            //System.out.println(counter);
               //System.out.println(question.getSelectedItem().toString());         
               if (question.getSelectedItem().equals("Female"))
                  sex=true;
               else 
                  sex=false;
               break;
            case 2:
               if (question.getSelectedItem().equals("Skip Questions"))
               {
                  //System.out.println("hurray");
                  counter=5;
               }
               break;
            case 3:
               tempClass = classQuestions[question.getSelectedIndex()];
               if (tempClass.equals("Archer") )
                  classWinner[0]++;
               else if (tempClass.equals("Archer")) classWinner[0]++;
               else if (tempClass.equals("Archer")) classWinner[0]++;
               
               else if (tempClass.equals("Archer")) classWinner[0]++;
            
            
               break;
            case 4:
            //archer mage rogue warrior
            
               if (question.getSelectedItem().equals("Keep suggested class"))
               {
                  charClass=tempClass;
                  done=true;
                  System.out.println("hello");
               }
               else if (question.getSelectedItem().equals("Choose your class"))
                  counter=5;
               
            
               break;
            case 5:
               charClass=question.getSelectedItem().toString();
               done=true;
               //System.out.println(done);
         }
         if (counter<3)
            counter++;
         if (!done)
         {
         //System.out.println("it's working");
            cFrame.setVisible(false);
            cFrame = new JFrame("Character Creation");
            cFrame.setSize(1000, 500);
            cFrame.setLocation(1280/2-500, 1024/2-250);
            cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            cFrame.setContentPane(new CharacterCreation());
            cFrame.setVisible(true);
         //System.out.println(counter);
         }
      }
   }
   public static boolean done()
   { 
      if (done)cFrame.setVisible(false);
      //else 
         //System.out.println("not yet" +superCounter);
      return done;
   }
   public static boolean getSex()
   {
      return sex;
   }
   public static String getCharClass()
   {
      return charClass;
   }
   public static String getCharName()
   {
      //System.out.println("hellkhnf;laskndglasd");
      return name;
   }
   public static void characterCreate()
   {
      counter=0;
      cFrame = new JFrame("Character Creation");
      cFrame.setSize(1000, 500);
      cFrame.setLocation(1280/2-500, 1024/2-250);
      cFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      cFrame.setContentPane(new CharacterCreation());
      cFrame.setVisible(true);
   }
   public static void main(String[] args) 
   {
      counter=0;
      cFrame = new JFrame("Character Creation");
      cFrame.setSize(1000, 500);
      cFrame.setLocation(1280/2-500, 1024/2-250);
      cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      cFrame.setContentPane(new CharacterCreation());
      cFrame.setVisible(true);
   }
}