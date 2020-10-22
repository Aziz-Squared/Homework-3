package RecursiveDrawings.src.main.java.recur;

import java.awt.Graphics;
import java.awt.Graphics2D;

public interface Shape {

    void draw(Graphics g);
    boolean addLevel();
    boolean removeLevel();
    int countShapes();
    void update(int value);

    
}
