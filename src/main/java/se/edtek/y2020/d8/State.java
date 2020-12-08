package se.edtek.y2020.d8;

public class State {

    private int currentInstructionNumber;
    private int accumulator;
    private boolean interrupted;

    public State(int currentInstructionNumber, int accumulator, boolean interrupted) {
        this.currentInstructionNumber = currentInstructionNumber;
        this.accumulator = accumulator;
        this.interrupted = interrupted;
    }

    public int getCurrentInstructionNumber() {
        return currentInstructionNumber;
    }

    public void setCurrentInstructionNumber(int currentInstructionNumber) {
        this.currentInstructionNumber = currentInstructionNumber;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public void setAccumulator(int accumulator) {
        this.accumulator = accumulator;
    }

    public boolean isInterrupted() {
        return interrupted;
    }

    public void setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
    }
}
