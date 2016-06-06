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

public class Intro extends JPanel
{
   public void paintComponent(Graphics g)
   {
      g.setColor(Color.BLACK);
      g.fillRect(0,0,1000,1000);
      g.setColor(Color.WHITE);
      g.setFont(new Font("Agency FB Bold",1,22));
      g.drawString("      In the beginning, there were many rifts, scattered throughout the solar system. They were distant to each other, but travel ",5,25);
      g.drawString("between them was possible. After years of disparity between the rifts, a great magician suggested that we combine the rifts,",5,50);
      g.drawString("into a great world called Exeriarsis. The world thrived, a combination of all the rifts spread out across the solar system.",5,75);
      g.drawString("Though there was happiness with the advent of so many new and exciting things from this combination, there was also doubt.",5,100);
      g.drawString("Evil rose from the depths, and corruption plagued the world. There was a war of wizards, known as the Arcane triumph, during",5,125);
      g.drawString("which Seven Swords of great power were forged. Seven of the most powerful wizards were each handed one to channel ",5,150);
      g.drawString("their arcane powers through and defeat the corruption. Though it is referred to as a triumph, many worlds were lost. Entire",5,175);
      g.drawString("countries disappeared from the face of Exeriarsis and the inhabitants never heard from again, until now. There have been",5,200);
      g.drawString("reports of zones not seen in centuries coming into existence once again. But these reincarnations of the old races of",5,225);
      g.drawString("Exeriarsis are not the grand civilizations they used to be. They are something else, vile monstrosities of another existence.",5,250);
      g.drawString("The seven swords were hidden in the earth a long time ago and now need to be brought together once again.  And returned to",5,275);
      g.drawString("the rightful owners. The wizards of the past. But they too, lay deep, in the Tomb of Seven.",5,300);
   }
}