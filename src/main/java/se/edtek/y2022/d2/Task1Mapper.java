package se.edtek.y2022.d2;

import static se.edtek.y2022.d2.Move.PAPER;
import static se.edtek.y2022.d2.Move.ROCK;
import static se.edtek.y2022.d2.Move.SCISSORS;

public class Task1Mapper implements Mapper {

    @Override
    public Move getMyMove(final Move opponent, final String code) {
        return switch (code) {
            case "X" -> ROCK;
            case "Y" -> PAPER;
            case "Z" -> SCISSORS;
            default -> throw new RuntimeException("unknown code %s".formatted(code));
        };
    }
}
