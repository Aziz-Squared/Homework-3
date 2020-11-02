package recur;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Point;
import java.awt.Color;

public class HShape extends AbstractShape {

    private int HEIGHT, WIDTH;
    private Point rect1Start, rect2Start, rect3Start, rect4Start, rect5Start, rect6Start, rect7Start;
    private Point rect1End, rect2End, rect3End, rect4End, rect5End, rect6End, rect7End; 

    public HShape(int height, int width) {
        super(7, 5);

        HEIGHT = height;
        WIDTH = width;

        // Starting points of all the rectangles
        rect1Start = new Point(WIDTH - WIDTH, HEIGHT - HEIGHT);
        rect2Start = new Point(WIDTH - WIDTH, HEIGHT / 3);
        rect3Start = new Point(WIDTH - WIDTH, (HEIGHT / 3) * 2);

        rect4Start = new Point((WIDTH / 3) * 2, HEIGHT - HEIGHT);
        rect5Start = new Point((WIDTH / 3) * 2, HEIGHT / 3);
        rect6Start = new Point((WIDTH / 3) * 2, (HEIGHT / 3) * 2);

        rect7Start = new Point(WIDTH / 3, HEIGHT / 3);

        // Ending points of all the rectangles
        rect1End = new Point(WIDTH / 3, HEIGHT / 3);
        rect2End = new Point(WIDTH / 3, HEIGHT / 3);
        rect3End = new Point(WIDTH / 3, HEIGHT);

        rect4End = new Point((WIDTH / 3) * 2, HEIGHT / 3);
        rect5End = new Point((WIDTH / 3) * 2, (HEIGHT / 3) * 2);
        rect6End = new Point((WIDTH / 3) * 2, HEIGHT);

        rect7End = new Point(rect3End.x, rect6Start.x / 2);


    }

    public HShape(Point newLimits1, Point newLimits2){
        super(7, 5);

        WIDTH = newLimits2.x - newLimits1.x;
        HEIGHT = newLimits2.y - newLimits1.y;

        // Starting points of all the rectangles
        rect1Start = new Point(WIDTH - WIDTH, HEIGHT - HEIGHT);
        rect2Start = new Point(WIDTH - WIDTH, HEIGHT / 3);
        rect3Start = new Point(WIDTH - WIDTH, (HEIGHT / 3) * 2);

        rect4Start = new Point((WIDTH / 3) * 2, HEIGHT - HEIGHT);
        rect5Start = new Point((WIDTH / 3) * 2, HEIGHT / 3);
        rect6Start = new Point((WIDTH / 3) * 2, (HEIGHT / 3) * 2);

        rect7Start = new Point(WIDTH / 3, HEIGHT / 3);

        // Ending points of all the rectangles
        rect1End = new Point(WIDTH / 3, HEIGHT / 3);
        rect2End = new Point(WIDTH / 3, HEIGHT / 3);
        rect3End = new Point(WIDTH / 3, HEIGHT);

        rect4End = new Point((WIDTH / 3) * 2, HEIGHT / 3);
        rect5End = new Point((WIDTH / 3) * 2, (HEIGHT / 3) * 2);
        rect6End = new Point((WIDTH / 3) * 2, HEIGHT);

        rect7End = new Point(rect3End.x, rect6Start.x / 2);
        

    }

    public void createChildren() {
        
        children[0] = new HShape(rect1Start, rect1End);
        children[1] = new HShape(rect2Start, rect2End);
        children[2] = new HShape(rect3Start, rect3End);
        children[3] = new HShape(rect4Start, rect4End);
        children[4] = new HShape(rect5Start, rect5End);
        children[5] = new HShape(rect6Start, rect6End);
        children[6] = new HShape(rect7Start, rect7End);
        System.out.println("adding h shape");

    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.GREEN);
        // Top left rectangle
        g.drawRect(rect1Start.x, rect1Start.y, rect1End.x, rect1End.y);
        // Middle left rectangle
        g.drawRect(rect2Start.x, rect2Start.y, rect2End.x, rect2End.y);
        // Bottom left rectangle
        g.drawRect(rect3Start.x, rect3Start.y, rect3End.x, rect3End.y);
        // Top right rectangle
        g.drawRect(rect4Start.x, rect4Start.y, rect4End.x, rect4End.y);
        // Middle right rectangle
        g.drawRect(rect5Start.x, rect5Start.y, rect5End.x, rect5End.y);
        // Bottom right rectangle
        g.drawRect(rect6Start.x, rect6Start.y, rect6End.x, rect6End.y);
        // Center rectangle
        g.drawRect(rect7Start.x, rect7Start.y, rect7End.x, rect7End.y);

        if (children[0] != null) {

            for (int i = 0; i <= children.length - 1; i++) {
                children[i].draw(g);
            }

        }
    }

    public void update(int value) {

    }
}
