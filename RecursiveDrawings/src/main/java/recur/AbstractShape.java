package recur;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class AbstractShape implements Shape {

    protected static int level = 1;
    protected static int maxLevel;
    protected static AbstractShape[] children;
    protected static Color color;

    public AbstractShape(){
    
    }

    @Override
    public void draw(Graphics g) {
        

    }

    
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
