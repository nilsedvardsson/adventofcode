package se.edtek.y2020.d6;

import se.edtek.common.SolutionParent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution extends SolutionParent {

    public int task1() {
        return algorithm(this::combinationFunctionForTask1);
    }

    public int task2() {
        return algorithm(this::combinationFunctionForTask2);
    }

    private int algorithm(Function<List<String>, Integer> function) {
        List<String> rows = lines().collect(Collectors.toList());

        int sum = 0;

        List<String> groupAnswers = new ArrayList<>();

        for (String personAnswer : rows) {

            if (personAnswer.trim().equals("")) {
                sum += function.apply(groupAnswers);
                groupAnswers = new ArrayList<>();
            }
            else {
                groupAnswers.add(personAnswer);
            }
        }

        sum += function.apply(groupAnswers);

        return sum;
    }

    private int combinationFunctionForTask1(List<String> groupAnswers) {
        Set<String> result = new HashSet<>();
        for (String personAnswer : groupAnswers) {
            result.addAll(asCharacterSet(personAnswer));
        }
        return result.size();
    }

    private int combinationFunctionForTask2(List<String> groupAnswers) {
        Set<String> result = new HashSet<>();
        result.addAll(asCharacterSet(groupAnswers.get(0)));

        for (String personAnswer : groupAnswers) {
            result.retainAll(asCharacterSet(personAnswer));
        }

        return result.size();
    }

    private Set<String> asCharacterSet(String s) {
        return Arrays.stream(s.split("")).collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        int result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);
    }
}
