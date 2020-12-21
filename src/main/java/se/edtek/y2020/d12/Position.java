package se.edtek.y2020.d12;

import java.text.Normalizer;

public class Position {

    private int north;
    private int east;

    public Position(int north, int east) {
        this.north = north;
        this.east = east;
    }

    public int getNorth() {
        return north;
    }

    public int getEast() {
        return east;
    }

    public void moveNorth(int value) {
        north += value;
    }

    public void moveSouth(int value) {
        north -= value;
    }

    public void moveEast(int value) {
        east += value;
    }

    public void moveWest(int value) {
        east -= value;
    }

    public void moveForward(Direction direction, int value) {
        switch (direction) {
            case NORTH: moveNorth(value); break;
            case SOUTH: moveSouth(value); break;
            case EAST: moveEast(value); break;
            case WEST: moveWest(value); break;
        }
    }

    public int manhattanDistance(Position position) {
        return Math.abs(position.north - this.north) + Math.abs(position.east - this.east);
    }

    public Position subtract(Position other) {
        return new Position(this.north - other.north, this.east - other.east);
    }

    public Position add(Position other) {
        return new Position(this.north + other.north, this.east + other.east);
    }

    public Position rotateLeft(int degrees) {
        int newNorth = north;
        int newEast = east;
        switch (degrees) {
            case 90:
                newNorth = east;
                newEast = -north;
                break;
            case 180:
                newNorth = -north;
                newEast = -east;
                break;
            case 270:
                newNorth = -east;
                newEast = north;
                break;
        }

        north = newNorth;
        east = newEast;

        return this;
    }

    public Position rotateRight(int degrees) {
        int newNorth = north;
        int newEast = east;
        switch (degrees) {
            case 90:
                newNorth = -east;
                newEast = north;
                break;
            case 180:
                newNorth = -north;
                newEast = -east;
                break;
            case 270:
                newNorth = east;
                newEast = -north;
                break;
        }

        north = newNorth;
        east = newEast;

        return this;
    }

    @Override
    public String toString() {
        return "Position{" +
                "north=" + north +
                ", east=" + east +
                '}';
    }
}
