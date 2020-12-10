package se.edtek.y2020.d10;

import se.edtek.common.SolutionParent;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution extends SolutionParent {

    public long task1() {

        List<Integer> input = lines().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        Collections.sort(input);

        int n1 = 0;
        int n3 = 0;

        int prev = 0;

        for (Integer value : input) {

            int diff = value - prev;

            switch (diff) {
                case 1: n1++; break;
                case 3: n3++; break;
            }

            prev = value;
        }

        n3++;

        return n1 * n3;
    }

    public long task2() {

        List<Integer> input = lines().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        Collections.sort(input);

        input.add(0, 0);

        int lastValue = input.get(input.size() - 1);

        input.add(lastValue + 3);



        return options(new HashMap<>(), input, 0);
    }

    private long options(Map<Integer, Long> alreadyCalculated, List<Integer> input, int startIndex) {

        if (alreadyCalculated.containsKey(startIndex)) {
            return alreadyCalculated.get(startIndex);
        }

        if (startIndex == input.size() - 1) {
            return 1;
        }

        int jump = 0;
        long acc = 0;

        while (true) {
            jump++;

            if (startIndex + jump == input.size()) {
                return acc;
            }

            if (input.get(startIndex + jump) - input.get(startIndex) <= 3) {

                long tmp = options(alreadyCalculated, input, startIndex + jump);
                alreadyCalculated.put(startIndex + jump, tmp);

                acc += tmp;
            }
            else {
                return acc;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        long result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        long result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);
    }
}
