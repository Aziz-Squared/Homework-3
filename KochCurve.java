package RecursionGroup;
    
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class KochCurve extends AbstractShape {

	KochCurve( Graphics g,double height, double width, int kmaxlevel, int klevel) {
		super(kmaxlevel, klevel);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.GREEN);		
		if(level == 0) {
			level = 1;
		}
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

			/* Draw level-1 Koch curves from A to C, from C to
			 * D, from D to E, and from E to B, where C, D, E
			 * are computed as follows. */

			double cx = (2*ax + bx)/3;  // C is 1/3 of the way from A to B
			double cy = (2*ay + by)/3;

			double ex = (ax + 2*bx)/3;  // E is 1/3 of the way from B to A
			double ey = (ay + 2*by)/3;

			double hx = (ax + bx)/2; // Half-way point from A to B (not used in drawing)
			double hy = (ay + by)/2;

			double dx = hx + sqrt3*(ey-hy);  // D is the 3rd vertex of an equilateral triangle with C and E
			double dy = hy - sqrt3*(ex-hx);

			drawKochCurve(g, level-1, ax, ay, cx, cy);  // Draw the four Koch curves
			drawKochCurve(g, level-1, cx, cy, dx, dy);
			drawKochCurve(g, level-1, dx, dy, ex, ey);
			drawKochCurve(g, level-1, ex, ey, bx, by);

		}
	}
}
