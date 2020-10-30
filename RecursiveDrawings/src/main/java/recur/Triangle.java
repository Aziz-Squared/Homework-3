package recur;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Point;

public class Triangle extends AbstractShape {

    
    Polygon polygon;
    public int size;
    Point pointA;
    Point pointB;
    Point pointC;

    public Triangle(int s) {

        polygon = new Polygon();
        size = s;
        level = 1;

        int triangleHeight = (int) Math.round(size * Math.sqrt(3.0) / 2.0);
        pointA = new Point(0, triangleHeight);
        pointB = new Point(size / 2, 0);
        pointC = new Point(size, triangleHeight);
        polygon.addPoint(pointA.x, pointA.y);
        polygon.addPoint(pointB.x, pointB.y);
        polygon.addPoint(pointC.x, pointC.y);
    }

   public static void drawTriangle(Graphics g, Point p1, Point p2, Point p3) {

 // creating a polygon with the points and filling it

     Polygon p = new Polygon();
     p.addPoint(p1.x, p1.y);
     p.addPoint(p2.x, p2.y);
     p.addPoint(p3.x, p3.y);
     g.fillPolygon(p);
    }

  // draw three triangles Level-2 Sierpinski triangle based on single triangle.

    public static void drawTripleTriangles(Graphics g, Point p1, Point p2,

                                    Point p3) {

 // get the three middle points between p1 and p2, p1 and p3, p2 and p3

   Point p4 = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
   Point p5 = new Point((p2.x + p3.x) / 2, (p2.y + p3.y) / 2);
   Point p6 = new Point((p1.x + p3.x) / 2, (p1.y + p3.y) / 2);
    }


 // Draws a general level-n Sierpinski triangle whose vertices are (p1, p2,p3).



    public static void drawSierpinski(int n, Graphics g, Point p1, Point p2,Point p3) {

         if (n == 1) {
         drawTriangle(g, p1, p2, p3);
         } else {

  // get the three middle points between p1 and p2, p1 and p3, p2 and

     Point p4 = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
     Point p5 = new Point((p2.x + p3.x) / 2, (p2.y + p3.y) / 2);
     Point p6 = new Point((p1.x + p3.x) / 2, (p1.y + p3.y) / 2);

  // using recursive call to draw three sub-triangles, with one less value for n.

     drawSierpinski(n - 1, g, p1, p4, p6);
     drawSierpinski(n - 1, g, p4, p2, p5);
     drawSierpinski(n - 1, g, p6, p5, p3);

                    }

    }

	/*
	 * @Override public boolean addLevel() {
	 * if (children == null) { // need code to add a level return true; } else {
	 * return addLevel(); } }
	 */
    public Point midPoint(Point p1, Point p2){

        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }

	
	 public void createChildren() { 
		 children[0] = this;
	  }
	 
    @Override
    public void draw(Graphics g) {

        //g.fillPolygon(polygon);
        g.drawPolygon(polygon);

    }

}
