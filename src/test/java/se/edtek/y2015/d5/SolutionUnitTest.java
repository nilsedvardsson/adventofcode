package se.edtek.y2015.d5;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SolutionUnitTest {

    @Test
    public void testTask1a() {
        assertThat(new SantaText("ugknbfddgicrmopn").isNice(), is(true));
    }

    @Test
    public void testTask1b() {
        assertThat(new SantaText("aaa").isNice(), is(true));
    }

    @Test
    public void testTask1c() {
        assertThat(new SantaText("jchzalrnumimnmhp").isNice(), is(false));
    }

    @Test
    public void testTask1d() {
        assertThat(new SantaText("haegwjzuvuyypxyu").isNice(), is(false));
    }

    @Test
    public void testTask1e() {
        assertThat(new SantaText("dvszwmarrgswjxmb").isNice(), is(false));
    }

    @Test
    public void testTask2a() {
        assertThat(new SantaText2("qjhvhtzxzqqjkmpb").isNice(), is(true));
    }

    @Test
    public void testTask2b() {
        assertThat(new SantaText2("xxyxx").isNice(), is(true));
    }

    @Test
    public void testTask2c() {
        assertThat(new SantaText2("uurcxstgmygtbstg").isNice(), is(false));
    }

    @Test
    public void testTask2d() {
        assertThat(new SantaText2("ieodomkazucvgmuy").isNice(), is(false));
    }
}
