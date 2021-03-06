/** Apple and Orange
 * https://www.hackerrank.com/challenges/apple-and-orange/problem
 */

package Easy;

import java.util.*;

public class AppleAndOrange {

    /**
     * Prints the number of apples and oranges that fall on the house.
     * 
     * @param s The left-most point of the house
     * @param t The right-most point of the house
     * @param a Apple tree location
     * @param b Orange tree location
     * @param apples Array of distances for fallen apples
     * @param oranges Array of distances for fallen oranges
     */
    static void countApplesAndOranges(
            int s, int t, int a, int b, int[] apples, int[] oranges) {
        int numberOfApples = 0, numberOfOranges = 0;
        
        // Count the apples
        for (int i = 0; i < apples.length; i++) {
            int fallenAppleLocation = apples[i] + a;
            if ((fallenAppleLocation >= s) && (fallenAppleLocation <= t)) {
                numberOfApples++;
            }
        }
        
        // Count the oranges
        for (int j = 0; j < oranges.length; j++) {
            int fallenOrangeLocation = oranges[j] + b;
            if ((fallenOrangeLocation >= s) && (fallenOrangeLocation <= t)) {
                numberOfOranges++;
            }
        }
        
        // Print the apple and orange counts
        System.out.println(numberOfApples);
        System.out.println(numberOfOranges);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }
}

