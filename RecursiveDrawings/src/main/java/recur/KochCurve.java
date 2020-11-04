package recur;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;



public class KochCurve extends AbstractShape {
	protected static final int maxLevel = 7;
	int x1cord, y1cord, x2cord, y2cord;

	/**
	 * Construct a new MyShape. This constructor is for the initial root shape.
	 *
	 * @param width  The width of the display.
	 * @param height The height of the display.
	 */

	KochCurve(int height, int width) {
		this(0, height / 2, width, height / 2 + 1, 1);

	}

	KochCurve(int x1cord, int y1cord, int x2cord, int y2cord, int level) {
		super(x1cord, y1cord, y2cord, y2cord, maxLevel, level);
		this.x1cord = x1cord;
		this.y1cord = y1cord;
		this.x2cord = x2cord;
		this.y2cord = y2cord;
	}

	@Override
	public void createChildren() {
		this.children = new AbstractShape[4];
		int newlevel = level + 1;
		double sqrt3 = Math.sqrt(3);

		double x3cord = (2 * x1cord + x2cord) / 3;
		double y3cord = (2 * y1cord + y2cord) / 3;

		double x5cord = (x1cord + 2 * x2cord) / 3;
		double y5cord = (y1cord + 2 * y2cord) / 3;

		double x6cord = (x1cord + x2cord) / 2;
		double y6cord = (y1cord + y2cord) / 2;

		double x4cord = x6cord + sqrt3 * (y5cord - y6cord);
		double y4cord = y6cord - sqrt3 * (x5cord - x6cord);

		children[0] = new KochCurve(x1cord, y1cord, (int) x3cord, (int) y3cord, newlevel);
		children[1] = new KochCurve((int) x3cord, (int) y3cord, (int) x4cord, (int) y4cord, newlevel);
		children[2] = new KochCurve((int) x4cord, (int) y4cord, (int) x5cord, (int) y5cord, newlevel);
		children[3] = new KochCurve((int) x5cord, (int) y5cord, x2cord, y2cord, newlevel);
	}
		

	
	@Override
	protected void drawBaseShape(Graphics g) {
		g.drawLine(x1cord, y1cord, x2cord, y2cord);
	}
}