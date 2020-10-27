package recur;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class AbstractShape implements Shape {

    protected static int level;
    protected static int maxLevel;
    protected static AbstractShape[] children;
    protected static Color color;

    public AbstractShape(){
    
    }

    @Override
    public void draw(Graphics g) {
        

    }

    
    public boolean addLevel() {
        if (children == null) {
            // need code to add level
            return true;
        } else {
        // TODO Auto-generated method stub
            return false;
        }
    }

    @Override
    public boolean removeLevel() {
        if (children == null) {
            return false;
        } else {
            // need code to remove level
            return true;
        }
    }

    @Override
    public int countShapes() {
        // TODO Auto-generated method stub
        if (level == 1) {
			return 1;
		}
		else {
			level --;
			return 1 + 3 * countShapes();
		}
    }

    @Override
    public void update(int value) {
        // TODO Auto-generated method stub

    }

}
