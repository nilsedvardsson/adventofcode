package se.edtek.y2015.d2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SolutionUnitTest {

    @Test
    public void testTask1a() {
        assertThat(new Element("2x3x4").getRequiredWrappingPaper(), is(58));
    }

    @Test
    public void testTask1b() {
        assertThat(new Element("1x1x10").getRequiredWrappingPaper(), is(43));
    }

    @Test
    public void testTask2a() {
        assertThat(new Element("2x3x4").getRequiredRibbon(), is(34));
    }

    @Test
    public void testTask2b() {
        assertThat(new Element("1x1x10").getRequiredRibbon(), is(14));
    }
}
