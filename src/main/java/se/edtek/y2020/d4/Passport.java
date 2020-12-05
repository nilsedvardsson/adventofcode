package se.edtek.y2020.d4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Passport {

    private Map<String, String> pairs;

    public Passport() {
        this.pairs = new HashMap<>();
    }

    public void addPairs(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s, " ");

        while (tokenizer.hasMoreTokens()) {
            String pair = tokenizer.nextToken();
            String[] q = pair.split(":");
            pairs.put(q[0], q[1]);
        }
    }

    public boolean isValid(Set<Field> fields) {
        return fields.stream().filter(f -> !f.isValid(pairs)).count() == 0;
    }
}
