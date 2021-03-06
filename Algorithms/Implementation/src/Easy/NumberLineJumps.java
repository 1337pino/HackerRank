/** Number of Line Jumps
 * https://www.hackerrank.com/challenges/kangaroo/problem
 */

package Easy;

import java.io.*;
import java.util.*;

public class NumberLineJumps {

    /**
     * Determines if two kangaroos will ever land on the same spot.
     * 
     * @param x1 Left kangaroo's location
     * @param v1 Left kangaroo's leap rate
     * @param x2 Right kangaroo's location
     * @param v2 Right kangaroo's leap rate
     * @return "YES" if the kangaroos ever share a position on the number line.  "NO" if otherwise.
     */
    static String kangaroo(int x1, int v1, int x2, int v2) {
        int sharedJump;

        if (x1 == x2) {
            return (v1 == v2) ? "YES" : "NO";
        }

        if (v2 >= v1) return "NO";
        
        // Calculate the shared landing time
        sharedJump = (x1 - x2) / (v2 - v1);

        // Return "YES" if shared landing time was a whole number and not a decimal
        return ((v1 * sharedJump + x1) == (v2 * sharedJump + x2)) ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter 
                = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
