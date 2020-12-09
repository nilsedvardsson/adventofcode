package se.edtek.y2020.d9;

import se.edtek.common.SolutionParent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution extends SolutionParent {

    public long task1() {

        int preambleLength = 25;

        List<Long> input = lines().map(s -> Long.parseLong(s)).collect(Collectors.toList());

        List<Long> runningBuffer = new ArrayList<>();

        for (int i = 0; i < preambleLength; i++) {
            runningBuffer.add(input.get(i));
        }

        for (int i = preambleLength; i < input.size(); i++) {
            if (!contains(runningBuffer, input.get(i))) {
                return input.get(i);
            }

            runningBuffer.remove(0);
            runningBuffer.add(input.get(i));
        }

        return -1;
    }

    private boolean contains(List<Long> runningBuffer, long sum) {
        for (int i = 0; i < runningBuffer.size(); i++) {
            for (int j = 0; j < runningBuffer.size(); j++) {
                if (i == j) {
                    continue;
                }

                if (runningBuffer.get(i) + runningBuffer.get(j) == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    public long task2() {

        List<Long> input = lines().map(s -> Long.parseLong(s)).collect(Collectors.toList());

        long targetSum = task1();
        int lowerIndex = 0;
        int upperIndex = 1;

        long sum = input.get(0) + input.get(1);

        while (true) {

            if (sum == targetSum) {

                long minValue = Long.MAX_VALUE;
                long maxValue = Long.MIN_VALUE;

                for (int i = lowerIndex; i <= upperIndex; i++) {

                    minValue = Math.min(minValue, input.get(i));
                    maxValue = Math.max(maxValue, input.get(i));

                }

                return minValue + maxValue;
            }

            if (sum < targetSum) {
                upperIndex++;
                sum += input.get(upperIndex);
            }
            else {
                sum -= input.get(lowerIndex);
                lowerIndex++;
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
