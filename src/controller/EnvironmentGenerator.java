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
        myMap = new ArrayList<>();
        generateNewEnvironment();
    }

    /**
     * Initializes a new game within the environment, invoked when user chooses new game.
     */
    private void generateNewEnvironment() {
        manualInputOfMap();
        populateGameObjects();
    }

    /**
     * Provides an easy way to paint a partial map for testing.
     * TODO: only a production method.
     */
    private void manualInputOfMap() {
        final List<GameObject> row1 = new ArrayList<>();
        row1.add(GameObject.assignGameObject(CellType.WALL.getID()));
        row1.add(GameObject.assignGameObject(CellType.WALL.getID()));
        row1.add(GameObject.assignGameObject(CellType.WALL.getID()));
        row1.add(GameObject.assignGameObject(CellType.WALL.getID()));

        final List<GameObject> row2 = new ArrayList<>();
        row2.add(GameObject.assignGameObject(CellType.WALL.getID()));
        row2.add(GameObject.assignGameObject(CellType.FLOOR.getID()));
        row2.add(GameObject.assignGameObject(CellType.PLAYER.getID()));
        row2.add(GameObject.assignGameObject(CellType.FLOOR.getID()));

        final List<GameObject> row3 = new ArrayList<>();
        row3.add(GameObject.assignGameObject(CellType.WALL.getID()));
        row3.add(GameObject.assignGameObject(CellType.FLOOR.getID()));
        row3.add(GameObject.assignGameObject(CellType.FLOOR.getID()));
        row3.add(GameObject.assignGameObject(CellType.WALL.getID()));

        final List<GameObject> row4 = new ArrayList<>();
        row4.add(GameObject.assignGameObject(CellType.WALL.getID()));
        row4.add(GameObject.assignGameObject(CellType.DOOR.getID()));
        row4.add(GameObject.assignGameObject(CellType.WALL.getID()));
        row4.add(GameObject.assignGameObject(CellType.WALL.getID()));

        myMap.add(row1);
        myMap.add(row2);
        myMap.add(row3);
        myMap.add(row4);
    }


    /**
     * Populates all the GameObjects that compose the Environment.
     */
    private void populateGameObjects() {
        var x = 0;
        var y = 0;
        GameObject current;

        for(int i = 0; i < myMap.size(); i++) {
            for(int j = 0; j < myMap.get(i).size(); j++) {
                current = (GameObject) myMap.get(i).get(j);
                var size = current.getMyCellType().getCellSize();
                current.setBounds(x, y, size,size);
                myEnvironment.add(current);
                x = x + size;
            }
            x = 0;
            y = y + 25;
        }
    }


}
