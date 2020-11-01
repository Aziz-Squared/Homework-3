package recur;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Point;
import java.awt.Color;

public class HShape extends AbstractShape {

    private int HEIGHT, WIDTH;
    private Point rect1, rect2, rect3, rect4, rect5, rect6, rect7;

    public HShape(int height, int width) {
        super(7, 5);

        HEIGHT = height;
        WIDTH = width;

        rect1 = new Point(WIDTH - WIDTH, HEIGHT / 3);
        rect2 = new Point(WIDTH - WIDTH, (HEIGHT / 3) * 2);
        rect3 = new Point(WIDTH - WIDTH, HEIGHT);

        rect4 = new Point((WIDTH / 3) * 2, HEIGHT / 3);
        rect5 = new Point((WIDTH / 3) * 2, (HEIGHT / 3) * 2);
        rect6 = new Point((WIDTH / 3) * 2, HEIGHT);
        
        rect7 = new Point(WIDTH / 3, (HEIGHT / 3));

    }

    public void createChildren() {

        for (int i = 0; i < children.length; i++){
            
        }

    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.GREEN);
        // Top left rectangle
        g.drawRect(rect1.x, rect1.x, rect1.y, rect1.y);
        // Middle left rectangle
        g.drawRect(rect2.x, rect1.y, rect1.y, rect1.y);
        // Bottom left rectangle
        g.drawRect(rect3.x, rect2.y, rect1.y, rect3.y);
        // Top right rectangle
        g.drawRect(rect4.x, rect1.x, rect6.y, rect4.y);
        // Middle right rectangle
        g.drawRect(rect5.x, rect4.y, rect6.y, rect4.y);
        // Bottom right rectangle
        g.drawRect(rect6.x, rect5.y, rect6.y, rect6.y);
        // Center rectangle
        g.fillRect(rect7.x, rect7.x, rect6.x, rect6.x);

        // System.out.println("x position: " + rect2.x);
        // System.out.println("y position: " + rect2.y);
        // System.out.println("height: " + HEIGHT + " width: " + WIDTH);

        

        // if (children[0] != null) {

        //     for (int i = 0; i <= children.length - 1; i++) {
        //         children[i].draw(g);
        //     }

        // }

    }

    public void update(int value) {

    }
}
