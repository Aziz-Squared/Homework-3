package recur;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Point;

public class SierpinskiTriangle extends AbstractShape {
	
	Polygon sierpinskiTriangle;
	private static int maxLevel = 10;
	private static int length = 3;
	
	 private int height = (int) Math.round(800 / 1.35);        
     
     Point peak = new Point(800 / 2, 0);
     Point leg_1 = new Point(800, height);
     Point leg_2 = new Point(0, height);
	


	public SierpinskiTriangle(Point p1, Point p2, Point p3) {
		super(maxLevel, length);
		// TODO Auto-generated constructor stub
    
<<<<<<< HEAD
    Polygon polygon;
    int size;
    int triangleHeight;
    Point pointA;
    Point pointB;
    Point pointC;

    public Triangle(int s) {

        polygon = new Polygon();
        size = s;
        level = 1;

        triangleHeight = (int) Math.round(size * Math.sqrt(3.0) / 2.0);
        pointA = new Point(0, triangleHeight);
        pointB = new Point(size / 2, 0);
        pointC = new Point(size, triangleHeight);
        polygon.addPoint(pointA.x, pointA.y);
        polygon.addPoint(pointB.x, pointB.y);
        polygon.addPoint(pointC.x, pointC.y);
=======
        // Triangle's peak
//        sierpinskiTriangle.addPoint(peak.x, peak.y);
//        // Legs
//        sierpinskiTriangle.addPoint(leg_1.x, leg_1.y);
//        sierpinskiTriangle.addPoint(leg_2.x, leg_2.y);
//        
        sierpinskiTriangle = new Polygon(new int[] {p1.x, p2.x, p3.x}, new int[] {p1.y, p2.y, p3.y}, 3);
        

>>>>>>> 1cb0c559f2b658dc23ddbf5e99d3ba010229a177
    }

	/**
	 * Draws this triangle
	 */
	public void draw(Graphics g) {
		
		if (children[0] == null) {
			g.setColor(Color.green);
	        g.drawPolygon(sierpinskiTriangle);
		} else {
        	for (int i = 0; i < children.length; i++) {
        		children[i].draw(g);
        		//g.drawPolygon(new int[] {mp1.x, mp2.x, mp3.x}, new int[] {mp1.y, mp2.y, mp3.y}, 3);
        	}
        }
    }
    
    /**
     * Creates children for this shape
     */
	@Override
	public void createChildren() {
		
		Point mp1 = midPoint(peak,leg_1);
		Point mp2 = midPoint(peak, leg_2);
		Point mp3 = midPoint(leg_1, leg_2);
		
		children[0] = new SierpinskiTriangle(mp1, mp3, leg_1);
		children[1] = new SierpinskiTriangle(mp2, mp3, leg_2);
		children[2] = new SierpinskiTriangle(mp1, mp2, peak);
	}

	/**
	 * EXTRA CREDIT
	 * Modifies this shape in an interesting way given a value in the range 0-100.
	 * Initially the slider should be set to 50.
	 * 
	 * @param int value - range between 0-100
	 */
	@Override
	public void update(int value) {
		// TODO Auto-generated method stub
		
	}

}

// import java.awt.Graphics;
// import java.awt.Color;
// import java.awt.Polygon;
// import java.awt.Point;

<<<<<<< HEAD
    @Override
    public boolean addLevel() {
        
        if (level == 1){
            level++;
            return true;
        } else if(level == 10){
            return false;
        } else{
            System.out.println("on level: " + level);
        }
        
        return addLevel();
    }
  // draw three triangles Level-2 Sierpinski triangle based on single triangle.
=======
// public class Triangle extends AbstractShape {
>>>>>>> 1cb0c559f2b658dc23ddbf5e99d3ba010229a177

    
//     Polygon polygon;
//     public int size;
//     Point pointA;
//     Point pointB;
//     Point pointC;

//     public Triangle(int s) {

//         polygon = new Polygon();
//         size = s;
//         level = 1;

//         int triangleHeight = (int) Math.round(size * Math.sqrt(3.0) / 2.0);
//         pointA = new Point(0, triangleHeight);
//         pointB = new Point(size / 2, 0);
//         pointC = new Point(size, triangleHeight);
//         polygon.addPoint(pointA.x, pointA.y);
//         polygon.addPoint(pointB.x, pointB.y);
//         polygon.addPoint(pointC.x, pointC.y);
//     }

//    public static void drawTriangle(Graphics g, Point p1, Point p2, Point p3) {

//  // creating a polygon with the points and filling it

//      Polygon p = new Polygon();
//      p.addPoint(p1.x, p1.y);
//      p.addPoint(p2.x, p2.y);
//      p.addPoint(p3.x, p3.y);
//      g.fillPolygon(p);
//     }

//   // draw three triangles Level-2 Sierpinski triangle based on single triangle.

//     public static void drawTripleTriangles(Graphics g, Point p1, Point p2,

//                                     Point p3) {

//  // get the three middle points between p1 and p2, p1 and p3, p2 and p3

//    Point p4 = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
//    Point p5 = new Point((p2.x + p3.x) / 2, (p2.y + p3.y) / 2);
//    Point p6 = new Point((p1.x + p3.x) / 2, (p1.y + p3.y) / 2);
//     }


//  // Draws a general level-n Sierpinski triangle whose vertices are (p1, p2,p3).



//     public static void drawSierpinski(int n, Graphics g, Point p1, Point p2,Point p3) {

//          if (n == 1) {
//          drawTriangle(g, p1, p2, p3);
//          } else {

//   // get the three middle points between p1 and p2, p1 and p3, p2 and

//      Point p4 = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
//      Point p5 = new Point((p2.x + p3.x) / 2, (p2.y + p3.y) / 2);
//      Point p6 = new Point((p1.x + p3.x) / 2, (p1.y + p3.y) / 2);

//   // using recursive call to draw three sub-triangles, with one less value for n.

//      drawSierpinski(n - 1, g, p1, p4, p6);
//      drawSierpinski(n - 1, g, p4, p2, p5);
//      drawSierpinski(n - 1, g, p6, p5, p3);

//                     }

//     }

// 	/*
// 	 * @Override public boolean addLevel() {
// 	 * if (children == null) { // need code to add a level return true; } else {
// 	 * return addLevel(); } }
// 	 */
//     public Point midPoint(Point p1, Point p2){

//         return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
//     }

	
// 	 public void createChildren() { 
// 		 children[0] = this;
// 	  }
	 
//     @Override
//     public void draw(Graphics g) {

//         //g.fillPolygon(polygon);
//         g.drawPolygon(polygon);

//     }

// }
