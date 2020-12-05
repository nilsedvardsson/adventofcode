package se.edtek.y2020.d5;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BoardingPassUnitTest {

    @Test
    public void testRowNumber() {
        assertThat(new BoardingPass("BFFFBBFRRR").getRow(), is(70));
        assertThat(new BoardingPass("FFFBBBFRRR").getRow(), is(14));
        assertThat(new BoardingPass("BBFFBBFRLL").getRow(), is(102));
    }

    @Test
    public void testColumnNumber() {
        assertThat(new BoardingPass("BFFFBBFRRR").getColumn(), is(7));
        assertThat(new BoardingPass("FFFBBBFRRR").getColumn(), is(7));
        assertThat(new BoardingPass("BBFFBBFRLL").getColumn(), is(4));
    }
}
