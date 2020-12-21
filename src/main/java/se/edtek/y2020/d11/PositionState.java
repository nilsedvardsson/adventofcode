package se.edtek.y2020.d11;

public enum PositionState {
    FLOOR, EMPTY_SEAT, OCCUPIED_SEAT;

    public static PositionState of(char c) {
        switch (c) {
            case '.': return FLOOR;
            case 'L': return EMPTY_SEAT;
            case '#': return OCCUPIED_SEAT;
            default: throw new IllegalArgumentException();
        }
    }

    public String toString() {
        switch (this) {
            case FLOOR: return ".";
            case EMPTY_SEAT: return "L";
            case OCCUPIED_SEAT: return "#";
            default: return "";
        }
    }
}
