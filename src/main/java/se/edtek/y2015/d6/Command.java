package se.edtek.y2015.d6;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command {

    private String s;

    public Command(String s) {
        this.s = s;
    }

    private int[] getNumbers() {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(s);
        int[] numbers = new int[4];
        for (int i = 0; i < 4; i++) {
            matcher.find();
            numbers[i] = Integer.parseInt(matcher.group());
        }
        return numbers;
    }

    public void execute2(Board board) {

        int[] numbers = getNumbers();

        int diff = 0;

        if (s.startsWith("turn on")) {

            diff = 1;

            // board.addAll(positions);
        }
        else if (s.startsWith("turn off")) {

            // board.removeAll(positions);

            diff = -1;
        }
        else if (s.startsWith("toggle")) {
            diff = 2;
        }

        board.execute(diff, numbers[0], numbers[1], numbers[2], numbers[3]);

    }

    public void execute(Set<Position> board) {

        int[] numbers = getNumbers();

        Position p1 = new Position(numbers[0], numbers[1]);
        Position p2 = new Position(numbers[2], numbers[3]);

        Set<Position> positions = p1.build(p2);

        if (s.startsWith("turn on")) {

            board.addAll(positions);
        }
        else if (s.startsWith("turn off")) {

            board.removeAll(positions);
        }
        else if (s.startsWith("toggle")) {

            for (Position p : positions) {
                if (board.contains(p)) {
                    board.remove(p);
                }
                else {
                    board.add(p);
                }
            }
        }
    }


}
