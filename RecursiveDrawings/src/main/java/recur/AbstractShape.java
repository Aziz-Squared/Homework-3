package recur;

import java.awt.Color;

public abstract class AbstractShape implements Shape {

    protected static int level = 0;
    protected static int count = 0;
    protected int maxLevel;
    protected AbstractShape[] children;
    protected Color color;

    public AbstractShape(int amountOfChildren, int mLevel) {
        children = new AbstractShape[amountOfChildren];
        maxLevel = mLevel;
        level = 1;

    }

    // Adds a level to the shape
    public boolean addLevel() {

        if (children[0] == null) {
            level++;
            createChildren();
            return true;
        } else if (level <= maxLevel) {
               return false;
            } 
        } else {
        level++;
            for (int i = 0; i < children.length; i++) {
                children[i].addLevel();
            }
            return true;
        }
    }

    @Override
    // base case is if there are no grandchildren
    public boolean removeLevel() {
        if (children[0] != null) {
            if (children[0].children[0] == null) {
                for (int i = 0; i < children.length; i++) {
                    children[i] = null;
                }
                return true;
            }
            for (int i = 0; i < children.length; i++) {
                children[i].removeLevel();
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int countShapes() {
        if (children[0] == null) {
            return 1;
        } else {
            for (int i = 0; i <= children.length - 1; i++) {
                count = 1 + children.length * children[i].countShapes();
            }
        }
        return count;
    }

}
