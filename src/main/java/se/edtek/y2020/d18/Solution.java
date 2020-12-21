package se.edtek.y2020.d18;

import se.edtek.common.SolutionParent;

import java.util.function.Function;

public class Solution extends SolutionParent {

    public long task1() {
        return evaluate(s -> new LeftToRightExpressionEvaluator().evaluate(Node.of(s)));
    }

    public long task2() {
        return evaluate(s -> new AddFirstExpressionEvaluator().evaluate(Node.of(s)));
    }

    private long evaluate(Function<String, Long> function) {
        return lines()
                .map(function)
                .reduce(0l, (a, b) -> a + b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        long result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        long result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);
    }
}
