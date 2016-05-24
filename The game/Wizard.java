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
   static String name;
   static int x;
   static int y;
   static int width;
   static int height;
   static int maxEnergy=21;
   static int charLevel;
   static int maxHP;
   static int currentHP;
   static int attack;
   static int maxMana;
   static int currentMana;
   static boolean sex;
   // false=guy true=girl
   static String charClass;
   static String[] Inventory;
   static String[] equippedWeapon;
   static ArrayList<String> abilities= new ArrayList<String>();
   //index 0=name, 1=damage, 2=attack, 
   static ImageIcon weezard;
   //Game2 test=new Game2();
   public Wizard(String title/*,int length,int tall*/)
   {
      name=title;
      width=Game2.width;
      height=Game2.height;
      charLevel=1;
      sex=false;
     // x=(int)(Math.random()*(length-2)+1);
      //y=(int)(Math.random()*(height-2)+1);
       //System.out.println(x+" "+y);
      abilities.add("Attack");
      abilities.add("Defend");
      charClass="Warrior";
      abilities.add("power attack");
      setImage(0,0);
   
   }
   public Wizard(String title/*, int length, int tall*/,String clas,int level,boolean gender)
   {
      name=title;
      width=Game2.width;
      height=Game2.height;
      sex=gender;
     // x=(int)(Math.random()*(length-2)+1);
      //y=(int)(Math.random()*(height-2)+1);
      abilities.add("Attack");
      abilities.add("Defend");
      charClass=clas;
      charLevel=level;
      setImage(0,0);
      switch (charClass)
      {
         case "Warrior":
            abilities.add("Power Attack");
         // increased damage but decreased chance to hit
            break;
         case "Mage":
            maxMana=charLevel*20;
            currentMana=charLevel*20;
            abilities.add("Fireball(5 mana)");
         // uses mana, can only cast 4 firebolts at level one
            break;
         case "Archer":
            abilities.add("True Shot");
         // decreased damage but increased chance to hit
            break;
         case "Rogue":
            abilities.add("Sucker Punch");
      }
   }
   public static void setImage(int direction,int pos)
   {
      if (pos==2)pos=0;
      String temp="CharacterImages\\\\"+direction;
      if (sex)
         temp=temp+"Female";
      else 
         temp=temp+"Male";
      temp=temp+charClass+pos+".png";
      //System.out.println(temp);
      weezard = new ImageIcon(temp);
   }
   public int getX()
   {
      return x;
   }
   public int getY()
   {
      return y;
   }
   public int getLevel()
   {
      return charLevel;
   }
   public int getMaxHP()
   {
      return maxHP;
   }
   public int getCurrentHP()
   {
      return currentHP;
   }
   public int getCurrentMana()
   {
      return currentMana;
   }
   public String getSex()
   {
   if (sex)
   return "Female";
   else
   return "Male";
   }
   public String getName()
   {
      return name;
   }
   public ArrayList<String> getAbilities()
   {
      return abilities;
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
   public static void restoreMana(int newMana)
   {
      currentMana=currentMana+newMana;
      if (currentMana>maxMana)
         currentMana=maxMana;
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
      if (currentMana>=7)
      {
         currentMana-=7;
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
         System.out.println("You only have "+currentMana+" mana. To teleport you require 7 mana.");
   }
}