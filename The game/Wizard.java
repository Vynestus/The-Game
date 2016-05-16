import java.util.Collections;
import java.util.*;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.util.*;
public class Wizard
{
   static int x;
   static int y;
   static int width;
   static int height;
   static int teleportEnergy=0;
   static int requiredEnergy=7;
   static int maxEnergy=21;
   static int level;
   static int hp;
   static int attack;
   static String[] Inventory;
   static String[] equipped Weapon;
   //index 0=name, 1=damage, 2=attack, 
   static ImageIcon weezard = new ImageIcon("pictures\\wiz.png");
   //Game2 test=new Game2();
   public Wizard(int length,int tall)
   {
      width=length;
      height=tall;
      x=(int)(Math.random()*(length-2)+1);
      y=(int)(Math.random()*(height-2)+1);
       //System.out.println(x+" "+y);
      
   
   }
   public int getX()
   {
      return x;
   }
   public int getY()
   {
      return y;
   }
   public int getEnergy()
   {
      return teleportEnergy;
   }
   public ImageIcon getPic()
   {
      return weezard;
   }
   public void randomize(int length, int tall)
   {
      width=length;
      height=tall;
      x=(int)(Math.random()*(length-2)+1);
      y=(int)(Math.random()*(height-2)+1);
   }
   public void setXY(int pos, int pos2)
   {
      x=pos;
      y=pos2;
   }
   public static void restoreEnergy()
   {
      if (teleportEnergy<maxEnergy)
         teleportEnergy++;
   }
    // 1 means wall
         // 0 means empty
  
   public static boolean go(String direction)
   {
      
      //String direction="";
      Scanner c= new Scanner(System.in);
      //direction=c.next();
      boolean worked=true;
      switch(direction)
      {
         case "east":
         case "right":
         case "e":
            if (Game2.east[y][x]==1)
            {
            worked=false;
               System.out.println("There's a wall there");
               }
            else
               x++;
            break;
         case "left":
         case "west":
         case "w":
            if (Game2.west[y][x]==1)
            {
           worked=false;
               System.out.println("There's a wall there");
               }
            else
               x--;
            break;
         case "up":
         case "north":
         case "n":
            if (Game2.north[y][x]==1)
            {
            worked=false;
               System.out.println("There's a wall there");
               }
            else
               y--;
            break;
         case "south":
         case "down":
         case "s":
            if (Game2.south[y][x]==1)
            {
            worked=false;
               System.out.println("There's a wall there");
               }
            else
               y++;;
            break;
         default:
         
            break;
      
      }
      return worked;
   }
   public static void teleport(int xPos, int yPos)
   {
      if (teleportEnergy>=requiredEnergy)
      {
         teleportEnergy-=requiredEnergy;
         int chanceAlsoThis=(int)(Math.random()*5)+1;
        
         int chance=(int)(Math.random()*100)+1;
         //System.out.println(chance);
         if (chance<51)// works
         {
            x=xPos;
            y=yPos;
         }
         else if (chance<76)// doesn't work
         {
            System.out.println("The magic doesn't work");
         }
         else // random chance
         {
            for (int t=0;t<chanceAlsoThis;t++)
            {
               int chanceAlso=(int)(Math.random()*4);
               if (chanceAlso==0)
                  xPos++;
               else if (chanceAlso==1)
                  xPos--;
               else if (chanceAlso==2)
                  yPos++;
               else
                  yPos--;
            }
            
            x=xPos;
            y=yPos;
            while (x>width-2)
            {
               x--;
               //System.out.println("test1");
            }
            while (x<1)
            {
               x++;
               //System.out.println("test3");
            }
            while (y>height-2)
            {
               y--;
               //System.out.println("test4");
            }
            while (y<1)
            {
               y++;
               //System.out.println("test2");
            }
         }
         
      
      
      }
      else 
         System.out.println("You don't have enough magic energy, you can teleport again in "+ (requiredEnergy-teleportEnergy) + " round(s)");
   }
}
