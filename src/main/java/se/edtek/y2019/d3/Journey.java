package se.edtek.y2019.d3;

import java.util.HashSet;
import java.util.Set;

public class Journey {

    public static Set<Position> makeJourney(String s, Position startPosition) {

        String[] commands = s.split(",");

        Position currentPosition = startPosition;

        Set<Position> allPositions = new HashSet<>();
        allPositions.add(currentPosition);

        for (int i = 0; i < commands.length; i++) {

            String direction = commands[i].substring(0, 1);
            int numberOfSteps = Integer.parseInt(commands[i].substring(1));

            for (int step = 0; step < numberOfSteps; step++) {
                currentPosition = currentPosition.move(direction);
                allPositions.add(currentPosition);
            }
        }

        return allPositions;
    }
}
