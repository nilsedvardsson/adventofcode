package se.edtek.y2020.d5;

import se.edtek.common.SolutionParent;

import java.util.Set;
import java.util.stream.Collectors;

public class Solution extends SolutionParent {

    public int task1() {
        return lines().mapToInt(s -> new BoardingPass(s).getId()).max().getAsInt();
    }

    public int task2() {

        Set<Integer> allIds = lines().map(s -> new BoardingPass(s).getId()).collect(Collectors.toSet());

        for (int row = 0; row < 128; row++) {
            for (int column = 0; column < 8; column++) {

                int id = row * 8 + column;

                if (!allIds.contains(id)) {

                    if (allIds.contains(id - 1) && allIds.contains(id + 1)) {
                        return id;
                    }
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
