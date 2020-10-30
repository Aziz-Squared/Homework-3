package recur;

import java.awt.Graphics;
import java.awt.Color;

public class AbstractShape implements Shape {

    protected static int level = 1;
    protected static int maxLevel;
    protected static AbstractShape[] children;
    protected static Color color;

    @Override
    public void draw(Graphics g) {

    }

    public boolean addLevel() {

        if (children[0] == null) {
            // create children
            // add a createChildren method to the Shape interface
            // that is implemented in each of the concrete classes

        } else {
            // recursion
            // loop over the children
            // children[i].addLevel()

        }

        return false;
    }

    @Override
    public boolean removeLevel() {

        // base case is if there are no grandchildren
        if (children[0] != null && children[0].children[0] == null) {

        } else {
            // recursion
            // loop over the children
            // children[i].removeLevel()

        }

        return true;
    }

    @Override
    public int countShapes() {

        return 0;
    }

    @Override
    public void update(int value) {

    }

    @Override
    public void createChildren() {

    }

}
