package recur;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Point;

public class Triangle extends AbstractShape {

    
    Polygon polygon;
    int size;
    int triangleHeight;
    Point pointA;
    Point pointB;
    Point pointC;

    public Triangle(int s) {

        polygon = new Polygon();
        size = s;
        level = 1;

        triangleHeight = (int) Math.round(size * Math.sqrt(3.0) / 2.0);
        pointA = new Point(0, triangleHeight);
        pointB = new Point(size / 2, 0);
        pointC = new Point(size, triangleHeight);
        polygon.addPoint(pointA.x, pointA.y);
        polygon.addPoint(pointB.x, pointB.y);
        polygon.addPoint(pointC.x, pointC.y);
        

    }

    @Override
    public boolean addLevel() {
        
        if (level == 1){
            level++;
            return true;
        } else if(level == 10){
            return false;
        } else{
            System.out.println("on level: " + level);
        }
        
        return addLevel();
    }

    public Point midPoint(Point p1, Point p2){

        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }

    @Override
    public void draw(Graphics g) {

        //g.fillPolygon(polygon);
        g.drawPolygon(polygon);

    }

}
