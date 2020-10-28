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

    
    public boolean addLevel() 
	    if (children[0] == null) {
            	if (level != maxLevel) {
			createChildren();
            		return false;
		}
	    } else {
		    for (int i = 0; i < children.length; i++) {
			    children[i].addLevel();
		    }
	    }
	return true;
}


    @Override
    public boolean removeLevel() {
       if (children[0] == null && children[0].children[0] != null) {
		return true;
        } else {
            for (int i = 0; i < children.length; i++) {
		    children[i].removeLevel();
	    }
	}
	    return false;
    }

    @Override
    public int countShapes() {
        // TODO Auto-generated method stub
        if (level == 1) {
			return 1;
		}
		else {
			level --;
			return 1 + children.length * countShapes();
		}
    }

    @Override
    public void update(int value) {
        // TODO Auto-generated method stub

    }

}
