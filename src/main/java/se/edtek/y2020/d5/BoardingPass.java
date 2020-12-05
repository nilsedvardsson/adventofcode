package se.edtek.y2020.d5;

public class BoardingPass {

    private String s;

    public BoardingPass(String s) {
        this.s = s;
    }

    public int getRow() {

        int min = 0;
        int max = 127;

        for (int i = 0; i < 7; i++) {
            int span = (max - min + 1) / 2;

            if (s.charAt(i) == 'F') {
                max -= span;
            }
            else {
                min += span;
            }
        }

        return min;
    }

    public int getColumn() {

        int min = 0;
        int max = 7;

        for (int i = 7; i < 10; i++) {
            int span = (max - min + 1) / 2;

            if (s.charAt(i) == 'L') {
                max -= span;
            }
            else {
                min += span;
            }
        }

        return min;
    }

    public int getId() {
        return getRow() * 8 + getColumn();
    }
}
