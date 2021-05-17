package controller;


import model.CellType;
import model.GameObject;
import model.Wall;
import view.Environment;

import java.util.ArrayList;

/**
 * Generates environment for the game.
 */
public class EnvironmentGenerator {

    private final Environment myEnvironment;
    private final ArrayList<GameObject> myMap;
    public final GameObject test;



    public EnvironmentGenerator() {
        myEnvironment = Environment.getInstance();
        myMap = null;

        test = new Wall(CellType.WALL.getID());
        myEnvironment.add(test);
    }
}
