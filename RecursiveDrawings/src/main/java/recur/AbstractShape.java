package recur;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public abstract class AbstractShape implements Shape {

   protected AbstractShape[] children; // the array of children shapes
   protected int level, width, height, drawStartX, drawStartY; // level, width and height of the graphics frame, origin starting at (0,0)
   protected final int maxLevel;        // max level determined by each shape class
   protected Color color;               // the color the shape will be drawn in
   protected double sliderVal = 1.0; // slider value that skews the shapes
   public static int count;           // the number of shapes in the display
   private static Random rand = new Random();


   protected AbstractShape(int drawStartX, int drawStartY, int width, int height, int maxLevel, int level) {
       this(maxLevel,level);
       this.drawStartX = drawStartX;
       this.drawStartY = drawStartY;
       this.width = width;
       this.height = height;
   }


   protected AbstractShape(int maxLevel, int level) {
       this.maxLevel = maxLevel;
       this.level = level;
       this.color = new Color(rand.nextInt());
   }

 
   @Override
   public void draw(Graphics g) {
       g.setColor(color);
       if (children == null) {
           drawBaseShape(g);
       } else {
           for (AbstractShape child : children) {
               child.draw(g);
           }
       }
   }
   /**
   * Draw the base shape
   */
   protected abstract void drawBaseShape(Graphics g);


   @Override
   public boolean addLevel() {
	   System.out.println(level);
       if (level == maxLevel) {
           return false;
       } else if (children != null) {
           for (Shape child : children) {
               if (!child.addLevel()) {
                   return false;
               }
           }
       } else {
           createChildren();
       }
       count = countShapes();
       return true;
      
   }

   
   @Override
   public boolean removeLevel() {

       if (children == null) {
           return false;
       } else if (children[0].children == null) {
           children = null;
       } else {
           for (AbstractShape child : children) {
               child.removeLevel();
           }
       }
       count = countShapes();
       return true;

   }

 
   @Override
   public int countShapes() {
       if (children != null) {
           int numOfShapes = 0;
           for (AbstractShape child : children) {
               numOfShapes += child.countShapes();
           }
           return numOfShapes;
       } else {
           return 1;
       }
   }
  
 
   public static int getCount() {
       return count;
   }
  

 
   @Override
   public void update(int value) {
       sliderVal = value / 50.0;
       int depth = findDepth();
       children = null;
       createChildrenAtDepth(depth);
   }


   private void createChildrenAtDepth(int depth) {
       if (depth > 1) {
           createChildren();
           depth--;
           for (AbstractShape child : children) {
               child.createChildrenAtDepth(depth);
           }
       }
   }

 
   private int findDepth() {
       if (children == null) {
           return 1;
       } else {
           return 1 + children[0].findDepth();
       }
   }

 
   public abstract void createChildren();

}