package se.edtek.y2020.d2;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PasswordlineUnitTest {

    @Test
    public void testSplittingDataInString() {

        Passwordline passwordline = new Passwordline("8-9 x: xxxxxxxrk");

        assertThat(passwordline.getPassword(), is("xxxxxxxrk"));
        assertThat(passwordline.getRule().getInteger1(), is(8));
        assertThat(passwordline.getRule().getInteger2(), is(9));
        assertThat(passwordline.getRule().getCharacter(), is("x"));
    }

    @Test
    public void testValidCheck1() {
        assertThat(new Passwordline("8-9 x: xxxxxxxrk").isValidTask1(), is(false));
    }

    @Test
    public void testValidCheck2() {
        assertThat(new Passwordline("5-10 x: xxxxxxxrk").isValidTask1(), is(true));
    }
}
