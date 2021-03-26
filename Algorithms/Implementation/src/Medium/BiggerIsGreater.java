/** Bigger is Greater
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 */

package Algorithms.Implementation.src.medium;

import java.io.*;
import java.util.*;

public class BiggerIsGreater {

    /**
     * Finds the next permutation of a strings letters in terms of lexicographical order.
     * 
     * @param w S string of at least one character wherein all characters are in the range 
     * ascii[a..z]
     * @return A new permuation of the character(s) of w that is next in lexicographical ordering. 
     * If the given string is already the last possible permutation for the lexicographical 
     * ordering, then "no answer" is instead returned.
     */
    static String biggerIsGreater(String w) {
        if (w.length() == 1) return "no answer";
        
        // Convert String to char array
        char[] charW = w.toCharArray();

        // Identify the substring that will be shuffled
        for (int walker = w.length() - 1, next = walker - 1; next >= 0; next--, walker--) {
            if (charW[next] < charW[walker]) {
                // Find the next largest replacement for the character at [next]
                for (int j = w.length() - 1; j >= walker; j--) {
                    if (charW[next] < charW[j]) {
                        // Swap with the next largest replacement
                        char temp = charW[next];
                        charW[next] = charW[j];
                        charW[j] = temp;

                        break;
                    }
                }

                // Sort the subarray after [next]
                Arrays.sort(charW, walker, charW.length);

                break;
            } else if (next == 0) {
                return "no answer";
            }
        }

        // Rebuild String
        String biggerW = "";
        for (int k = 0; k < charW.length; k++) {
            biggerW += charW[k];
        }

        return biggerW;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter 
                = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
