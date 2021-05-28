package controller;

import model.CellType;
import model.GameObject;
import sql.QuestionManager;
import view.Environment;
import view.QuestionPanel;
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
public final class EnvironmentManager {

    /**
     * Direction of travel available to user at a time.
     */
    private enum Direction {
        NORTH, EAST, SOUTH, WEST
    }

    /**
     * Unique instance of EnvironmentGenerator.
     */
    private static EnvironmentManager UNIQUE_INSTANCE;

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
     * Actual representation of user lives.
     */
    private int myUserLives = 3;

    /**
     * Identification for direction user was moving before interacting with an interacting GameObject.
     */
    private Direction userIsMoving;

    /**
     * Helps determine if the player has won the game.
     */
    private CellType isWinningCell = CellType.NONE;


    /**
     * Constructor set initial fields.
     */
    private EnvironmentManager() {
        myEnvironment = Environment.getInstance();
        myMap = new ArrayList<>(18);
        QUESTION_MANAGER = new QuestionManager();
    }

    /**
     * Gets unique instance of the button panel.
     * @return only instance of the ButtonPanel.
     */
    public static EnvironmentManager getInstance() {
        if(UNIQUE_INSTANCE == null) {
            UNIQUE_INSTANCE = new EnvironmentManager();
        }
        return UNIQUE_INSTANCE;
    }


    /**
     * Getter of cell to determine if game has been won.
     * @return CellType
     */
    public CellType getIsWinningCell() {
        return isWinningCell;
    }


    /**
     * Getter for the ArrayList representation of environment.
     * @return ArrayList<List<GameObject>>
     */
    public ArrayList<List<GameObject>> getMyMap() {
        return myMap;
    }


    /**
     * Resets the player location when new Game is clicked.
     */
    public void resetPlayerLocation() {
        myUserRow = 1;
        myUserCol = 1;
    }


    /**
     * Initializes a new game within the environment, invoked when user chooses new game.
     */
    public void generateInitialEnvironment() {
        fromFileFillMyMap();
        emptyCurrentEnvironment();
        populateGameObjects();
    }

    /**
     * Generates the map after a move has been performed.
     */
    void generateAfterMove() {
        emptyCurrentEnvironment();
        populateGameObjects();
    }


    /**
     * Removes a user life when a question is answered wrong.
     * @return the new amount of lives.
     */
    public int removeUserLife() {
        myUserLives--;
        return myUserLives;
    }


    /**
     * Resets player lives to three.
     */
    public void resetPlayerLives() {
        myUserLives = 3;
    }


