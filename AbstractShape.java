package RecursionGroup;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class AbstractShape implements Shape {

    protected static int level = 1;
    protected static int maxLevel;
    protected static AbstractShape[] children; 
    protected static Color color;

    public AbstractShape(int maxLevel, int level){
    	this.level = level;
    	if(level ==1) {
    	this.maxLevel = maxLevel;
    	children = new AbstractShape[maxLevel];
    	createChildren();
    	}
    
    }

    @Override
    public void draw(Graphics g) {
        

    }

    
    public boolean addLevel() {    	
	if(level == maxLevel ) {
		return false;
	} else {
		children[level]  = this;
	}
    	return true;
}


    public void createChildren() {
		// TODO Auto-generated method stub
 
    	children[0] = this;		
	}

	@Override
    public boolean removeLevel() {
		level--;
		children[level] = null;		
		if(level==0) {
			return false;
		}
		return true;
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