/** Drawing Book
 * https://www.hackerrank.com/challenges/drawing-book/problem
 */

package Easy;

import java.io.*;
import java.util.*;

public class DrawingBook {

    /**
     * Calculates the smallest number of page turns need to reach a given page either from the 
     * front or back of the book.
     * 
     * @param n Number of pages long the book is
     * @param p Given page to turn to
     * @return Minimum number of pages to be turned
     */
    static int pageCount(int n, int p) {
        int numberOfPageOpenings = (n / 2) + 1;
        int targetPageOpening = (p + 2) / 2;
        int pageTurnsFromFront = 0 + targetPageOpening - 1;
        int pageTurnsFromBack = numberOfPageOpenings - targetPageOpening;

        return (pageTurnsFromFront < pageTurnsFromBack) ? pageTurnsFromFront : pageTurnsFromBack;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter 
                = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        Scanner scanner = new Scanner(System.in);

        try {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            int p = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            int result = pageCount(n, p);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        } finally {
            bufferedWriter.close();

            scanner.close();
        }

        
    }
}
