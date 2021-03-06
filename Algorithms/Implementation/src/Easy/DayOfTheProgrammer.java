/** Day of the Programmer
 * https://www.hackerrank.com/challenges/day-of-the-programmer/problem
 */

package Easy;

import java.io.*;

public class DayOfTheProgrammer {

    /**
     * Calculates the date the 256th day of the year will be on a given year
     * 
     * @param year Year between the range of 1700 to 2700, inclusively
     * @return a String representation of the date in the format of dd.mm.yyyy
     */
    static String dayOfProgrammer(int year) {
        String date = "";
        int[] months = new int[]{ 31, 28, 31, 30, 31, 30 , 31, 31, 30, 31, 30, 31 };
        
        if (year < 1918) {
            // Add leap day if a leap year
            if (year % 4 == 0) {
                months[1]++;
            }
        } else if (year == 1918) {
            months[1] = 15;
        } else {
            // Add leap day if a leap year
            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                months[1]++;
            }
        }
        
        for (int i = 0, days = 0; days != 256; i++) {
            if (days + months[i] > 256) {
                date = String.format("%02d.%02d.%d", (256 - days), (i + 1), year);
                break;
            } else {
                days += months[i];
            }
        }
        
        return date;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter 
                = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
