package controller;


import model.CellType;
import model.GameObject;
import model.Wall;
import view.Environment;

import java.util.ArrayList;

/**
 * Generates environment for the game.
 * @author Robert
 * @version 1
 */
public class EnvironmentGenerator {

    /**
     * Unique instance of Environment.
     */
    private final Environment myEnvironment;

    /**
     * 2D ArrayList representation of map.
     */
    private final ArrayList<GameObject> myMap;

    /**
     * Temp GameObject used for testing.
     */
    private final GameObject test; // temp

    /**
     * Constructor set initial fields.
     */
    public EnvironmentGenerator() {
        myEnvironment = Environment.getInstance();
        myMap = null; // TODO will need to have a method to initiate this.

        test = new Wall(CellType.FLOOR.getID());
        myEnvironment.add(test);
    }
}
