package se.edtek.y2015.d4;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SolutionUnitTest {

    @Test
    public void testTask1a() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        assertThat(new Solution().task("abcdef", "00000"), is(609043));
    }

    @Test
    public void testTask1b() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        assertThat(new Solution().task("pqrstuv", "00000"), is(1048970));
    }

}
