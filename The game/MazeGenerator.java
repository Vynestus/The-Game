import java.util.Collections;
import java.util.*;



public class MazeGenerator
{
   private int [][] maze;
   private int [][] items;
   /*
   0=empty
   1=stairs going up
   2=stairs goind down
   3=whatever the hell i want
   
   */
   private int sux,suy,sdx,sdy;
   private int [][] north;
   private int [][] south;
   private int [][] west;
   private int [][] east;
   private int width;
   private String name;
   private int height;
   private boolean printing=false;
   //ExtendedAscii t;
   public MazeGenerator()
   {
      width=10;
      height=10;
      gen();
   }
   public MazeGenerator(int x, int y)
   {
      width=x;
      height=y;
      gen();
   }
   public MazeGenerator(int x, int y,String title)
   {
      width=x;
      height=y;
      name=title;
      gen();
   }
   public int[] getStairs()
   {
      int[] stairArray= {sux,suy,sdx,sdy};
      return stairArray;
   }
   public void setName(String title)
   {
      name=title;
   }
   public int[][] getItems()
   {
      return items;
   }
   public int[][] getNorth()
   {
      return north;
   }
   public int[][] getEast()
   {
      return east;
   }
   public int[][] getSouth()
   {
      return south;
   }
   public int[][] getWest()
   {
      return west;
   }
   public int getWidth()
   {
      return width;
   }
   public int getHeight()
   {
      return height;
   }
   public String getName()
   {
      return name;
   }
   public int pickUpItems(int x,int y)
   {
      if (items[y][x]>3)
      {
         return items[y][x];
      } 
      else 
      {
         System.out.println("There's Nothing Here.");
         return 0;
      }
   }
   public void placeItems(int x,int y)
   {
   
   } 
   public void startingItems()
   {
      items=new int[height][width];
      while (sux*suy==sdy*sdx)
      {
      sux=(int)(Math.random()*(width-2)+1);
      suy=(int)(Math.random()*(height-2)+1);
      sdy=(int)(Math.random()*(height-2)+1);
      sdx=(int)(Math.random()*(width-2)+1);
      }
      
      items[suy][sux]=1;
      items[sdy][sdx]=2;
   
      //System.out.println("up at "+sux+","+suy+" down at "+sdx+","+sdy);
   }
   public void printWalls()
   {
      System.out.println(width);
      System.out.println(height);
      System.out.println("north");
      for(int y=0;y<height;y++)
      {
         for(int x=0;x<width;x++)
         {
            System.out.print(north[y][x]);
         }
         System.out.println();
      }
      
      System.out.println("east");
      
      for(int y=0;y<height;y++)
      {
         for(int x=0;x<width;x++)
         {
            System.out.print(east[y][x]);
         }
         System.out.println();
      }
      
      System.out.println("south");
      
      for(int y=0;y<height;y++)
      {
         for(int x=0;x<width;x++)
         {
            System.out.print(south[y][x]);
         }
         System.out.println();
      }
      
      System.out.println("west");
      
      for(int y=0;y<height;y++)
      {
         for(int x=0;x<width;x++)
         {
            System.out.print(west[y][x]);
         }
         System.out.println();
      }
   
   }
   public void gen()
   {
      int sum=0;
      Scanner c= new Scanner(System.in);
      //System.out.println("width: ");
      //width=c.nextInt();
      //System.out.println("height: ");
      //height=c.nextInt();
      int fin=(width-2)*(height-2);
      //System.out.println(fin);
      /*
      int [][] maze=new int[height][width];
      int [][] north=new int[height][width];
      int [][] south=new int[height][width];
      int [][] west=new int[height][width];
      int [][] east=new int[height][width];
      */
      maze=new int[height][width];
      north=new int[height][width];
      south=new int[height][width];
      west=new int[height][width];
      east=new int[height][width];
      // fills hte middle with 2's and sides in
      for(int x=0;x<width;x++)
      {
         for(int y=0;y<height;y++)
         {
            north[y][x]=1;
            south[y][x]=1;
            east[y][x]=1;
            west[y][x]=1;
            sum+=maze[y][x];
         // 1 means wall
         // 0 means empty
         }
         
      }
      
      //filling middle
      for(int y=0;y<height;y++)
      {
         for(int x=0;x<width;x++)
         {
            if (maze[y][x]==0)
               maze[y][x]=2;
         }
         
      }
      
      // instantiates starting spot
      int py=(int)(Math.random()*(height - 2)+1);
      int px=(int)(Math.random()*(width - 2)+1);
      
      maze[py][px]=1;
     
      // placing 0's at the side
      for(int a = 0; a < height; a++)
      {
         maze[a][0] = 0;
         maze[a][width - 1] = 0;
         
      } 
      for(int a = 0; a < width; a++)
      {
         
         maze[0][a] = 0;
         maze[height - 1][a]=0;
      } 
      
      
      if (maze[py - 1][px] != 0&&maze[py - 1][px] != 1)
         maze[py - 1][px]=3;
      if (maze[py + 1][px] != 0&&maze[py + 1][px] != 1)
         maze[py + 1][px]=3;
      if (maze[py][px+1] != 0&&maze[py][px+1] != 1)
         maze[py][px+1]=3;
      if (maze[py][px-1] != 0&&maze[py][px-1] != 1)
         maze[py][px-1]=3;
      
      //placing 3's around it
     
      //System.out.println(py+" "+px);
      
      
      int r = (int)(Math.random() * 4) + 1;
      int t;
      // filling in the next space
      if (printing)
      {
         for(int y=0;y<height;y++)
         {
            for(int x=0;x<width;x++)
            {
               System.out.print(maze[y][x]);
            }
            System.out.println();
         }
         System.out.println();
      
      }
      
      boolean tt=true;
      while(sum!=fin)
      {
         sum=0;
         py=(int)(Math.random()*(height - 2)+1);
         px=(int)(Math.random()*(width - 2)+1);
         
         // prints out the maze to see
         if (printing)
         {
            for(int y=0;y<height;y++)
            {
               for(int x=0;x<width;x++)
               {
                  System.out.print(maze[y][x]);
               }
               System.out.println();
            }
            System.out.println();
         }
      
      
         while (maze[py][px]!=3)
         {
            py=(int)(Math.random()*(height - 2)+1);
            px=(int)(Math.random()*(width - 2)+1);
         }
         
         
         
         
         if (maze[py - 1][px] != 0&&maze[py - 1][px] != 1)
            maze[py - 1][px]=3;
         if (maze[py + 1][px] != 0&&maze[py + 1][px] != 1)
            maze[py + 1][px]=3;
         if (maze[py][px+1] != 0&&maze[py][px+1] != 1)
            maze[py][px+1]=3;
         if (maze[py][px-1] != 0&&maze[py][px-1] != 1)
            maze[py][px-1]=3;
      
      
      
      
         
         while (tt)
         {
            r = (int)(Math.random() * 4) + 1;
            switch(r)
            {
               case 1:  //north movement
               
                  if(maze[py - 1][px] == 1)
                  {
                     maze[py][px]=1;
                     north[py][px]=0;
                     py--;
                     south[py][px]=0;
                     if (printing)
                        System.out.println("North from "+py+" "+px);
                     
                     tt=false;
                  }
                  break;
               case 2: //south
                  if(maze[py + 1][px] == 1)
                  {
                     maze[py][px]=1;
                     south[py][px]=0;
                     py++;
                     north[py][px]=0;
                     if (printing)
                        System.out.println("South from "+py+" "+px);
                  
                     tt=false;
                  }
                  break;
               case 3: //east
                  if(maze[py][px+1] == 1)
                  {
                     maze[py][px]=1;
                     east[py][px]=0;
                     px++;
                     west[py][px]=0;
                     if (printing)
                        System.out.println("East from "+py+" "+px);
                  
                  
                     tt=false;
                  }
                  break;
               case 4: //West
                  if(maze[py][px-1] == 1)
                  {
                     maze[py][px]=1;
                     west[py][px]=0;
                     px--;
                     east[py][px]=0;
                     if (printing)
                        System.out.println("West from "+py+" "+px);
                  
                  
                     tt=false;
                  }
                  break;
            }
         }
         /*for(int x=0;x<width;x++)
         {
            for(int y=0;y<height;y++)
            {
               System.out.print(maze[y][x]);
            }
            System.out.println();
         }*/
        
         for(int x=0;x<width;x++)
         {
            for(int y=0;y<height;y++)
            {
               sum+=maze[y][x];
            }
            
         }
         //System.out.println(sum);
         tt=true;  
      }
      startingItems();
   }
}