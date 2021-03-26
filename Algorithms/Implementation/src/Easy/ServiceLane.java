/** Service Lane
 * https://www.hackerrank.com/challenges/service-lane/problem
 */

package algorithms.implementation.easy;

import java.io.*;
import java.util.*;

public class ServiceLane {

    /**
     * Processes a series of ranges to inclusively see what the widest road size is given a road of
     * varying road widths.
     * 
     * @param width Array representing a road with varying widths
     * @param cases Array of ranges along the road
     * @return Array of results for each case
     */
    static int[] serviceLane(int[] width, int[][] cases) {
        int[] results = new int[cases.length];

        for (int i = 0; i < cases.length; i++) {
            int min = Integer.MAX_VALUE;
            
            for (int j = cases[i][0]; j <= cases[i][1]; j++) {
                if (width[j] < min) min = width[j];
            }
            
            results[i] = min;
        }

        return results;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter 
                = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nt = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nt[0]);

        int t = Integer.parseInt(nt[1]);

        int[] width = new int[n];

        String[] widthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int widthItem = Integer.parseInt(widthItems[i]);
            width[i] = widthItem;
        }

        int[][] cases = new int[t][2];

        for (int i = 0; i < t; i++) {
            String[] casesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int casesItem = Integer.parseInt(casesRowItems[j]);
                cases[i][j] = casesItem;
            }
        }

        int[] result = serviceLane(width, cases);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
