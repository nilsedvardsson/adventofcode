package se.edtek.y2019.d4;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PasswordUnitTest {

    @Test
    public void test1a() {
        assertThat(new Password(111111).isValid(), is(true));
    }

    @Test
    public void test1b() {
        assertThat(new Password(223450).isValid(), is(false));
    }

    @Test
    public void test1c() {
        assertThat(new Password(123789).isValid(), is(false));
    }
}
