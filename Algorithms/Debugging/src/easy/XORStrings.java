/** XOR Strings
 * https://www.hackerrank.com/challenges/strings-xor/problem
 * 
 * Note: You can modify at most three lines in the given code and you cannot add or remove lines 
 * to the code.
 */

package Algorithms.Debugging.src.easy;

import java.util.*;

public class XORStrings {
    
    public static String stringsXOR(String s, String t) {
        String res = new String("");
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t.charAt(i)) // Bug fix; original code: if(s.charAt(i) = t.charAt(i))
                res += "0"; // Bug fix; original code: res = "0";
            else
                res += "1"; // Bug fix; original code: res = "1";
        }

        return res;
    }

    public static void main(String[] args) {

        String s, t;
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        t = in.nextLine();
        System.out.println(stringsXOR(s, t));
        in.close();
    }
}
