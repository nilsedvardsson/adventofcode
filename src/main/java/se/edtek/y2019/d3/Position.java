package se.edtek.y2019.d3;

import java.util.Objects;

public class Position {

    private int x;
    private int y;

    private Position next;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position move(String direction) {
        this.next = doMove(direction);
        return this.next;
    }

    public Position doMove(String direction) {
        switch (direction) {

            case "L": return new Position(x - 1, y);
            case "R": return new Position(x + 1, y);
            case "U": return new Position(x, y - 1);
            case "D": return new Position(x, y + 1);

        }

        throw new RuntimeException("Unknown direction " + direction);
    }

    public int manhattanDistance(Position otherPosition) {
        return Math.abs(x - otherPosition.x) + Math.abs(y - otherPosition.y);
    }

    public int distance(Position target) {

        Position current = this;
        int steps = 0;

        while (!current.equals(target)) {
            steps++;
            current = current.next;
        }

        return steps;
    }

    public static Position origin() {
        return new Position(0, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
