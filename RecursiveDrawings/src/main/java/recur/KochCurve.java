package recur;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class KochCurve extends AbstractShape{


	KochCurve( Graphics g,double height, double width) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.GREEN);				
		drawKochCurve(g2, level, 10, height/2, width-10, height/2+1);

	}
	
	public void draw(Graphics g) {
		
		
	}
	/**
	 * Draw a Koch curve with a given level of recursion from
	 * the point A=(ax,ay) to the point B=(bx,by).  The level should
	 * be greater than or equal to 1.  A curve of level 1
	 * is just a straight line.
	 */
	void drawKochCurve(Graphics g, int level, double ax, double ay, 
			double bx, double by) {
		if (level <= 1) {
			g.drawLine((int)ax,(int)ay,(int)bx,(int)by);
		}
		else {
			
			double sqrt3 = Math.sqrt(3);

			double cx = (2*ax + bx)/3;  
			double cy = (2*ay + by)/3;

			double ex = (ax + 2*bx)/3;  
			double ey = (ay + 2*by)/3;

			double hx = (ax + bx)/2; 
			double hy = (ay + by)/2;

			double dx = hx + sqrt3*(ey-hy);  
			double dy = hy - sqrt3*(ex-hx);

			drawKochCurve(g, level-1, ax, ay, cx, cy);  // Draw the four Koch curves
			drawKochCurve(g, level-1, cx, cy, dx, dy);
			drawKochCurve(g, level-1, dx, dy, ex, ey);
			drawKochCurve(g, level-1, ex, ey, bx, by);

		}
	}
}
