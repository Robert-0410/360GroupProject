package controller;


import model.CellType;
import model.GameObject;
import view.Environment;

import java.util.ArrayList;
import java.util.List;

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
    private final ArrayList<List> myMap;


    /**
     * Constructor set initial fields.
     */
    public EnvironmentGenerator() {
        myEnvironment = Environment.getInstance();
        myMap = null; // TODO will need to have a method to initiate this.
    }

    /**
     * Initializes a new game within the environment, invoked when user chooses new game.
     */
    private void generateNewEnvironment() {
        manualInputOfMap();
    }

    /**
     * Provides an easy way to paint a partial map for testing.
     */
    private void manualInputOfMap() {
        final List<GameObject> row1 = new ArrayList<>();
        row1.add(GameObject.assignGameObject(CellType.WALL.getID()));
        row1.add(GameObject.assignGameObject(CellType.WALL.getID()));
        row1.add(GameObject.assignGameObject(CellType.WALL.getID()));
        row1.add(GameObject.assignGameObject(CellType.WALL.getID()));

        final List<GameObject> row2 = new ArrayList<>();
        row2.add(GameObject.assignGameObject(CellType.FLOOR.getID()));
        row2.add(GameObject.assignGameObject(CellType.FLOOR.getID()));
        row2.add(GameObject.assignGameObject(CellType.PLAYER.getID()));
        row2.add(GameObject.assignGameObject(CellType.FLOOR.getID()));

        final List<GameObject> row3 = new ArrayList<>();
        row3.add(GameObject.assignGameObject(CellType.WALL.getID()));
        row3.add(GameObject.assignGameObject(CellType.FLOOR.getID()));
        row3.add(GameObject.assignGameObject(CellType.WALL.getID()));
        row3.add(GameObject.assignGameObject(CellType.WALL.getID()));

        myMap.add(row1);
        myMap.add(row2);
        myMap.add(row3);
    }

    // TODO: need to remove background from home screen
    // TODO: need to add the GameObjects onto the environment.


}
