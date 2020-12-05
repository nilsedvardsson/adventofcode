package se.edtek.y2020.d2;

import org.apache.commons.lang3.StringUtils;

public class Passwordline {

    private String password;
    private Rule rule;

    public Passwordline(String s) {

        String[] elements = s.split(":");
        this.password = elements[1].trim();
        this.rule = new Rule(elements[0]);
    }

    public String getPassword() {
        return password;
    }

    public Rule getRule() {
        return rule;
    }

    public boolean isValidTask1() {
        int matches = StringUtils.countMatches(password, rule.getCharacter());
        return matches >= rule.getInteger1() && matches <= rule.getInteger2();
    }

    public boolean isValidTask2() {
        String s1 = password.substring(rule.getInteger1() - 1, rule.getInteger1());
        String s2 = password.substring(rule.getInteger2() - 1, rule.getInteger2());

        int matches = 0;

        if (s1.equals(rule.getCharacter())) {
            matches++;
        }

        if (s2.equals(rule.getCharacter())) {
            matches++;
        }

        return matches == 1;
    }
}
