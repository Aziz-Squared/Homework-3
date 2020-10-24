package recur;

import java.awt.Graphics;
import java.awt.Color;

public class AbstractShape implements Shape {

    protected int level;
    protected int maxLevel;
    protected AbstractShape[] children;
    protected Color color;
    

    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean addLevel() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeLevel() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int countShapes() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void update(int value) {
        // TODO Auto-generated method stub

    }

    
    
}
