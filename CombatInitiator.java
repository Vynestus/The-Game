
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
public class CombatInitiator
{
   public static String[] stats;
   static JFrame cFrame;
   static boolean dead=false;
   public static boolean startCombat(String creature)
   { 
      dead=false;
      getStats(creature);
      if (!dead)
      {
         cFrame = new JFrame("COMBAT HAS STARTED!!!");
         cFrame.setSize(1000, 500);
         cFrame.setLocation(1280/2-500, 1024/2-250);
         cFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         cFrame.setContentPane(new Combat());
         cFrame.setVisible(true);
         while (!dead)
         {
            dead=Combat.deadYet();
         }
      }
      return true;
   }
   public static void getStats(String name)
   {
      //System.out.println(name);
      String munster = "";
      stats = new String[7];
      File list = new File("Monsters.txt");
      try {
         Scanner sc = new Scanner(list);
         while (!munster.equalsIgnoreCase(name)&&!munster.equals("End"))
         {
            munster=sc.next();
            //System.out.println(munster);
         }
         if (munster.equals("End"))
         {
            System.out.println("Could Not Find Creature");
            dead=true;
         }
         else
         {
            stats[0]=munster;
            for (int x=1;x<7;x++)
            {
               stats[x]=sc.next();
            }/*
            for (int x=0;x<7;x++)
            {
               System.out.print(stats[x]+"\t");
            }
            System.out.println();*/
         }
      }
      catch (FileNotFoundException e) 
      { 
         e.printStackTrace();
      }
      
   
   }
   public static void endCombat()
   {
   
      cFrame.dispose();
   }
}