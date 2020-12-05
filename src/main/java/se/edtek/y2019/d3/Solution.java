package se.edtek.y2019.d3;

import se.edtek.y2015.common.SolutionParent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution extends SolutionParent {

    private Set<Position> getIntersections(Position start1, Position start2) {
        List<String> commands = lines().collect(Collectors.toList());

        Set<Position> journey1Positions = Journey.makeJourney(commands.get(0), start1);
        Set<Position> journey2Positions = Journey.makeJourney(commands.get(1), start2);

        Set<Position> intersection = new HashSet<>(journey1Positions);
        intersection.retainAll(journey2Positions);

        intersection.remove(new Position(0, 0));

        return intersection;
    }

    public int task1() {
        Set<Position> intersection = getIntersections(new Position(0, 0), new Position(0, 0));

        Position origin = Position.origin();

        return intersection.stream().mapToInt(p -> p.manhattanDistance(origin)).min().getAsInt();
    }

    public int task2() {

        Position start1 = new Position(0, 0);
        Position start2 = new Position(0, 0);

        Set<Position> intersection = getIntersections(start1, start2);

        return intersection.stream().mapToInt(p -> start1.distance(p) + start2.distance(p)).min().getAsInt();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        int result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);
    }
}
