/** Grading Students
 * https://www.hackerrank.com/challenges/grading/problem
 */

package algorithms.implementation.easy;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /**
     * Processes the a list of grade values and rounds them accordingly.  Rounds a grade value up 
     * if it is within 2 of the next highest multiple of 5 AND at least 38.
     *
     * @param grades List of integer-based grade values
     * @return New list of grade values
     */
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> updatedGrades = new ArrayList<Integer>();
        
        for (int i = 0; i < grades.size(); i++) {
            int grade = grades.get(i);
            
            if ((grade >= 38) && (grade % 5 >= 3)) {
                grade += (5 - (grade % 5));
            }
            
            updatedGrades.add(grade);
        }
        
        return updatedGrades;
    }

}

public class GradingStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter 
                = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
