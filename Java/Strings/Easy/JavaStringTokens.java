/** Java String Tokens
 * https://www.hackerrank.com/challenges/java-string-tokens/problem
 */

package Java.Strings.Easy;

import java.util.*;

public class JavaStringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            String s = scan.nextLine();
        
            String[] stringTokens = s.trim().split("[ !,?._'@]+");

            if (s.trim().length() == 0) {
                System.out.println(0);
            } else {
                System.out.println(stringTokens.length);

                for (int i = 0; i < stringTokens.length; i++) {
                    String stringToken = stringTokens[i];
                
                    System.out.println(stringToken);
                }
            }
            
        } catch (Exception e) {
            System.out.println(0);
        }

        scan.close();
    }
}
