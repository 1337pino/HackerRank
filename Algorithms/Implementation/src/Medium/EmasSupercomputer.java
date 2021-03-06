package Medium;

/** Ema's Supercomputer
 * https://www.hackerrank.com/challenges/two-pluses/problem
 */

import java.io.*;
import java.util.*;

public class EmasSupercomputer {

    /**
     * Calculates the largest product that can be made using two pluses of only 'G' characters
     * 
     * @param grid 2D array representing the grid that the pluses can exist in.  Cells contain 
     * either a 'B' or a 'G'
     * @return the product made from the area of two pluses multiplied together
     */
    static int twoPluses(char[][] grid) {
        HashMap<Integer, List<Integer>> plusDatabase = new HashMap<Integer, List<Integer>>();
        
        int maxSize, maxRow = grid.length, maxCol = grid[0].length, biggestroduct = 1;
        
        // Find the theoretically max size a plus can be based on the size of the board
        if (grid.length < grid[0].length) {
            maxSize = maxRow;
        } else {
            maxSize = maxCol;
        }
        
        // The max size needs to be odd per definition of the pluses
        if (maxSize % 2 != 1) maxSize--;
        
        // Find all of the pluses and then find the largest product of two valid pluses
        for (int i = maxSize; i > 0; i -= 2) {
            int armLength = i / 2;
            List<Integer> validLocations = new ArrayList<Integer>();
            
            // Search the grid for valid locations for a plus of the given arm length
            for (int j = armLength; j < maxRow - armLength; j++) {
                for (int k = armLength; k < maxCol - armLength; k++) {
                    if (verifyPlus(grid, armLength, j, k)) {
                        validLocations.add((maxCol * j) + k);
                    }
                }
            }
            
            // Update the database with the valid locations for the current-size plus
            plusDatabase.put(armLength, validLocations);
            
            for (int j = maxSize / 2; j >= armLength; j--) {
                List<Integer> locationsForPlusSizeJ = plusDatabase.get(j);

                for (Integer plus : validLocations) {
                    for (Integer otherPlus : locationsForPlusSizeJ) {
                        // If the pluses don't overlap, update the largest product value if needed
                        if (verifyNoInterceptions(plus, armLength, otherPlus, j, maxCol)) {
                            int plusProduct = ((4 * armLength) + 1) * ((4 * j) + 1);

                            if (plusProduct > biggestroduct) biggestroduct = plusProduct;
                        }
                    }
                }
            }
        }
        
        return biggestroduct;
    }
    
    /**
     * Compares two pluses and verifies that they do not intersect at any point
     * 
     * @param plusA The first plus to compare
     * @param armlengthA The first plus' arm length
     * @param plusB The second plus to compare
     * @param armlengthB The second plus' arm length
     * @param gridWidth The width of the grid the pluses are located in
     * @return TRUE if there are no intersections
     */
    public static boolean verifyNoInterceptions(int plusA, int armlengthA, int plusB, 
            int armlengthB, int gridWidth) {
        List<Integer> plusACells = new ArrayList<Integer>();
        plusACells.add(plusA);
        fillPlusList(plusACells, armlengthA, plusA, gridWidth);
        
        List<Integer> plusBCells = new ArrayList<Integer>();
        plusBCells.add(plusB);
        fillPlusList(plusBCells, armlengthB, plusB, gridWidth);
        
        // Check for shared cells
        for (Integer cell : plusACells) {
            if (plusBCells.contains(cell)) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Updates a list of all the grid cells that the given plus occupies
     * 
     * @param plusList List for storying the locations of the plus
     * @param armLength Plus' arm length
     * @param plusCenter Cell containing the middle of the plus
     * @param gridWidth The width of the grid the pluses are located in
     */
    private static void fillPlusList(List<Integer> plusList, int armLength, int plusCenter, 
            int gridWidth) {
        for (int i = armLength; i > 0; i--) {
            // Upwards
            plusList.add(plusCenter - (i * gridWidth));
            
            // Downwards
            plusList.add(plusCenter + (i * gridWidth));
            
            // Left
            plusList.add(plusCenter - i);
            
            // Right
            plusList.add(plusCenter + i);
        }
    }
    
    /**
     * Checks if a plus of the specified size exists at the given location
     * 
     * @param grid 2D array representing the grid that the pluses can exist in.  Cells contain 
     * either a 'B' or a 'G'
     * @param armLength Plus' arm length
     * @param row Vertical coordinate of the center of the potential plus location
     * @param col Horizontal coordinate of the center of the potential plus location
     * @return True if a plus can be made in the given location without overlapping a 'B' cell
     */
    public static boolean verifyPlus(char[][] grid, int armLength, int row, int col) {
        // Verify vertical arms
        for (int i = row - armLength; i <= row + armLength; i++) {
            if (grid[i][col] == 'B') {
                return false;
            }
        }
        
        // Verify horizontal arms
        for (int i = col - armLength; i <= col + armLength; i++) {
            if (grid[row][i] == 'B') {
                return false;
            }
        }
        
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        char[][] grid = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            
            for (int j = 0; j < m; j++) {
                grid[i][j] = gridItem.charAt(j);
            }
        }

        int result = twoPluses(grid);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

