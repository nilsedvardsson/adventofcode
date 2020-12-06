package se.edtek.y2020.d6;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TokenizerUnitTest {

    @Test
    public void testSimple() {
        String s = "abc";
        String[] r = s.split("");
        assertThat(r.length, is(3));
        assertThat(r[0], is("a"));
        assertThat(r[1], is("b"));
        assertThat(r[2], is("c"));
    }
}
