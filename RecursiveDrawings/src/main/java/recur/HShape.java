package recur;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

public class HShape extends AbstractShape {

    private int HEIGHT, WIDTH;
    private Point[] points;

    public HShape(int height, int width) {
        super(9, 5);

        HEIGHT = height;
        WIDTH = width;
        points = newRectangles(new Point(0, 0), new Point(width, height));
        System.out.println("Creating h");

    }

    public void createChildren() {

        for (int i = 0; i <= children.length - 1; i++) {
            for (int j = 1; j <= 17; j += 2) {
                children[i] = new HShape(points[j - 1].y, points[j - 1].x);

            }
        }

    }

    @Override
    public void draw(Graphics g) {

        // Loops through the points array. Even index is starting points odd index is
        // ending points
        if (children[0] == null) {
            
            for (int i = 1; i <= 17; i += 2) {
                // Checks to see if the starting points are the two white squares
                if ((i - 1) == 6 || (i - 1) == 10) {
                    g.setColor(Color.WHITE);
                    g.fillRect(points[i - 1].x, points[i - 1].y, points[i].x, points[i].y);
                } else {
                    g.setColor(Color.GREEN);
                    g.fillRect(points[i - 1].x, points[i - 1].y, points[i].x, points[i].y);
    
                }
                System.out.println("Starting point: " + points[i - 1] + " " + (i - 1));
                System.out.println("Ending point: " + points[i] + " " + i);
    
            }

        } else {
            for (int i = 0; i <= children.length - 1; i++) {
                children[i].draw(g);
            }
        }

    }

    // Create the points of the rectangles
    public Point[] newRectangles(Point newLimit, Point newLimit2) {

        WIDTH = newLimit2.x - newLimit.x;
        HEIGHT = newLimit2.y - newLimit.y;
        int widthZero = WIDTH - WIDTH;
        int heightZero = HEIGHT - HEIGHT;
        int widthThird = WIDTH / 3;
        int heightThird = HEIGHT / 3;

        return new Point[] { new Point(widthZero, heightZero), new Point(widthThird, heightThird), // Rectangle 1
                new Point(widthZero, heightThird), new Point(widthThird, heightThird * 2), // Rectangle 2
                new Point(widthZero, heightThird * 2), new Point(widthThird, HEIGHT), // Rectangle 3
                new Point(widthThird, heightZero), new Point(widthThird * 2, heightThird), // Rectangle 4
                new Point(widthThird, heightThird), new Point(widthThird * 2, heightThird * 2), // Rectangle 5
                new Point(widthThird, heightThird * 2), new Point(widthThird * 2, HEIGHT), // Rectangle 6
                new Point(widthThird * 2, heightZero), new Point(WIDTH, heightThird), // Rectangle 7
                new Point(widthThird * 2, heightThird), new Point(WIDTH, heightThird * 2), // Rectangle 8
                new Point(widthThird * 2, heightThird * 2), new Point(WIDTH, HEIGHT) }; // Rectangle 9

    }

    public void update(int value) {

    }
}
