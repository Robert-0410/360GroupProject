package tests;

import controller.EnvironmentManager;
import model.CellType;
import model.GameObject;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


/**
 * @author Sean Logan, Robert Beltran
 * @version 1
 * Testing for logic behind the decision making in EnvironmentManager
 */
public class EnvironmentTests {

    /**
     * Double ArrayList of GameObjects to test CellTypes and interactions.
     */
    private final ArrayList<List<GameObject>> myMap = new ArrayList<>();

    /**
     * Populate a double ArrayList to test cell movement.
     */
    private void fillArrayMap() {
        ArrayList<GameObject> row0 = new ArrayList<>();
        ArrayList<GameObject> row1 = new ArrayList<>();
        ArrayList<GameObject> row2 = new ArrayList<>();
        ArrayList<GameObject> row3 = new ArrayList<>();
        ArrayList<GameObject> row4 = new ArrayList<>();
        // populate row0
        for (int i = 0; i < 5; i++) {
            row0.add(GameObject.assignGameObject(CellType.WALL.getID()));
        }
        // populate row1
        row1.add(GameObject.assignGameObject(CellType.WALL.getID()));
        row1.add(GameObject.assignGameObject(CellType.PLAYER.getID()));
        row1.add(GameObject.assignGameObject(CellType.FLOOR.getID()));
        row1.add(GameObject.assignGameObject(CellType.DOOR.getID()));
        row1.add(GameObject.assignGameObject(CellType.WALL.getID()));
        // populate row2
        row2.add(GameObject.assignGameObject(CellType.WALL.getID()));
        row2.add(GameObject.assignGameObject(CellType.FLOOR.getID()));
        row2.add(GameObject.assignGameObject(CellType.FLOOR.getID()));
        row2.add(GameObject.assignGameObject(CellType.FLOOR.getID()));
        row2.add(GameObject.assignGameObject(CellType.WALL.getID()));
        // populate row3
        row3.add(GameObject.assignGameObject(CellType.WALL.getID()));
        row3.add(GameObject.assignGameObject(CellType.FLOOR.getID()));
        row3.add(GameObject.assignGameObject(CellType.FLOOR.getID()));
        row3.add(GameObject.assignGameObject(CellType.PORTAL.getID()));
        row3.add(GameObject.assignGameObject(CellType.WALL.getID()));
        // populate row4
        for (int i = 0; i < 5; i++) {
            row4.add(GameObject.assignGameObject(CellType.WALL.getID()));
        }
        // populate myMap with rows
        myMap.add(row0);
        myMap.add(row1);
        myMap.add(row2);
        myMap.add(row3);
        myMap.add(row4);
    }

    /**
     * Clears myMap to be used again.
     */
    private void clearMyMap() {

        myMap.clear();
    }

    /**
     * Fill ArrayMap for use.
     */
    @Before
    public void setUp() {
        fillArrayMap();
        EnvironmentManager.getInstance().setMyMap(myMap);
    }

    /**
     * Test method for {@link EnvironmentManager#removeUserLife()}.
     * Initially the user has a life count of 3, reducing this once
     * will produce a result of 2 lives.
     */
    @Test
    public void testRemoveUserLife() {
        final var reduceLife = EnvironmentManager.getInstance().removeUserLife();
        final var expectedResult = 2;
        assertEquals(expectedResult, reduceLife, "Expected Result: reduceLife -> 2");
    }

    /**
     * Test method for {@link EnvironmentManager#resetPlayerLives()}
     * When resetPlayerLives() is called myUserLives will be set to 3.
     */
    @Test
    public void testResetPlayerLives() {
        var playerLives = EnvironmentManager.getInstance().getPlayerLives(); // life count is 3
        assertEquals(3, playerLives);
        assertEquals(2, EnvironmentManager.getInstance().removeUserLife());
        EnvironmentManager.getInstance().resetPlayerLives(); // life count 3 again
        assertEquals(3, EnvironmentManager.getInstance().getPlayerLives());
    }

    /**
     * Test method for {@link EnvironmentManager#setInChildMode(boolean)
     *                  @link EnvironmentManager#getInChildMode()}.
     */
    @Test
    public void testSetInChildMode() {
        // true case
        EnvironmentManager.getInstance().setInChildMode(true);
        assertTrue(EnvironmentManager.getInstance().getInChildMode(), "Expected Result: true");

        // false case
        EnvironmentManager.getInstance().setInChildMode(false);
        assertFalse(EnvironmentManager.getInstance().getInChildMode(), "Expected Result: false");
    }

    /**
     * Test method for {@link EnvironmentManager#movePlayerUp()
     *                  @link EnvironmentManager#movePlayerLeft()
     *                  @link EnvironmentManager#movePlayerRight()
     *                  @link EnvironmentManager#movePlayerDown()}
     */
    @Test
    public void testPlayerMovement() {
        // Ricks Starting Location [1][1]
        EnvironmentManager.getInstance().movePlayerDown(); // Rick moves down one cell [2][1]
        // Test movePlayerDown()
        assertEquals(CellType.PLAYER.getID(), myMap.get(2).get(1).getMyID(),
                "Failed to move down");
        EnvironmentManager.getInstance().movePlayerRight(); // Rick moves right one cell [2][2]
        // Test movePlayerRight()
        assertEquals(CellType.PLAYER.getID(), myMap.get(2).get(2).getMyID(),
                "Failed to move right");
        EnvironmentManager.getInstance().movePlayerUp(); // Rick moves up one cell [1][2]
        // Test movePlayerUp()
        assertEquals(CellType.PLAYER.getID(), myMap.get(1).get(2).getMyID(),
                "Failed to move up");
        EnvironmentManager.getInstance().movePlayerLeft(); // Rick moves left one cell [1][1]
        // Test movePlayerLeft()
        assertEquals(CellType.PLAYER.getID(), myMap.get(1).get(1).getMyID(),
                "Failed to move left");
        clearMyMap();
    }

}
