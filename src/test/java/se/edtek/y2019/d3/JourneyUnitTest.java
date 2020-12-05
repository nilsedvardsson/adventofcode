package se.edtek.y2019.d3;

import org.junit.Test;

import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JourneyUnitTest {

    @Test
    public void testTask1a() {

        Set<Position> allPositions = Journey.makeJourney("R2,U3", Position.origin());
        assertThat(allPositions.size(), is(6));

        assertThat(allPositions.contains(new Position(0, 0)), is(true));
        assertThat(allPositions.contains(new Position(1, 0)), is(true));
        assertThat(allPositions.contains(new Position(2, 0)), is(true));
        assertThat(allPositions.contains(new Position(2, -1)), is(true));
        assertThat(allPositions.contains(new Position(2, -1)), is(true));
        assertThat(allPositions.contains(new Position(2, -1)), is(true));
    }
}
