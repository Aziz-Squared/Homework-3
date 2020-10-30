package recur;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public interface Shape {

    public void draw(Graphics g); // Draw the shape
    public boolean addLevel(); // Adds a level to the shape. Returns true if it worked or false if max levels reached
    public boolean removeLevel(); // Removes a level from the shape
    public int countShapes(); // Counts the number of shapes of this shape
    public void update(int value); // Modifies the shape in an interesting way

    
}
