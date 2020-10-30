package recur;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

public class SierpinskiTriangle extends AbstractShape {

	SierpinskiTriangle(Graphics g,  double ax, double ay, double bx, double by, double cx,
			double cy) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.GREEN);				
	
		drawSierpinskiTriangle(g2,level,ax,ay,bx,by,cx,cy);
	}
	


	/**
	 * Draw a Sierpinski Triangle with a given recursion level, with vertices at the
	 * points A=(ax,ay), B=(bx,by), and C=(cx,cy). For recursion level 1, a triangle
	 * is drawn with these vertices. For recursion level greater than 1, three
	 * smaller Sierpinski Triangles, with recursion level one smaller, are drawn.
	 */
	public void drawSierpinskiTriangle(Graphics g,  int level, double ax, double ay, double bx, double by, double cx,
			double cy) {
		
		Point p1 = new Point();
		p1.setLocation(ax, ay);
		Point p2 = new Point();
		p2.setLocation(bx, by);
		Point p3 = new Point();
		p3.setLocation(cx, cy);

		drawFigure(level, g, p1, p2, p3);
	}

public static void drawFigure(int level, Graphics g,  Point p1, Point p2, Point p3) {
		if (level == 1) {
			//base case: simple triangle
				Polygon p = new Polygon();
				p.addPoint(p1.x, p1.y);
				p.addPoint(p2.x, p2.y);
				p.addPoint(p3.x, p3.y);
				g.drawPolygon(p);
				//g.fillPolygon(p);
				} else {
					//recursive case, split into 3 triangles
					Point p4 = midpoint(p1, p2);
					Point p5 = midpoint(p2, p3);
					Point p6 = midpoint(p1, p3);

					//recurse on 3 triangular areas
					drawFigure(level - 1, g, p1, p4, p6);
					drawFigure(level - 1, g, p4, p2, p5);
					drawFigure(level - 1, g, p6, p5, p3);
				}
		}
	public static Point midpoint(Point p1, Point p2) {
    return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
}

}
