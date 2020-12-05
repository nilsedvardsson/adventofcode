package se.edtek.y2015.d6;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CommandUnitTest {

    @Test
    public void testSimple() {
        Set<Position> board = new HashSet<>();
        new Command("turn on 0,0 through 999,999").execute(board);
        assertThat(board.size(), is(1000000));
        new Command("turn off 100,100 through 101,101").execute(board);
        assertThat(board.size(), is(1000000 - 4));

    }
}
