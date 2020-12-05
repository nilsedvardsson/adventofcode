package se.edtek.y2015.d6;

public class Board {

    private int[][] values;

    public Board() {
        values = new int[1000][1000];
    }

    public void execute(int diff, int x1, int y1, int x2, int y2) {

        int xMin = Math.min(x1, x2);
        int yMin = Math.min(y1, y2);

        int xMax = Math.max(x1, x2);
        int yMax = Math.max(y1, y2);

        for (int x0 = xMin; x0 <= xMax; x0++) {
            for (int y0 = yMin; y0 <= yMax; y0++) {
                values[x0][y0] += diff;
                if (values[x0][y0] < 0) {
                    values[x0][y0] = 0;
                }
            }
        }
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                sum += values[i][j];
            }
        }
        return sum;
    }

}
