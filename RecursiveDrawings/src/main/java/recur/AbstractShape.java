package recur;

import java.awt.Graphics;
import java.awt.Color;

public abstract class AbstractShape implements Shape {

    protected int level = 1;
    protected int maxLevel;
    protected AbstractShape[] children;
    protected Color color;

    public AbstractShape(int amountOfChildren) {
        children = new AbstractShape[amountOfChildren];

    }

    public boolean addLevel() {

        if (children[0] == null) {

            // createChildren();
            // System.out.println("In add level " + children[0]);
            // level++;
            // System.out.println(level);
            if (level != maxLevel) {
                createChildren();
                return true;
            } else {
                return false;
            }
        } else {

            for (int i = 0; i < children.length - 1; i++) {
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
                children[0] = null;
                return true;
            } else {
                for (int i = 0; i < children.length; i++) {
                    children[0].removeLevel();
                }
                return true;
            }
        } else {
            return false;
        }
    }
    // children = null;

    // } else {
    // // recursion
    // // loop over the children
    // // children[i].removeLevel()

    // for (int i = 0; i <= children.length - 1; i++) {
    // children[i].removeLevel();
    // }

    // }

    // return false;
    // }

    @Override
    public int countShapes() {
        int count = 0;
        if (children[0] == null) {
            return 1;
        } else {
            for (int i = 0; i < children.length; i++) {
                count = 1 + children[i].countShapes();
            }
        }
        return count;
    }

}
