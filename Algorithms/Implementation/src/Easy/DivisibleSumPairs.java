/** Divisible Sum Pairs
 * https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
 */

package Algorithms.Implementation.src.easy;

import java.io.*;
import java.util.*;

public class DivisibleSumPairs {

    /**
     * Given an array of integers and a positive integer k, determines the number of pairs where 
     * the sum of the pairs is divisible by k.
     * 
     * @param n Length of array ar.
     * @param k Positive integer k (1 <= k <= 100).
     * @param ar Array of integers.
     * @return Count of the pairs that, when summed, are divisible by k.
     */
    static int divisibleSumPairs(int n, int k, int[] ar) {
        int divisibleSumPairCount = 0;

        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if ((ar[i] + ar[j]) % k == 0) {
                    divisibleSumPairCount++;
                }
            }
        }

        return divisibleSumPairCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}