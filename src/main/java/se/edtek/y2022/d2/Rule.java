package se.edtek.y2022.d2;

import java.util.Map;

import static se.edtek.y2022.d2.Move.PAPER;
import static se.edtek.y2022.d2.Move.ROCK;
import static se.edtek.y2022.d2.Move.SCISSORS;

public class Rule {

    private final static Map<Move, Move> WINS_OVER = Map.of(
            ROCK, SCISSORS,
            PAPER, ROCK,
            SCISSORS, PAPER);

    public static Move winsOver(Move move) {
        return WINS_OVER.get(move);
    }

    public static Move loosesAgainst(Move move) {

        for (Move m : Move.values()) {
            if (WINS_OVER.get(m) == move) {
                return m;
            }
        }
        throw new RuntimeException("Unexpected error");
    }
}
