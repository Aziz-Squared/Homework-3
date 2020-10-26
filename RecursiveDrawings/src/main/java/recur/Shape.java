package recur;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public interface Shape {

    void draw(Graphics g);
    boolean addLevel();
    boolean removeLevel();
    int countShapes();
    void update(int value);

    
}
