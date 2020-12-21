package se.edtek.y2020.d12;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public static Direction of(char c) {
        switch (c) {
            case 'N': return NORTH;
            case 'S': return SOUTH;
            case 'W': return WEST;
            case 'E': return EAST;
        }
        throw new IllegalArgumentException();
    }

    public Direction rotateLeft(int degrees) {
        return convert(-degrees / 90);
    }

    public Direction rotateRight(int degress) {
        return convert(degress / 90);
    }

    private Direction convert(int ordinalDiff) {
        int newOrdinal = (this.ordinal() + ordinalDiff + 4) % 4;
        return Direction.values()[newOrdinal];
    }
}
