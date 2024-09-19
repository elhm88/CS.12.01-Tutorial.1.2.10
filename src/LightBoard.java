import java.util.*;

public class LightBoard {
    // Property
    private boolean[][] lights;

    // Constructor
    public LightBoard(int numRows, int numCols) {
        lights = new boolean[numRows][numCols];
        Random rand = new Random();

        // Initialise lights
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                lights[r][c] = rand.nextDouble() < 0.4; // Sets to true if the generated value is less than 0.4 (which occurs 40% of the time)
            }
        }

    }


    // Method
    public boolean evaluateLight(int row, int col) {
        int numOn = 0;

        // Count the number of lights that are on in the same column
        for (int r = 0; r < lights.length; r++) {
            if (lights[r][col]) {
                numOn++;
            }
        }

        if (lights[row][col]) { // If the given light is on
            return !(numOn % 2 == 0); // Return false if the number of lights on is even
        }
        else { // If the given light is off
            if (numOn % 3 == 0) {
                return true; // Return true if the number of lights on is divisible by three
            }
            return lights[row][col];
        }
    }


    // Getter method (to pass test)
    public boolean[][] getLights() {
        return lights;
    }

    // Setter method (to pass test)
    public void setLights(boolean[][] testBoard) {
        lights = testBoard;
    }
}
