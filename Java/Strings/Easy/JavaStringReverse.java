/** Java String Reverse
 * https://www.hackerrank.com/challenges/java-string-reverse/problem
 */

package Java.Strings.Easy;

import java.util.*;

public class JavaStringReverse {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        
        String plaindromeness = isPalindrome(A) ? "Yes" : "No";

        System.out.print(plaindromeness);

        sc.close();
    }

    static boolean isPalindrome(String word) {
        for (int frontWalker = 0, backWalker = word.length() - 1; frontWalker < backWalker; 
                frontWalker++, backWalker--) {
            if (word.charAt(frontWalker) != word.charAt(backWalker)) return false;
        }

        return true;
    }
}
