/** Breaking the Records
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 */

package Easy;

import java.io.*;
import java.util.*;

public class BreakingTheRecords {

    /**
     * Process a series of scores and counts how many times a new high score and low score record 
     * is made.
     * 
     * @param scores Array of scores.
     * @return An array consisting of the number of new high scores followed by the number of new 
     * low scores
     */
    static int[] breakingRecords(int[] scores) {
        int[] recordUpdates = new int[2];

        if (scores.length > 0) {
            int mostPoints = scores[0], leastPoints = scores[0];

            for (int i = 1; i < scores.length; i++) {
                if (scores[i] > mostPoints) {
                    recordUpdates[0]++;
                    mostPoints = scores[i];
                } else if (scores[i] < leastPoints) {
                    recordUpdates[1]++;
                    leastPoints = scores[i];
                }
            }
        }

        return recordUpdates;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter 
                = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
