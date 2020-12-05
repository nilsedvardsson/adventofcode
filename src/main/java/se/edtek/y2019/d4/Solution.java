package se.edtek.y2019.d4;

import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class Solution {

    private int hepp(IntFunction<? extends Password> function) {
        int startNumber = 193651;
        int endNumber = 649729;

        return IntStream
                .range(startNumber, endNumber + 1)
                .mapToObj(function)
                .mapToInt(p -> { return p.isValid() ? 1 : 0; })
                .sum();
    }

    public int task1() {
        return hepp(Password::new);
    }

    public int task2() {
        return hepp(Password2::new);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        int result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);
    }
}
