/** Utopian Tree
 * https://www.hackerrank.com/challenges/utopian-tree/problem
 */

package algorithms.implementation.easy;

import java.io.*;
import java.util.*;

public class UtopianTree {

    /**
     * Calculates the Utopian Tree growth for a given number of growth cycles wherein growth 
     * alternates between doubling the tree height and adding 1.
     * 
     * @param n Number of cycles of growth completed
     * @return Height the Utopian Tree after n growth cycles
     */
    static int utopianTree(int n) {
        int height = (int) (4 * Math.pow(2, (n / 2)) - 2);

        // Identify if cycle was a Summer; if so, reduce for the missing extra Spring cycle
        if (n % 2 == 0) height /= 2;

        return height;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter 
                = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = utopianTree(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
