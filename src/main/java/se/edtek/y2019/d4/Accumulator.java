package se.edtek.y2019.d4;

public class Accumulator {

    private int currentDigit;
    private int numberOfSimilar;

    public Accumulator(int currentDigit, int numberOfSimilar) {
        this.currentDigit = currentDigit;
        this.numberOfSimilar = numberOfSimilar;
    }

    public Accumulator() {
        currentDigit = 0;
        numberOfSimilar = 1;
    }

    public Accumulator combine(Accumulator other) {
        if (currentDigit == other.currentDigit) {
            return new Accumulator(currentDigit, numberOfSimilar + 1);
        }
        else if (numberOfSimilar == 2) {
            return this;
        }
        else {
            return other;
        }
    }

    public int getNumberOfSimilar() {
        return numberOfSimilar;
    }
}
