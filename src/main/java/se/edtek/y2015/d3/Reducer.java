package se.edtek.y2015.d3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Reducer {

    private char direction;

    private Position currenPosition;
    private Set<Position> visitedPositions;

    public Reducer(char direction) {
        this.direction = direction;
    }

    public Reducer() {
        visitedPositions = new HashSet<>();
        updateCurrentPosition(Position.zero());
    }

    private void updateCurrentPosition(Position newPosition) {
        this.currenPosition = newPosition;
        visitedPositions.add(newPosition);
    }

    public Reducer move(Reducer reducer) {
        updateCurrentPosition(currenPosition.move(reducer.direction));
        return this;
    }

    public int getNumberOfVisitedPositions() {
        return visitedPositions.size();
    }

    public Set<Position> getVisitedPositions() {
        return new HashSet<>(visitedPositions);
    }
}
