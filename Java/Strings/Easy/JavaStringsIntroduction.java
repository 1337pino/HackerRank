/** Java Strings Introduction
 * https://www.hackerrank.com/challenges/java-strings-introduction/problem
 */

package Java.Strings.Easy;

import java.util.*;

public class JavaStringsIntroduction {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        
        int combinedStringLengths = A.length() + B.length();
        
        String aLexicographicallyLargerThanB = (A.compareTo(B) > 0) ? "Yes" : "No";
        
        A = Character.toUpperCase(A.charAt(0)) + A.substring(1);
        B = Character.toUpperCase(B.charAt(0)) + B.substring(1);

        // Display output
        System.out.println(combinedStringLengths);
        System.out.println(aLexicographicallyLargerThanB);
        System.out.println(A + " " + B);

        sc.close();
    }
}
