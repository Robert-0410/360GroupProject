package controller;

import model.CellType;
import model.GameObject;
import sql.QuestionManager;
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
     * Unique instance of EnvironmentGenerator.
     */
    private static EnvironmentGenerator UNIQUE_INSTANCE;

    /**
     * The connection between the database and the game.
     */
    private static QuestionManager QUESTION_MANAGER;

    /**
     * Unique instance of Environment.
     */
    private final Environment myEnvironment;

    /**
     * 2D ArrayList representation of map.
     */
    private final ArrayList<List<GameObject>> myMap;

    /**
     * Row location of player.
     */
    private int myUserRow = 1;

    /**
     * Row location of player.
     */
    private int myUserCol = 1;

    /**
     * Constructor set initial fields.
     */
    private EnvironmentGenerator() {
        myEnvironment = Environment.getInstance();
        myMap = new ArrayList<>(18);
        QUESTION_MANAGER = new QuestionManager();
    }

    /**
     * Gets unique instance of the button panel.
     * @return only instance of the ButtonPanel.
     */
    public static EnvironmentGenerator getInstance() {
        if(UNIQUE_INSTANCE == null) {
            UNIQUE_INSTANCE = new EnvironmentGenerator();
        }
        return UNIQUE_INSTANCE;
    }

    /**
     * Getter of the link between the game and SQLit database.
     * @return QuestionManager
     */
    public static QuestionManager getQuestionManager() {
        return QUESTION_MANAGER;
    }

    /**
     * Initializes a new game within the environment, invoked when user chooses new game.
     */
    protected void generateInitialEnvironment() {
        fromFileFillMyMap();
        emptyCurrentEnvironment();
        populateGameObjects();
    }

    /**
     * Generates the map after a move has been performed.
     */
    protected void generateAfterMove() {
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

        for (List<GameObject> list : myMap) {
            for (GameObject o : list) {
                current = o;
                var size = current.getMyCellType().getCellSize();
                current.setBounds(x, y, size, size);
                myEnvironment.add(current);
                x = x + size;
            }
            x = 0;
            y = y + 25;
        }
    }


    /**
     * Used to move player up when the Up button is clicked.
     */
    protected void movePlayerUp() {
        final var nextCell = myMap.get(myUserRow - 1).get(myUserCol);
        if(nextCell.getMyID() == CellType.WALL.getID()) {
            System.out.println("Rick is not a ghost.");
        } else if(nextCell.getMyID() == CellType.DOOR.getID()) {
            System.out.println("Trigger Question.");
        } else {
            List<GameObject> currentRow = myMap.get(myUserRow);

            // Remove current player cell and replace with floor
            currentRow.remove(myUserCol);
            currentRow.add(myUserCol, GameObject.assignGameObject(CellType.FLOOR.getID()));

            // Switch row
            currentRow = myMap.get(myUserRow - 1);

            // Remove next cell and replace with player
            currentRow.remove(myUserCol);
            currentRow.add(myUserCol, GameObject.assignGameObject(CellType.PLAYER.getID()));

            // update location of player.
            myUserRow--;
            generateAfterMove();
        }
    }

    /**
     * Used to move player to the right when the right button is clicked.
     */
    protected void movePlayerRight() {
        final var nextCell = myMap.get(myUserRow).get(myUserCol + 1);
        if(nextCell.getMyID() == CellType.WALL.getID()) {
            System.out.println("Rick is not a ghost.");
        } else if(nextCell.getMyID() == CellType.DOOR.getID()) {
            System.out.println("Trigger Question.");
        } else {
            final List<GameObject> currentRow = myMap.get(myUserRow);
            // Remove current player cell and replace with floor
            currentRow.remove(myUserCol);
            currentRow.add(myUserCol, GameObject.assignGameObject(CellType.FLOOR.getID()));

            // Remove next cell and replace with player
            currentRow.remove(myUserCol + 1);
            currentRow.add(myUserCol + 1, GameObject.assignGameObject(CellType.PLAYER.getID()));

            // update location of player.
            myUserCol++;
            generateAfterMove();
        }
    }

    /**
     * Used to move player down when the right button is clicked.
     */
    protected void movePlayerDown() {
        final var nextCell = myMap.get(myUserRow + 1).get(myUserCol);
        if(nextCell.getMyID() == CellType.WALL.getID()) {
            System.out.println("Rick is not a ghost.");
        } else if(nextCell.getMyID() == CellType.DOOR.getID()) {
            System.out.println("Trigger Question.");
        } else {
            List<GameObject> currentRow = myMap.get(myUserRow);
            // Remove current player cell and replace with floor
            currentRow.remove(myUserCol);
            currentRow.add(myUserCol, GameObject.assignGameObject(CellType.FLOOR.getID()));

            // Switch row
            currentRow = myMap.get(myUserRow + 1);

            // Remove next cell and replace with player
            currentRow.remove(myUserCol);
            currentRow.add(myUserCol, GameObject.assignGameObject(CellType.PLAYER.getID()));

            // update location of player.
            myUserRow++;
            generateAfterMove();
        }
    }

    /**
     * Used to move player to the left when the Left arrow button is clicked.
     */
    protected void movePlayerLeft() {
        final var nextCell = myMap.get(myUserRow).get(myUserCol - 1);
        if(nextCell.getMyID() == CellType.WALL.getID()) {
            System.out.println("Rick is not a ghost.");
        } else if(nextCell.getMyID() == CellType.DOOR.getID()) {
            System.out.println("Trigger Question.");
        } else {
            final List<GameObject> currentRow = myMap.get(myUserRow);

            // Remove current player cell and replace with floor
            currentRow.remove(myUserCol);
            currentRow.add(myUserCol, GameObject.assignGameObject(CellType.FLOOR.getID()));

            // Remove next cell and replace with player
            currentRow.remove(myUserCol - 1);
            currentRow.add(myUserCol - 1, GameObject.assignGameObject(CellType.PLAYER.getID()));

            // update location of player.
            myUserCol--;
            generateAfterMove();
        }
    }
}
