package recur;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Point;
import java.awt.Color;

public class HShape extends AbstractShape {

    private int HEIGHT, WIDTH;
    private Graphics graphics;
    private Point[] points;
    // private Point rect1Start, rect2Start, rect3Start, rect4Start, rect5Start,
    // rect6Start, rect7Start, rectMiddleTopStart, rectMiddleBottomStart;
    // private Point rect1End, rect2End, rect3End, rect4End, rect5End, rect6End,
    // rect7End, rectMiddleTopEnd, rectMiddleBottomEnd;

    public HShape(int height, int width, Graphics g) {
        super(9, 5);

        HEIGHT = height;
        WIDTH = width;
        graphics = g;
        points = newDim(new Point(0, 0), new Point(800, 800));
        System.out.println("Creating h");


    }

    public void createChildren() {

        

    }

    @Override
    public void draw(Graphics g) {

        for (int i = 1; i <= 17; i += 2) {
            if ((i - 1) == 6 || (i - 1) == 10) {
                g.setColor(Color.BLACK);
                g.fillRect(points[i - 1].x, points[i - 1].y, points[i].x, points[i].y);
            } else {
                g.setColor(Color.GREEN);
                g.fillRect(points[i - 1].x, points[i - 1].y, points[i].x, points[i].y);

            }
            System.out.println("Starting point: " + points[i - 1] + " " + (i - 1));
            System.out.println("Ending point: " + points[i] + " " + i);

        }

        if (children[0] != null) {

            for (int i = 0; i <= children.length - 1; i++) {
                children[i].draw(g);
            }
        }

    }

    public Point[] newDim(Point newLimit, Point newLimit2) {

        WIDTH = newLimit2.x - newLimit.x;
        HEIGHT = newLimit2.y - newLimit.y;
        int widthZero = WIDTH - WIDTH;
        int heightZero = HEIGHT - HEIGHT;
        int widthThird = WIDTH / 3;
        int heightThird = HEIGHT / 3;

        return new Point[] { new Point(widthZero, heightZero), new Point(widthThird, heightThird),
                new Point(widthZero, heightThird), new Point(widthThird, heightThird * 2),
                new Point(widthZero, heightThird * 2), new Point(widthThird, HEIGHT), new Point(widthThird, heightZero),
                new Point(widthThird * 2, heightThird), new Point(widthThird, heightThird),
                new Point(widthThird * 2, heightThird * 2), new Point(widthThird, heightThird * 2),
                new Point(widthThird * 2, HEIGHT), new Point(widthThird * 2, heightZero), new Point(WIDTH, heightThird),
                new Point(widthThird * 2, heightThird), new Point(WIDTH, heightThird * 2),
                new Point(widthThird * 2, heightThird * 2), new Point(WIDTH, HEIGHT) };

    }

    public void update(int value) {

    }
}
