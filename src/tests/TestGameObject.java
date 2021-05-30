package tests;

import model.CellType;
import model.GameObject;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Sean Logan, Robert Beltran
 * @version 1
 * Testing for creation of GameObjects
 */
public class TestGameObject {

    /**
     * Test method for Wall Cell Type
     */
    @Test
    public void testWallCellType() {
        GameObject gameObject = GameObject.assignGameObject(CellType.WALL.getID());
        assertEquals(gameObject.getMyCellType(), CellType.WALL,
                "Not of CellType Wall");
        assertEquals(gameObject.getMyID(), CellType.WALL.getID(),
                "Not of CellType Wall ID");
    }

    /**
     * Test method for Floor Cell Type
     */
    @Test
    public void testFloorCellType() {
        GameObject gameObject = GameObject.assignGameObject(CellType.FLOOR.getID());
        assertEquals(gameObject.getMyCellType(), CellType.FLOOR,
                "Not of CellType Floor");
        assertEquals(gameObject.getMyID(), CellType.FLOOR.getID(),
                "Not of CellType Floor ID");
    }

    /**
     * Test method for Door Cell Type
     */
    @Test
    public void testDoorCellType() {
        GameObject gameObject = GameObject.assignGameObject(CellType.DOOR.getID());
        assertEquals(gameObject.getMyCellType(), CellType.DOOR,
                "Not of CellType Door");
        assertEquals(gameObject.getMyID(), CellType.DOOR.getID(),
                "Not of CellType Wall ID");
    }

    /**
     * Test method for Player Cell Type
     */
    @Test
    public void testPlayerCellType() {
        GameObject gameObject = GameObject.assignGameObject(CellType.PLAYER.getID());
        assertEquals(gameObject.getMyCellType(), CellType.PLAYER,
                "Not of CellType Player");
        assertEquals(gameObject.getMyID(), CellType.PLAYER.getID(),
                "Not of CellType Player ID");
    }

    /**
     * Test method for Portal Cell Type
     */
    @Test
    public void testPortalCellType() {
        GameObject gameObject = GameObject.assignGameObject(CellType.PORTAL.getID());
        assertEquals(gameObject.getMyCellType(), CellType.PORTAL,
                "Not of CellType Portal");
        assertEquals(gameObject.getMyID(), CellType.PORTAL.getID(),
                "Not of CellType Portal ID");
    }

    /**
     * Test method for Life Cell Type
     */
    @Test
    public void testLifeCellType() {
        GameObject gameObject = GameObject.assignGameObject(CellType.LIFE.getID());
        assertEquals(gameObject.getMyCellType(), CellType.LIFE,
                "Not of CellType Life");
        assertEquals(gameObject.getMyID(), CellType.LIFE.getID(),
                "Not of CellType Life ID");
    }
}