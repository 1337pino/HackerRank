/** Sales by Match
 * https://www.hackerrank.com/challenges/sock-merchant/problem
 */

import java.io.*;
import java.util.*;

public class Solution_SockMerchant {

    /**
     * Calculates the total number of matching pairs of socks that can be made from an array of 
     * socks
     * 
     * @param n Number of socks in the array
     * @param ar Array of socks. Each element is a single sock and it's value is its color
     * @return Number of pairs of socks across all colors of socks
     */
    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> sockColorCount = new HashMap<Integer, Integer>();
        
        // Find the total counts for each unique color
        for (int i = 0; i < n; i++) {
            sockColorCount.merge(ar[i], 1, Integer::sum);
        }
        
        // Using the total counts, calculate the number of pairs for each unique color
        int numberOfPairs = 0;
        for (Iterator<Map.Entry<Integer, Integer>> colorCounts 
                    = sockColorCount.entrySet().iterator(); colorCounts.hasNext(); ) {
            Map.Entry<Integer, Integer> color = colorCounts.next();
            
            numberOfPairs += (color.getValue() / 2);
        }
        
        return numberOfPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter 
                = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
