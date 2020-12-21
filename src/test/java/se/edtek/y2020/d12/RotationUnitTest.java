package se.edtek.y2020.d12;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RotationUnitTest {

    @Test
    public void testRotateLeft90() {
        Position pos = new Position(1, 10).rotateLeft(90);
        assertThat(pos.getNorth(), is(10));
        assertThat(pos.getEast(), is(-1));
    }

    @Test
    public void testRotateLeft180() {
        Position pos = new Position(1, 10).rotateLeft(180);
        assertThat(pos.getNorth(), is(-1));
        assertThat(pos.getEast(), is(-10));
    }

    @Test
    public void testRotateLeft270() {
        Position pos = new Position(1, 10).rotateLeft(270);
        assertThat(pos.getNorth(), is(-10));
        assertThat(pos.getEast(), is(1));
    }

    @Test
    public void testRotateRight90() {
        Position pos = new Position(1, 10).rotateRight(90);
        assertThat(pos.getNorth(), is(-10));
        assertThat(pos.getEast(), is(1));
    }

    @Test
    public void testRotateRight180() {
        Position pos = new Position(1, 10).rotateRight(180);
        assertThat(pos.getNorth(), is(-1));
        assertThat(pos.getEast(), is(-10));
    }

    @Test
    public void testRotateRight270() {
        Position pos = new Position(1, 10).rotateRight(270);
        assertThat(pos.getNorth(), is(10));
        assertThat(pos.getEast(), is(-1));
    }
}
