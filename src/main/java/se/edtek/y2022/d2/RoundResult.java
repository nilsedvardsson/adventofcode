package se.edtek.y2022.d2;

public enum RoundResult {

    WON(6),
    DRAW(3),
    LOST(0);

    public final int points;

    RoundResult(final int points) {

        this.points = points;
    }

    public static RoundResult play(Move opponent, Move myself) {

        return myself == opponent ? DRAW : Rule.winsOver(myself) == opponent ? WON : LOST;
    }
}
