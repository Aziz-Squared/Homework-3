package recur;

import java.awt.Color;
import java.awt.Graphics;

public class KochCurve extends AbstractShape {
	
	int ax, ay, bx, by;
	
	int height, width;

	KochCurve(int height, int width) {
		super(4, 10);
		
		this.height = height;
		this.width = width;
		
		this.ax = 10;
		this.ay = height/2;
	 	this.bx = width-30;
		this.by = height/2+1;
	}
	
	KochCurve(int  ax, int ay, int bx, int by) {
		super(4, 10);
		
		this.ax = ax;
		this.ay = ay;
		this.bx  = bx;
		this.by = by;
	}

	public void draw(Graphics g) {
		g.drawLine(ax,ay,bx,by);
		if (children[0] != null) {
			for (int i = 0; i <= children.length - 1; i++) {
				children[i].draw(g);
			}
		}
	}
	
	@Override
	public void createChildren() {
		double sqrt3 = Math.sqrt(3);

		double cx = (2 * ax + bx) / 3;
		double cy = (2 * ay + by) / 3;

		double ex = (ax + 2 * bx) / 3;
		double ey = (ay + 2 * by) / 3;

		double hx = (ax + bx) / 2;
		double hy = (ay + by) / 2;

		double dx = hx + sqrt3 * (ey - hy);
		double dy = hy - sqrt3 * (ex - hx);
		
		children[0] = new KochCurve(ax, ay, (int)cx, (int)cy);
		children[1] = new KochCurve((int)cx, (int)cy, (int)dx, (int)dy);
		children[2] = new KochCurve((int)dx, (int)dy, (int)ex, (int)ey);
		children[3] = new KochCurve((int)ex, (int)ey, bx, by);
	}
	
	@Override
	public int countShapes() {
		int count = 0;
		if (children[0] == null) {
			return 1;
		}
		else {
			for (int i = 0; i < children.length; i++) {
				count = children.length * children[i].countShapes();			
			}
		} return count;
	}
	

	@Override
	public void update(int value) {
		// TODO Auto-generated method stub

	}
}
