package se.edtek.y2015.d5;

import se.edtek.y2015.common.SolutionParent;

import java.util.function.Function;

public class Solution extends SolutionParent {

    public int task1() {
        return count(SantaText::new);
    }

    public int task2() {
        return count(SantaText2::new);
    }

    private int count(Function<? super String, ? extends IsNice> mapper) {
        // https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java
        return (int) lines().map(mapper).filter(st -> st.isNice()).count();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        int result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);
    }
}
