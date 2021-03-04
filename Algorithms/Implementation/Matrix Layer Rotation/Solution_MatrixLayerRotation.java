import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution_MatrixLayerRotation {

    /**
     * Rotates a matrix
     * 
     * @param matrix 2D list representing a matrix of numbers
     * @param r Number of rotations for each level of the matrix
     */
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        int rows = matrix.size(), columns = matrix.get(0).size();
        int minGridSide = (rows < columns) ? rows : columns;

        // Create layer lists and manipulate for r rotations
        List<List<Integer>> layers = new ArrayList<List<Integer>>();
        for (int i = 0; i < minGridSide / 2; i++) {
            identifyMatrixLayer(matrix, layers, i);

            rotateLayer(layers.get(i), r);
        }

        // Rebuild new grid
        translateLayers(matrix, layers);
        
        // Print grid
        printMatrix(matrix);
    }

    /**
     * Adjusts the ordering of the layer's content based on the rotation
     * @param layer
     */
    public static void rotateLayer(List<Integer> layer, int rotation) {
        int shiftSize = rotation % layer.size();

        layer.addAll(layer.subList(0, shiftSize));
        layer.subList(0, shiftSize).clear();;
    }

    /**
     * Prints a given matrix.
     * 
     * @param matrix 2D list representing a matrix of numbers
     */
    public static void printMatrix(List<List<Integer>> matrix) {
        int rows = matrix.size(), columns = matrix.get(0).size();

        for (int i = 0; i < rows; i++) {
            String line = "";

            for (int j = 0; j < columns; j++) {
                if (j > 0) line += " ";

                line += matrix.get(i).get(j);
            }

            System.out.println(line);
        }
    }
    
    /**
     * Updates the 2D list with the new rotational positionings based on the values of the matrix 
     * layers list information.
     * 
     * @param matrix 2D list representing a matrix of numbers that will be updated
     * @param matrixLayers 2D list representing each of the layers of the provided matrix
     */
    public static void translateLayers(List<List<Integer>> matrix, 
            List<List<Integer>> matrixLayers) {
        int rows = matrix.size(), columns = matrix.get(0).size();
        List<List<Integer>> posMatrix = new ArrayList<List<Integer>>();
        List<List<Integer>> posLayers = new ArrayList<List<Integer>>();
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<Integer>();

            for (int j = 0; j < columns; j++) {
                row.add((i * columns) + j);
            }

            posMatrix.add(row);
        }

        int numberOfLayers = matrixLayers.size();
        
        for (int i = 0; i < numberOfLayers; i++) {
            identifyMatrixLayer(posMatrix, posLayers, i);

            List<Integer> posLayer = posLayers.get(i);
            int numberOfValues = posLayer.size();

            for (int j = 0; j < numberOfValues; j++) {
                int pos = posLayer.get(j);
                int posR = pos / columns, posC = pos - (posR * columns);
                matrix.get(posR).set(posC, matrixLayers.get(i).get(j));
            }
        }
    }

    /**
     * Identifies all of the numbers in a layer of the grid per the matrix rotation and updates 
     * a provided 2D list with its values.
     * 
     * @param matrix 2D list representing a matrix of numbers
     * @param matrixLayers 2D list representing each of the layers of the provided matrix
     * @param depthIntoMatrix Depth of the layer to identify in the matrix
     */
    public static void identifyMatrixLayer(List<List<Integer>> matrix, 
            List<List<Integer>> matrixLayers, int depthIntoMatrix) {
        List<Integer> layer = new ArrayList<Integer>();
        
        // Add top side's numbers
        layer.addAll(matrix.get(depthIntoMatrix).subList(depthIntoMatrix, 
                matrix.get(depthIntoMatrix).size() - depthIntoMatrix));

        // Add right side's numbers
        for (int i = depthIntoMatrix + 1; i < matrix.size() - (depthIntoMatrix + 1); i++) {
            List<Integer> currentGridRow = matrix.get(i);
            layer.add(currentGridRow.get(currentGridRow.size() - (depthIntoMatrix + 1)));
        }

        // Add bottom side's numbers
        List<Integer> bottomSide = 
                matrix.get(matrix.size() - (depthIntoMatrix + 1)).subList(depthIntoMatrix, 
                matrix.get(depthIntoMatrix).size() - depthIntoMatrix);
        for (int i = bottomSide.size() - 1; i >= 0; i--) {
            layer.add(bottomSide.get(i));
        }

        // Add left side's numbers
        for (int i = matrix.size() - (depthIntoMatrix + 2); i > depthIntoMatrix; i--) {
            layer.add(matrix.get(i).get(depthIntoMatrix));
        }
        
        // Add layer to the list of matrix layers
        matrixLayers.add(layer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}

