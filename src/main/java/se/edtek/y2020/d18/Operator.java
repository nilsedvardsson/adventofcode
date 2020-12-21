package se.edtek.y2020.d18;

public enum Operator {
    ADD, MULTIPLY;

    @Override
    public String toString() {
        return this == ADD ? "+" : "*";
    }
}
