package controller;

import model.CellType;
import model.GameObject;
import view.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        //generateNewEnvironment(); // was here for quick generation of map
    }

    /**
     * Initializes a new game within the environment, invoked when user chooses new game.
     */
    protected void generateNewEnvironment() {
        //manualInputOfMap();
        fromFileFillMyMap();
        emptyCurrentEnvironment();
        populateGameObjects();
    }

    /**
     * From an input file myMap is filled with GameObjects.
     */
    private void fromFileFillMyMap() {

        final File file = new File("src/resources/Map.txt");
        try {
            final Scanner scanner = new Scanner(file);
            String currentLine;
            String[] strArray;
            int currentID;
            ArrayList<GameObject> currentRow;

            while (scanner.hasNextLine()) {
                currentLine  = scanner.nextLine();
                strArray = currentLine.split("");
                currentRow = new ArrayList<>();
                for (String s : strArray) {
                    currentID = Integer.parseInt(s);
                    currentRow.add(GameObject.assignGameObject(currentID));
                }
                myMap.add(currentRow);
            }

            scanner.close();

        } catch (final FileNotFoundException e) {
            System.err.println("Files was not found in fromFileFillMyMap().");
            e.printStackTrace();
        }
    }

    /**
     * Clears out current Environment panel in preparation for new components.
     */
    private void emptyCurrentEnvironment() {
        myEnvironment.removeAll();
        myEnvironment.repaint();
    }


    /**
     * Populates all the GameObjects that compose the Environment.
     */
    private void populateGameObjects() {
        var x = 0;
        var y = 0;
        GameObject current;

        for (List list : myMap) {
            for (Object o : list) {
                current = (GameObject) o;
                var size = current.getMyCellType().getCellSize();
                current.setBounds(x, y, size, size);
                myEnvironment.add(current);
                x = x + size;
            }
            x = 0;
            y = y + 25;
        }
    }


}
