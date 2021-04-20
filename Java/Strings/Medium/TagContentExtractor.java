/** Tag Content Extractor
 * https://www.hackerrank.com/challenges/tag-content-extractor/problem
 */

package Java.Strings.Medium;

import java.util.*;

public class TagContentExtractor {
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            boolean validContentFound = false;
            String tagStart = "";
            String deepestString = "";
            String line = in.nextLine();

            for (int i = 0; i < line.length(); i++) {
                char character = line.charAt(i);

                if (character == '<') {
                    String tag = "";
                    boolean isStartTag = true;

                    for (int j = i + 1; j < line.length(); j++) {
                        char startTagCharacter = line.charAt(j);
                        
                        if (startTagCharacter == '/') {
                            isStartTag = false;
                        } else if (startTagCharacter == '>') {
                            if (isStartTag) {
                                tagStart = tag;
                                deepestString = "";
                            } else {
                                if (!tag.isEmpty() && tag.equals(tagStart) 
                                        && !deepestString.isEmpty()) {
                                    validContentFound = true;
                                    System.out.println(deepestString);
                                    deepestString = "";
                                }
                            }

                            deepestString = "";
                            i = j;
                            j = line.length();
                        } else {
                            tag += startTagCharacter;
                        }
                    }
                } else {
                    deepestString += character;
                }
            }

            // Verify vlaid content was found.  If none, print "None".
            if (!validContentFound) {
                System.out.println("None");
            }
             
            testCases--;
        }

        in.close();
    }
}
