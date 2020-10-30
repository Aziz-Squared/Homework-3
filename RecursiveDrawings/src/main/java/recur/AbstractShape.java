package recur;

import java.awt.Graphics;
import java.awt.Color;

public class AbstractShape implements Shape {

    protected static int level = 1;
    protected static int maxLevel;
    protected static AbstractShape[] children;
    protected static Color color;

    public AbstractShape(int amountOfChildren) {
        children = new AbstractShape[amountOfChildren];

    }

    public AbstractShape() {

    }

    @Override
    public void draw(Graphics g) {

    }

    public boolean addLevel() {

        if (children[0] == null) {
            // create children
            // add a createChildren method to the Shape interface
            // that is implemented in each of the concrete classes
            createChildren();
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

    @Override
    public void createChildren() {

    }

}
