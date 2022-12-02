package se.edtek.y2022.d2;

import se.edtek.common.SolutionParent;

public class Solution extends SolutionParent {

    public long calculatePoints(Mapper mapper) {
        return lines()
                .mapToInt(s -> {
                    String[] values = s.split(" ");
                    Move opponent = Move.of(values[0]);
                    Move myself = mapper.getMyMove(opponent, values[1]);
                    return RoundResult.play(opponent, myself).points + myself.points;

                })
                .sum();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        long result1 = solution.calculatePoints(new Task1Mapper());
        System.out.println("Uppgift 1: " + result1);

        long result2 = solution.calculatePoints(new Task2Mapper());
        System.out.println("Uppgift 2: " + result2);
    }
}
