package recur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

public class SierpinskiTriangle extends AbstractShape {

	Polygon poly;
	Point p1, p2, p3;
	Graphics graphics;

	SierpinskiTriangle(Graphics g) {
		super(3);
		this.graphics = g;
		poly = new Polygon();
		p1 = new Point(0, 800);
		p2 = new Point(400, 0);
		p3 = new Point(800, 800);
		poly.addPoint(p1.x, p1.y);
		poly.addPoint(p2.x, p2.y);
		poly.addPoint(p3.x, p3.y);

		graphics.drawPolygon(poly);

	}

	SierpinskiTriangle(Graphics g, Point newPoint1, Point newPoint2, Point newPoint3) {
		super(3);
		this.graphics = g;
		poly = new Polygon();
		p1 = newPoint1;
		p2 = newPoint2;
		p3 = newPoint3;
		poly.addPoint(newPoint1.x, newPoint1.y);
		poly.addPoint(newPoint2.x, newPoint2.y);
		poly.addPoint(newPoint3.x, newPoint3.y);

		graphics.drawPolygon(poly);

	}

	public void draw(Graphics g) {
		g.drawPolygon(poly);

	}

	public void createChildren() {

		Polygon newPoly = new Polygon();
		Point p4 = new Point(midPoint(p1, p2));
		Point p5 = new Point(midPoint(p2, p3));
		Point p6 = new Point(midPoint(p1, p3));

		newPoly.addPoint(p4.x, p4.y);
		newPoly.addPoint(p5.x, p5.y);
		newPoly.addPoint(p6.x, p6.y);

		children[0] = new SierpinskiTriangle(graphics, p4, p5, p6);
		children[1] = new SierpinskiTriangle(graphics, p5, p4, p6);
		children[2] = new SierpinskiTriangle(graphics, p6, p4, p5);

	}

	public static Point midPoint(Point p1, Point p2) {
		return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
	}

}
