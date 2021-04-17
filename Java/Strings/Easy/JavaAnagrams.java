/** Java Anagrams
 * https://www.hackerrank.com/challenges/java-anagrams/problem
 */

package Java.Strings.Easy;

import java.util.Scanner;

public class JavaAnagrams {

    static boolean isAnagram(String a, String b) {
        java.util.HashMap<Character, Integer> letters = new java.util.HashMap<Character, Integer>();

        for (int i = 0; i < a.length(); i++) {
            char letter = Character.toLowerCase(a.charAt(i));
            letters.merge(letter, 1, Integer::sum);
        }

        for (int i = 0; i < b.length(); i++) {
            char letter = Character.toLowerCase(b.charAt(i));
            letters.merge(letter, -1, Integer::sum);
        }

        for (java.util.HashMap.Entry<Character, Integer> entry : letters.entrySet()) {
            if (entry.getValue() != 0) return false;
        }

        return true;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