    /**
     * Used to move player up when the Up button is clicked.
     */
    public void movePlayerUp() {
        final var questionPanel = view.QuestionPanel.getInstance();
        final var nextCell = myMap.get(myUserRow - 1).get(myUserCol);

        if(nextCell.getMyID() == CellType.PORTAL.getID()) {

            userIsMoving = Direction.NORTH;
            questionPanel.enableButtons();
            // change 'true' to pull from is adult ui setting
            questionPanel.setMyQuestion(QUESTION_MANAGER.getRandomMultipleChoiceQuestion(true));

        } else if(nextCell.getMyID() == CellType.DOOR.getID()) {

            isWinningCell = CellType.PORTAL;
            userIsMoving = Direction.NORTH;
            questionPanel.enableButtons();
            // change 'true' to pull from is adult ui setting
            questionPanel.setMyQuestion(QUESTION_MANAGER.getRandomMultipleChoiceQuestion(true));

        } else if(nextCell.getMyID() == CellType.FLOOR.getID()) {
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
    public void movePlayerRight() {
        final var questionPanel = view.QuestionPanel.getInstance();
        final var nextCell = myMap.get(myUserRow).get(myUserCol + 1);

        if(nextCell.getMyID() == CellType.PORTAL.getID()) {

            isWinningCell = CellType.PORTAL;
            userIsMoving = Direction.EAST;
            questionPanel.enableButtons();
            // change 'true' to pull from is adult ui setting
            questionPanel.setMyQuestion(QUESTION_MANAGER.getRandomMultipleChoiceQuestion(true));

        } else if(nextCell.getMyID() == CellType.DOOR.getID()) {

            userIsMoving = Direction.EAST;
            questionPanel.enableButtons();
            // change 'true' to pull from is adult ui setting
            questionPanel.setMyQuestion(QUESTION_MANAGER.getRandomMultipleChoiceQuestion(true));

        } else if(nextCell.getMyID() == CellType.FLOOR.getID()) {

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
    public void movePlayerDown() {
        final var questionPanel = view.QuestionPanel.getInstance();
        final var nextCell = myMap.get(myUserRow + 1).get(myUserCol);

        if(nextCell.getMyID() == CellType.PORTAL.getID()) {

            isWinningCell = CellType.PORTAL;
            userIsMoving = Direction.SOUTH;
            questionPanel.enableButtons();
            // change 'true' to pull from is adult ui setting
            questionPanel.setMyQuestion(QUESTION_MANAGER.getRandomMultipleChoiceQuestion(true));

        } else if(nextCell.getMyID() == CellType.DOOR.getID()) {

            userIsMoving = Direction.SOUTH;
            questionPanel.enableButtons();
            // change 'true' to pull from is adult ui setting
            questionPanel.setMyQuestion(QUESTION_MANAGER.getRandomMultipleChoiceQuestion(true));

        } else if (nextCell.getMyID() == CellType.FLOOR.getID()) {
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
    public void movePlayerLeft() {
        final var questionPanel = view.QuestionPanel.getInstance();
        final var nextCell = myMap.get(myUserRow).get(myUserCol - 1);

        if(nextCell.getMyID() == CellType.PORTAL.getID()) {

            isWinningCell = CellType.PORTAL;
            userIsMoving = Direction.WEST;
            questionPanel.enableButtons();
            // change 'true' to pull from is adult ui setting
            questionPanel.setMyQuestion(QUESTION_MANAGER.getRandomMultipleChoiceQuestion(true));

        } else if(nextCell.getMyID() == CellType.DOOR.getID()) {

            userIsMoving = Direction.WEST;
            questionPanel.enableButtons();
            // change 'true' to pull from is adult ui setting
            questionPanel.setMyQuestion(QUESTION_MANAGER.getRandomMultipleChoiceQuestion(true));

        } else if(nextCell.getMyID() == CellType.FLOOR.getID()) {
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


    /**
     * Removes door once the user gets the correct answer.
     */
    public void removeDoorAfterCorrectAnswer() {
        List<GameObject> currentRow = myMap.get(myUserRow);
        // Remove next cell and replace with player
        switch (userIsMoving.ordinal()) {
            case 0 -> {
                currentRow = myMap.get(myUserRow - 1);
                currentRow.remove(myUserCol);
                currentRow.add(myUserCol, GameObject.assignGameObject(CellType.FLOOR.getID()));
            }
            case 1 -> {
                currentRow.remove(myUserCol + 1);
                currentRow.add(myUserCol + 1, GameObject.assignGameObject(CellType.FLOOR.getID()));
            }
            case 2 -> {
                currentRow = myMap.get(myUserRow + 1);
                currentRow.remove(myUserCol);
                currentRow.add(myUserCol, GameObject.assignGameObject(CellType.FLOOR.getID()));
            }
            case 3 -> {
                currentRow.remove(myUserCol - 1);
                currentRow.add(myUserCol - 1, GameObject.assignGameObject(CellType.FLOOR.getID()));
            }
            default -> System.err.println("Direction of user movement was not properly assigned.");
        }


        generateAfterMove();
        QuestionPanel.getInstance().disableButtons();

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
                var size = current.getMyCellType().getCellWidth();
                current.setBounds(x, y, size, size);
                myEnvironment.add(current);
                x = x + size;
            }
            x = 0;
            y = y + 25;
        }
    }
}