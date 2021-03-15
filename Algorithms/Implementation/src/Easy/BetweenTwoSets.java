/** Between Two Sets
 * https://www.hackerrank.com/challenges/between-two-sets/problem
 */

package Easy;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class BetweenTwoSetsHelper {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    /**
     * Count the number of integers that:
     * 1. A common multiple of all the elements of list A
     * 2. A common factor of all the elements of list B
     * 
     * @param a List of integers for getting the common multiples.
     * @param b List of integers for getting the common factors.
     * @return The total number of integers that satisfy the two conditions.
     */
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        if ((a.size() == 0) || (b.size() == 0)) return 0;

        // Find the smallest value in b
        int smallestBValue = Integer.MAX_VALUE;
        for (int i = 0; i < b.size(); i++) {
            if (b.get(i) < smallestBValue) smallestBValue = b.get(i);
        }

        // Find the largest value in a
        int largestAValue = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > largestAValue) largestAValue = a.get(i);
        }

        int countX = 0;

        /* Loop between the largest A value and the smallest B value and find all of the integers 
           that are common multiples of List A while being common factors for List B */
        for (int i = largestAValue; i <= smallestBValue; i++) {
            boolean isStillValid = true;

            for (int j = 0; j < a.size(); j++) {
                if (i % a.get(j) != 0) {
                    isStillValid = false;
                    break;
                }
            }

            if (isStillValid) {
                for (int j = 0; j < b.size(); j++) {
                    if (b.get(j) % i != 0) {
                        isStillValid = false;
                        break;
                    }
                }

                if (isStillValid) countX++;
            }
        }

        return countX;
    }
}

public class BetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter 
                = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        bufferedReader.readLine();
        //int n = Integer.parseInt(firstMultipleInput[0]);

        //int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = BetweenTwoSetsHelper.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
