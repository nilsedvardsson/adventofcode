package se.edtek.y2015.d5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SantaText implements IsNice {

    private final String s;

    private final static List<String> forbiddenStrings = new ArrayList<>(Arrays.asList("ab", "cd", "pq", "xy"));

    private final static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public SantaText(String s) {
        this.s = s;
    }

    public boolean isNice() {

        if (numberOfVowels() < 3) {
            return false;
        }

        if (!hasDoubleLetter()) {
            return false;
        }

        if (containsForbiddenString()) {
            return false;
        }

        return true;
    }

    private int numberOfVowels() {
        return (int) s.chars().mapToObj(c -> (char) c).filter(c -> vowels.contains(c)).count();
    }

    private boolean hasDoubleLetter() {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsForbiddenString() {
        for (String forbiddenString : forbiddenStrings) {
            if (s.contains(forbiddenString)) {
                return true;
            }
        }
        return false;
    }
}
