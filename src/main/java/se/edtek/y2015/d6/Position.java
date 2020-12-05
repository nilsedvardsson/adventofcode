package se.edtek.y2015.d6;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Set<Position> build(Position opposite) {
        int xMin = Math.min(x, opposite.x);
        int yMin = Math.min(y, opposite.y);

        int xMax = Math.max(x, opposite.x);
        int yMax = Math.max(y, opposite.y);

        Set<Position> result = new HashSet<>();

        for (int x0 = xMin; x0 <= xMax; x0++) {
            for (int y0 = yMin; y0 <= yMax; y0++) {
                result.add(new Position(x0, y0));
            }
        }

        return result;
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
