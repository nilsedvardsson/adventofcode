package se.edtek.y2022.d2;

public class Task2Mapper implements Mapper {

    @Override
    public Move getMyMove(final Move opponent, final String code) {

        return switch (code) {
            case "X" -> Rule.winsOver(opponent);
            case "Y" -> opponent;
            case "Z" -> Rule.loosesAgainst(opponent);
            default -> throw new RuntimeException("unknown code %s".formatted(code));
        };
    }
}
