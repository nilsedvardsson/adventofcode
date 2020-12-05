package se.edtek.y2015.d6;

import se.edtek.y2015.common.SolutionParent;

import java.util.HashSet;
import java.util.Set;

public class Solution extends SolutionParent {

    public int task2() {

        Board board = new Board();

        lines().map(Command::new).forEach(c -> c.execute2(board));

        return board.sum();
    }

    public int task1() {

        Set<Position> board = new HashSet<>();
        lines().map(Command::new).forEach(c -> c.execute(board));
        return board.size();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        int result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);
    }
}
