/** Java Regex
 * https://www.hackerrank.com/challenges/java-regex/problem
 */

package Java.Strings.Medium;

import java.util.Scanner;

public class JavaRegex {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
        in.close();
    }
}

/* IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 
to 255. Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3. */
class MyRegex {
    public String pattern = "([0-9]|[0-9][0-9]|[0-1][0-9][0-9]|2[0-4][0-9]|25[0-5])[.]"
            + "([0-9]|[0-9][0-9]|[0-1][0-9][0-9]|2[0-4][0-9]|25[0-5])[.]"
            + "([0-9]|[0-9][0-9]|[0-1][0-9][0-9]|2[0-4][0-9]|25[0-5])[.]"
            + "([0-9]|[0-9][0-9]|[0-1][0-9][0-9]|2[0-4][0-9]|25[0-5])";
}
