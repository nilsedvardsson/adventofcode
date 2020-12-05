package se.edtek.y2020.d3;

import se.edtek.common.SolutionParent;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution extends SolutionParent {

    public long task1() {

        return runSlope(3, 1);

    }

    public long task2() {

        long x1 = runSlope(1, 1);
        long x2 = runSlope(3, 1);
        long x3 = runSlope(5, 1);
        long x4 = runSlope(7, 1);
        long x5 = runSlope(1, 2);

        return x1 * x2 * x3 * x4 * x5;
    }

    private long runSlope(int rightSteps, int downSteps) {
        AtomicInteger horizontalPosition = new AtomicInteger(-rightSteps);
        AtomicInteger verticalPosition = new AtomicInteger(- 1);

        return lines()
                .filter(s -> {

                    if (verticalPosition.addAndGet(1) % downSteps == 0) {
                        int boundedPosition = horizontalPosition.addAndGet(rightSteps) % s.length();
                        return s.charAt(boundedPosition) == '#';
                    }
                    else {
                        return false;
                    }
                })
                .count();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        long result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        long result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);
    }
}
