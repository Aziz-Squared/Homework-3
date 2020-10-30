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
            // create children
            // add a createChildren method to the Shape interface
            // that is implemented in each of the concrete classes
            createChildren();
            System.out.println("In add level " + children[0]);
            level++;
            System.out.println(level);

        } else {
            // recursion
            // loop over the children
            // children[i].addLevel()
            for (int i = 0; i < children.length - 1; i++) {
                children[i].addLevel();
                System.out.println("Adding levels to children");
            }

        }

        return true;
    }

    @Override
    public boolean removeLevel() {

        // base case is if there are no grandchildren
        if (children[0] != null && children[0].children[0] == null) {
            children = null;

        } else {
            // recursion
            // loop over the children
            // children[i].removeLevel()

            for (int i = 0; i <= children.length - 1; i++) {
                children[i].removeLevel();
            }

        }

        return false;
    }

    @Override
    public int countShapes() {

        return 0;
    }

    @Override
    public void update(int value) {

    }

}
