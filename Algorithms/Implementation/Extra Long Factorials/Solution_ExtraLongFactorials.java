/** Extra Long Factorials
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem
 */

import java.math.*;
import java.util.*;

public class Solution_ExtraLongFactorials {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        BigInteger factorial = BigInteger.valueOf(n);
        
        for (int i = n - 1; i > 1; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        
        System.out.println(factorial);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
    