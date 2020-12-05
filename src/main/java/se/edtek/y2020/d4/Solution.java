package se.edtek.y2020.d4;

import se.edtek.common.SolutionParent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution extends SolutionParent {

    public int task1() {
        Set<Field> mandatoryFields = new HashSet<>();

        mandatoryFields.add(new Field("byr", ".*"));
        mandatoryFields.add(new Field("iyr", ".*"));
        mandatoryFields.add(new Field("eyr", ".*"));
        mandatoryFields.add(new Field("hgt", ".*"));
        mandatoryFields.add(new Field("hcl", ".*"));
        mandatoryFields.add(new Field("ecl", ".*"));
        mandatoryFields.add(new Field("pid", ".*"));

        return countValidPassports(mandatoryFields);
    }

    public int task2() {

        Set<Field> mandatoryFields = new HashSet<>();

        mandatoryFields.add(new Field("byr", "\\d{4}", (String s) -> {
            int value = Integer.parseInt(s);
            return value >= 1920 && value <= 2002;
        }));

        mandatoryFields.add(new Field("iyr", "\\d{4}", (String s) -> {
            int value = Integer.parseInt(s);
            return value >= 2010 && value <= 2020;
        }));

        mandatoryFields.add(new Field("eyr", "\\d{4}", (String s) -> {
            int value = Integer.parseInt(s);
            return value >= 2020 && value <= 2030;
        }));

        mandatoryFields.add(new Field("hgt", "\\d+(cm|in)", (String s) -> {
            int height = Integer.parseInt(s.substring(0, s.length()-2));
            if (s.endsWith("cm")) {
                return height >= 150 && height <= 193;
            }
            else {
                return height >= 59 && height <= 76;
            }
        }));

        mandatoryFields.add(new Field("hcl",  "#[0-9,a-f]{6}"));
        mandatoryFields.add(new Field("ecl",  "amb|blu|brn|gry|grn|hzl|oth"));
        mandatoryFields.add(new Field("pid", "\\d{9}"));

        return countValidPassports(mandatoryFields);
    }

    private int countValidPassports(Set<Field> fields) {
        List<String> rows = lines().collect(Collectors.toList());

        Passport passport = new Passport();

        int numberOfValidPassports = 0;

        for (String s : rows) {
            if (s.trim().equals("")) {
                if (passport.isValid(fields)) {
                    numberOfValidPassports++;
                }
                passport = new Passport();
            }
            else {
                passport.addPairs(s);
            }
        }

        if (passport.isValid(fields)) {
            numberOfValidPassports++;
        }

        return numberOfValidPassports;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        int result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);
    }
}
