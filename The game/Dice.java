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
public class Dice
{
   public static int roll(int x,int y)
   {
   int total=0;
   for (int z=0;z<x;z++)
   {
   //System.out.println(total);
   total=total+(int)(Math.random()*y+1);
   }
   return total;
   }
   
   public static void main(String[] args)
   {
   
   System.out.println(roll(5,8));
   }
}