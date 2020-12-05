package se.edtek.y2020.d2;

import se.edtek.common.SolutionParent;

public class Solution extends SolutionParent {

    public int task1() {
        return (int) lines().filter(s -> new Passwordline(s).isValidTask1()).count();
    }

    public int task2() {
        return (int) lines().filter(s -> new Passwordline(s).isValidTask2()).count();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        int result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);
    }
}
