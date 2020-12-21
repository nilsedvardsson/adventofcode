package se.edtek.y2020.d18;

import java.util.ArrayList;
import java.util.List;

public class Splitter {

    public List<String> split(String s) {
        List<String> result = new ArrayList<>();

        int startIndex = 0;
        int currentIndex = 0;

        for (;;) {

            if (currentIndex == s.length() - 1) {

                if (startIndex == 0 && s.startsWith("(")) {
                    result.add(s.substring(1, s.length() - 1));
                }
                else {
                    result.add(s.substring(startIndex));
                }

                return result;
            }

            char currentChar = s.charAt(currentIndex);

            if (currentChar == '+' || currentChar == '*') {
                result.add(s.substring(startIndex, currentIndex).trim());
                startIndex = currentIndex;
                currentIndex++;
            }
            else if (currentChar == '(') {
                int j = findMatchingEndParentheses(s, currentIndex);
                currentIndex = j;
            }
            else {
                currentIndex++;
            }
        }
    }

    private int findMatchingEndParentheses(String s, int startIndex) {

        int count = 0;
        int currentIndex = startIndex;

        for (;;) {

            if (s.charAt(currentIndex) == '(') {
                count++;
            }
            else if (s.charAt(currentIndex) == ')') {
                count--;
            }

            if (count == 0) {
                return currentIndex;
            }

            currentIndex++;
        }
    }
}
