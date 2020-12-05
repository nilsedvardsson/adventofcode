package se.edtek.y2015.d3;

import java.util.Objects;

public class Position {

    private int x;
    private int y;

    public static Position zero() {
        return new Position(0, 0);
    }

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position move(char direction) {

        switch (direction) {
            case '<': return new Position(x - 1, y);
            case '>': return new Position(x + 1, y);
            case '^': return new Position(x, y - 1);
            case 'v': return new Position(x, y + 1);
            default: throw new RuntimeException("Unknown direction " + direction);
        }
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
