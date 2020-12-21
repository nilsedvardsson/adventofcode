package se.edtek.y2020.d12;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static se.edtek.y2020.d12.Direction.EAST;
import static se.edtek.y2020.d12.Direction.NORTH;
import static se.edtek.y2020.d12.Direction.SOUTH;
import static se.edtek.y2020.d12.Direction.WEST;

public class DirectionUnitTest {

    @Test
    public void testRotateLeft() {
        assertThat(NORTH.rotateLeft(90), is(WEST));
        assertThat(NORTH.rotateLeft(180), is(SOUTH));
        assertThat(NORTH.rotateLeft(270), is(EAST));

        assertThat(WEST.rotateLeft(90), is(SOUTH));
        assertThat(WEST.rotateLeft(180), is(EAST));
        assertThat(WEST.rotateLeft(270), is(NORTH));

        assertThat(SOUTH.rotateLeft(90), is(EAST));
        assertThat(SOUTH.rotateLeft(180), is(NORTH));
        assertThat(SOUTH.rotateLeft(270), is(WEST));

        assertThat(EAST.rotateLeft(90), is(NORTH));
        assertThat(EAST.rotateLeft(180), is(WEST));
        assertThat(EAST.rotateLeft(270), is(SOUTH));
    }

    @Test
    public void testRotateRight() {
        assertThat(NORTH.rotateRight(90), is(EAST));
        assertThat(NORTH.rotateRight(180), is(SOUTH));
        assertThat(NORTH.rotateRight(270), is(WEST));

        assertThat(WEST.rotateRight(90), is(NORTH));
        assertThat(WEST.rotateRight(180), is(EAST));
        assertThat(WEST.rotateRight(270), is(SOUTH));

        assertThat(SOUTH.rotateRight(90), is(WEST));
        assertThat(SOUTH.rotateRight(180), is(NORTH));
        assertThat(SOUTH.rotateRight(270), is(EAST));

        assertThat(EAST.rotateRight(90), is(SOUTH));
        assertThat(EAST.rotateRight(180), is(WEST));
        assertThat(EAST.rotateRight(270), is(NORTH));
    }
}
