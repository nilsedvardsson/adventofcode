package se.edtek.y2020.d11;

import se.edtek.common.SolutionParent;

import java.util.List;
import java.util.stream.Collectors;

import static se.edtek.y2020.d11.PositionState.*;

public class Solution extends SolutionParent {

    public long task1() {
        List<String> input = lines().collect(Collectors.toList());

        PositionState[][] matrix1 = initWithFloor(input.size() + 2);

        for (int i = 1; i <= input.size(); i++) {
            for (int j = 1; j <= input.size(); j++) {
                matrix1[i][j] = PositionState.of(input.get(i-1).charAt(j-1));
            }
        }

        int mods;
        do {
            mods = runAlgorithm(matrix1);
            // display(matrix1);

        } while (mods > 0);


        return count(matrix1, OCCUPIED_SEAT);
    }

    private void display(PositionState[][] matrix) {
        for (int i = 1; i <= matrix.length - 2; i++) {
            for (int j = 1; j <= matrix.length - 2; j++) {
                System.out.print(matrix[i][j].toString());
            }
            System.out.println();
        }
    }

    private int runAlgorithm(PositionState[][] matrix) {

        //PositionState[][] matrix2 = initWithFloor(matrix.length);
        PositionState[][] matrix2 = new PositionState[matrix.length][matrix.length];
        copy(matrix, matrix2);

        int x = matrix.length - 2;

        int numModifications = 0;

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= x; j++) {

                int adjacentOccupiedSeats = numberOfAdjacentMatches(matrix, i, j, OCCUPIED_SEAT);

                if (matrix[i][j] == EMPTY_SEAT && adjacentOccupiedSeats == 0) {
                    matrix2[i][j] = OCCUPIED_SEAT;
                    numModifications++;

                } else if (matrix[i][j] == OCCUPIED_SEAT && adjacentOccupiedSeats >= 4) {
                    matrix2[i][j] = EMPTY_SEAT;
                    numModifications++;

                }
                else {
                    matrix2[i][j] = matrix[i][j];
                }
            }
        }

        copy(matrix2, matrix);

        return numModifications;
    }

    private void copy(PositionState[][] source, PositionState[][] target) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source.length; j++) {
                target[i][j] = source[i][j];
            }
        }
    }

    private PositionState[][] initWithFloor(int size) {
        PositionState[][] matrix = new PositionState[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = FLOOR;
            }
        }

        return matrix;
    }

    private int numberOfAdjacentMatches(PositionState[][] matrix, int row, int col, PositionState valueToMatch) {

        int[] diff = {-1, 0, 1};
        int matches = 0;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (r == 1 && c == 1) {
                    continue;
                }
                matches += match(matrix[row + diff[r]][col + diff[c]], valueToMatch);
            }
        }
        return matches;
    }

    private int match(PositionState value, PositionState valueToMatch) {
        return value == valueToMatch ? 1 : 0;
    }

    private int count(PositionState[][] matrix, PositionState toCount) {
        int num = 0;
        for (int i = 1; i <= matrix.length - 2; i++) {
            for (int j = 1; j <= matrix.length - 2; j++) {
                if (matrix[i][j] == toCount) {
                    num++;
                }
            }
        }
        return num;
    }

    public long task2() {
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        long result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        long result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);
    }
}
