/** Java Substring
 * https://www.hackerrank.com/challenges/java-substring/problem
 */

package Java.Strings.Easy;

import java.util.*;

public class JavaSubstring {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();

        String substring = "";

        for (int i = start; i < end; i++) {
            substring += S.charAt(i);
        }

        System.out.println(substring);

        in.close();
    }
}