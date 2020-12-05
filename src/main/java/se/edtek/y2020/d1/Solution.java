package se.edtek.y2020.d1;

import se.edtek.common.SolutionParent;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution extends SolutionParent {


    public int task1() {
        List<Integer> values = lines().map(s -> Integer.parseInt(s)).collect(Collectors.toList());

        Set<Integer> setWithValues = values.stream().collect(Collectors.toSet());

        for (Integer value1 : values) {

            int value2 = 2020 - value1;

            if (setWithValues.contains(value2)) {
                return value1 * value2;
            }
        }

        return -1;
    }

    public int task2() {
        List<Integer> values = lines().map(s -> Integer.parseInt(s)).collect(Collectors.toList());

        Set<Integer> setWithValues = values.stream().collect(Collectors.toSet());

        for (Integer value1 : values) {

            for (Integer value2 : values) {

                int value3 = 2020 - value1 - value2;

                if (setWithValues.contains(value3)) {
                    return value1 * value2 * value3;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        int result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);

    }
}
