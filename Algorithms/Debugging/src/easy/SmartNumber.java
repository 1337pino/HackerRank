/** Smart Number
 * https://www.hackerrank.com/challenges/smart-number/problem
 * 
 * Note: You can modify only one line in the given code and you cannot add or remove any new lines.
 */

package Algorithms.Debugging.src.easy;

import java.util.Scanner;

public class SmartNumber {
    public static boolean isSmartNumber(int num) {
        int val = (int) Math.sqrt(num);    
        if(val * val == num) // Bug fix; original code: if(num / val == 1)
            return true;
        return false;
    }
    
    public static void main(String[] args) {
        int test_cases;
        Scanner in = new Scanner(System.in);
        test_cases = in.nextInt();
        int num;
        for(int i = 0; i < test_cases; i++){
            num = in.nextInt();
            boolean ans = isSmartNumber(num);
            if(ans){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
        in.close();
    }
}
