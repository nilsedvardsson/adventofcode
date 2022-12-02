package se.edtek.y2022.d2;

import java.util.Set;

public enum Move {

    ROCK(1, "A"),
    PAPER( 2, "B"),
    SCISSORS(3, "C");

    public final int points;
    private final String identifier;

    Move(final int points, final String identifier) {

        this.points = points;
        this.identifier = identifier;
    }

    public static Move of(String identifier) {

        for (Move playout : Move.values()) {
            if (playout.identifier.equals(identifier)) {
                return playout;
            }
        }
        throw new RuntimeException("Unknow identifier %s".formatted(identifier));
    }
}
