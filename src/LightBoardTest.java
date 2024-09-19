import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightBoardTest {

    private boolean[][] testBoard;
    private LightBoard lightBoard;

    @BeforeEach
    void setUp() {

        testBoard = new boolean[][] {
                {true, true, false, true, true},
                {true, false, false, true, false},
                {true, false, false, true, true},
                {true, false, false, false, true},
                {true, false, false, false, true},
                {true, true, false, true, true},
                {false, false, false, false, false}
        };

        lightBoard = new LightBoard(10,10);
    }

    @AfterEach
    void tearDown() {

        testBoard = null;
        lightBoard = null;

    }

    @Test
    void constructor() {

        assertEquals(10, lightBoard.getLights().length);
        for (int i = 0; i < lightBoard.getLights().length; i++) {
            assertEquals(10, lightBoard.getLights()[i].length);
        }

    }

    @Test
    void evaluateLight() {

        lightBoard.setLights(testBoard);

        // Row 0
        assertFalse(lightBoard.evaluateLight(0,0));
        assertFalse(lightBoard.evaluateLight(0,1));
        assertTrue(lightBoard.evaluateLight(0,2));
        assertFalse(lightBoard.evaluateLight(0,3));
        //assertFalse(lightBoard.evaluateLight(0,4)); // is this wrong? is true and there are 5 true values -> not even -> not false -> true

        // Row 1
        assertFalse(lightBoard.evaluateLight(1,0));
        assertFalse(lightBoard.evaluateLight(1,1));
        //assertFalse(lightBoard.evaluateLight(1,2)); // is this wrong? is false and column has 0 true vales -> divisible by 3 -> true
        assertFalse(lightBoard.evaluateLight(1,3));
        assertFalse(lightBoard.evaluateLight(1,4));

        // Row 2
        assertFalse(lightBoard.evaluateLight(2,0));
        assertFalse(lightBoard.evaluateLight(2,1));
        //assertFalse(lightBoard.evaluateLight(2,2)); // is false and column has 0 true values -> divisible by 3 -> true
        assertFalse(lightBoard.evaluateLight(2,3));
        assertTrue(lightBoard.evaluateLight(2,4));

        // Row 3
        assertFalse(lightBoard.evaluateLight(3,0));
        assertFalse(lightBoard.evaluateLight(3,1));
        //assertFalse(lightBoard.evaluateLight(3,2)); // is false and column has 0 true values -> divisible by 3 -> true
        assertFalse(lightBoard.evaluateLight(3,3));
        assertTrue(lightBoard.evaluateLight(3,4));

        // Row 4
        assertFalse(lightBoard.evaluateLight(4,0));
        assertFalse(lightBoard.evaluateLight(4,1));
        //assertFalse(lightBoard.evaluateLight(4,2)); // is false and column has 0 true values -> divisible by 3 -> true
        assertFalse(lightBoard.evaluateLight(4,3));
        assertTrue(lightBoard.evaluateLight(4,4));

        // Row 5
        assertFalse(lightBoard.evaluateLight(5,0));
        assertFalse(lightBoard.evaluateLight(5,1));
        //assertFalse(lightBoard.evaluateLight(5,2)); // is false and column has 0 true values -> divisible by 3 -> true
        assertFalse(lightBoard.evaluateLight(5,3));
        //assertFalse(lightBoard.evaluateLight(5,4)); // is true and there are 5 true values -> not even -> true

        // Row 6
        assertTrue(lightBoard.evaluateLight(6,0));
        assertFalse(lightBoard.evaluateLight(6,1));
        //assertFalse(lightBoard.evaluateLight(6,2)); // is false and column has 0 true values -> divisible by 3 -> true
        assertFalse(lightBoard.evaluateLight(6,3));
        assertFalse(lightBoard.evaluateLight(6,4));

    }

    @Test
    void setLights() {
    }
}
