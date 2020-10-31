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

    }

    // Adds a level to the shape
    public boolean addLevel() {

        if (children[0] == null) {
            System.out.println("Current level: " + level);
            if (level <= maxLevel) {
                createChildren();
                return true;
            } else {
                return false;
            }
        } else {
            for (int i = 0; i <= children.length - 1; i++) {
                children[i].addLevel();
            }
            return true;
        }
    }

    @Override
    public boolean removeLevel() {

        // base case is if there are no grandchildren
        if (children[0] != null && children[0].children[0] == null) {
            if (children[0].children[0] == null) {
                for (int i = 0; i <= children.length - 1;) {
                    children[i] = null;
                    return true;
                }
                return true;
            } else {
                for (int i = 0; i <= children.length - 1; i++) {
                    children[i].removeLevel();
                }
                return true;
            }
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
                count = 1 + children[i].countShapes();
            }
        }
        return count;
    }

}
