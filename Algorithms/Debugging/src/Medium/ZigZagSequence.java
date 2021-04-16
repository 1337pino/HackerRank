/** Zig Zag Sequence
 * https://www.hackerrank.com/challenges/zig-zag-sequence/problem
 * 
 * Note: You can modify at most three lines in the given code. You cannot add or remove lines of 
 * code.
 */

package Algorithms.Debugging.src.medium;

import java.util.*;

public class ZigZagSequence {
    
    public static void main (String[] args) throws java.lang.Exception {
        Scanner kb = new Scanner(System.in);
        int test_cases = kb.nextInt();
        for(int cs = 1; cs <= test_cases; cs++){
            int n = kb.nextInt();
            int a[] = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = kb.nextInt();
            }
            findZigZagSequence(a, n);
        }
        kb.close();
    }
   
    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        int mid = n / 2; // Bug fix; original code: int mid = (n + 1)/2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2; // Bug fix; original code: int ed = n - 1;
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1; // Bug fix; original code: ed = ed + 1;
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
