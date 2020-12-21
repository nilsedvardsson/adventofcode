package se.edtek.y2020.d12;

import se.edtek.common.SolutionParent;

import java.util.List;
import java.util.stream.Collectors;

import static se.edtek.y2020.d12.Direction.*;

public class Solution extends SolutionParent {

    public long task1() {
        List<String> input = lines().collect(Collectors.toList());

        Position shipPosition = new Position(0, 0);

        Direction direction = EAST;

        for (String s : input) {

            char command = s.charAt(0);
            int value = Integer.parseInt(s.substring(1));

            switch (command) {

                case 'N':
                case 'S':
                case 'E':
                case 'W': shipPosition.moveForward(Direction.of(command), value);
                break;

                case 'L': direction = direction.rotateLeft(value);
                break;

                case 'R': direction = direction.rotateRight(value);
                break;

                case 'F': shipPosition.moveForward(direction, value);
                break;
            }

        }

        return shipPosition.manhattanDistance(new Position(0, 0));
    }

    public long task2() {
        List<String> input = lines().collect(Collectors.toList());

        Position shipPosition = new Position(0, 0);
        Position wayPoint = new Position(1, 10);

        Direction direction = EAST;

        for (String s : input) {

            char command = s.charAt(0);
            int value = Integer.parseInt(s.substring(1));

            switch (command) {

                case 'N':
                case 'S':
                case 'E':
                case 'W': wayPoint.moveForward(Direction.of(command), value);
                    break;

                case 'L':
                    Position diff1 = wayPoint.subtract(shipPosition);
                    diff1.rotateLeft(value);
                    wayPoint = shipPosition.add(diff1);

                    break;

                case 'R':
                    Position diff2 = wayPoint.subtract(shipPosition);
                    diff2.rotateRight(value);
                    wayPoint = shipPosition.add(diff2);
                    break;

                case 'F':

                    Position diff = wayPoint.subtract(shipPosition);

                    shipPosition.moveNorth(diff.getNorth() * value);
                    shipPosition.moveEast(diff.getEast() * value);

                    wayPoint = shipPosition.add(diff);

                    break;
            }

            System.out.println("SHIP: " + shipPosition.toString());
            System.out.println("WAYPOINT: " + wayPoint.toString());
            System.out.println("--");

        }

        return shipPosition.manhattanDistance(new Position(0,0));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        long result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        long result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);
    }
}
