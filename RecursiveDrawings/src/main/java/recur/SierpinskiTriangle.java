package recur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

public class SierpinskiTriangle extends AbstractShape {

	private Polygon poly;
	private Point p1, p2, p3;
	private int triangleHeight = (int) Math.round(800 * Math.sqrt(3.0) / 2.0);
	// Graphics graphics;

	SierpinskiTriangle() {
		super(3);
		poly = new Polygon();
		p1 = new Point(0, 800);
		p2 = new Point(400, 0);
		p3 = new Point(800, 800);
		poly.addPoint(p1.x, p1.y);
		poly.addPoint(p2.x, p2.y);
		poly.addPoint(p3.x, p3.y);

		System.out.println("First constructor");

	}

	SierpinskiTriangle(Point newPoint1, Point newPoint2, Point newPoint3) {
		super(3);
		// this.graphics = g;
		poly = new Polygon();
		p1 = newPoint1;
		p2 = newPoint2;
		p3 = newPoint3;
		poly.addPoint(p1.x, p1.y);
		poly.addPoint(p2.x, p2.y);
		poly.addPoint(p3.x, p3.y);

		// System.out.println("Second Constructor");

	}

	public void draw(Graphics g) {

		g.drawPolygon(poly);
		if (children[0] != null) {

			for (int i = 0; i < children.length - 1; i++) {
				children[i].draw(g);
			}

		}

	}

	public void createChildren() {

		Point p4 = new Point(midPoint(p1, p2));
		Point p5 = new Point(midPoint(p2, p3));
		Point p6 = new Point(midPoint(p1, p3));

		children[0] = new SierpinskiTriangle(p1, p4, p6);
		children[1] = new SierpinskiTriangle(p4, p2, p5);
		children[2] = new SierpinskiTriangle(p6, p5, p3);

	}

	public static Point midPoint(Point p1, Point p2) {
		return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
	}

	@Override
	public void update(int value) {
		// TODO Auto-generated method stub

	}

}
