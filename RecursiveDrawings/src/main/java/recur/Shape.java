package recur;

import java.awt.Graphics;
import java.awt.Graphics2D;

public interface Shape {

    public void draw(Graphics g);
    public boolean addLevel();
    public boolean removeLevel();
    public int countShapes();
    public void update(int value);

    
}
