/** Migratory Birds
 * https://www.hackerrank.com/challenges/migratory-birds/problem
 */

package Easy;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class MigratoryBirds {

    /**
     * Processes an array of bird sightings and identifies which type appears the most.
     * 
     * @param arr Array of sighted bird types.  Each unique number is a different type.
     * @return Integer represenation of the most sighted bird type.
     */
    static int migratoryBirds(List<Integer> arr) {
        HashMap<Integer, Integer> birdMap = new HashMap<Integer, Integer>();
        
        // Convert bird list into bird map
        for (Integer bird : arr) {
            int sightingsCount = 0;
            if (birdMap.containsKey(bird)) {
                sightingsCount = birdMap.get(bird);
            }
            birdMap.put(bird, sightingsCount + 1);
        }

        // Identify which key has the greatest paired value
        Integer mostFrequentlySightedType = null;
        int mostFrequentlySightedCount = 0;
        for (Map.Entry<Integer, Integer> birdEntry : birdMap.entrySet()) {
            if (mostFrequentlySightedType == null) {
                mostFrequentlySightedType = birdEntry.getKey();
                mostFrequentlySightedCount = birdEntry.getValue();
            } else {
                if (birdEntry.getValue() > mostFrequentlySightedCount) {
                    mostFrequentlySightedType = birdEntry.getKey();
                    mostFrequentlySightedCount = birdEntry.getValue();
                } else if ((birdEntry.getValue() == mostFrequentlySightedCount) 
                && (birdEntry.getKey() < mostFrequentlySightedType)) {
                    mostFrequentlySightedType = birdEntry.getKey();
                }
            }
        }
        
        return mostFrequentlySightedType;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter 
                = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

