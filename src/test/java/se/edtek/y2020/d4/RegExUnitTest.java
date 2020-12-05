package se.edtek.y2020.d4;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RegExUnitTest {

    @Test
    public void testFourDigits() {
        Pattern pattern = Pattern.compile("\\d{4}");
        assertThat(pattern.matcher("1920").matches(), is(true));
        assertThat(pattern.matcher("192").matches(), is(false));
        assertThat(pattern.matcher("19201").matches(), is(false));
        assertThat(pattern.matcher(" 1920").matches(), is(false));
    }

    @Test
    public void testHeight() {
        Pattern pattern = Pattern.compile("\\d+(cm|in)");
        assertThat(pattern.matcher("15cm").matches(), is(true));
        assertThat(pattern.matcher("1in").matches(), is(true));
        assertThat(pattern.matcher("in").matches(), is(false));
        assertThat(pattern.matcher("11i").matches(), is(false));
    }

    @Test
    public void testHairColor() {
        Pattern pattern = Pattern.compile("#[0-9,a-f]{6}");
        assertThat(pattern.matcher("#123abc").matches(), is(true));
        assertThat(pattern.matcher("#123abz").matches(), is(false));
        assertThat(pattern.matcher("123abc").matches(), is(false));
    }

    @Test
    public void testEyeColor() {
        Pattern pattern = Pattern.compile("amb|blu|brn|gry|grn|hzl|oth");
        assertThat(pattern.matcher("brn").matches(), is(true));
        assertThat(pattern.matcher("wat").matches(), is(false));
    }

    @Test
    public void testPid() {
        Pattern pattern = Pattern.compile("\\d{9}");
        assertThat(pattern.matcher("000000001").matches(), is(true));
        assertThat(pattern.matcher("0123456789").matches(), is(false));
    }
}
