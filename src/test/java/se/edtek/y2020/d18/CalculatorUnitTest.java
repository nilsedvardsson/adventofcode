package se.edtek.y2020.d18;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CalculatorUnitTest {

    @Test
    public void test1() {
        String input = "1 + 2 * 3 + 4 * 5 + 6";

        List<String> parts = new Splitter().split(input);

        assertThat(parts.get(0), is("1"));
        assertThat(parts.get(1), is("+ 2"));
        assertThat(parts.get(2), is("* 3"));
        assertThat(parts.get(3), is("+ 4"));
        assertThat(parts.get(4), is("* 5"));
        assertThat(parts.get(5), is("+ 6"));
        assertThat(parts.size(), is(6));

        assertThat(new LeftToRightExpressionEvaluator().evaluate(Node.of(input)), is(71l));
        assertThat(new AddFirstExpressionEvaluator().evaluate(Node.of(input)), is(231l));
    }

    @Test
    public void test1b() {
        String input = "1 + (2 * 3) + (4 * (5 + 6))";

        List<String> parts = new Splitter().split(input);

        assertThat(parts.get(0), is("1"));
        assertThat(parts.get(1), is("+ (2 * 3)"));
        assertThat(parts.get(2), is("+ (4 * (5 + 6))"));
        assertThat(parts.size(), is(3));

        assertThat(new LeftToRightExpressionEvaluator().evaluate(Node.of(input)), is(51l));
        assertThat(new AddFirstExpressionEvaluator().evaluate(Node.of(input)), is(51l));
    }

    @Test
    public void test2() {
        String input = "2 * 3 + (4 * 5)";

        List<String> parts = new Splitter().split(input);

        assertThat(parts.get(0), is("2"));
        assertThat(parts.get(1), is("* 3"));
        assertThat(parts.get(2), is("+ (4 * 5)"));
        assertThat(parts.size(), is(3));

        assertThat(new LeftToRightExpressionEvaluator().evaluate(Node.of(input)), is(26l));
        assertThat(new AddFirstExpressionEvaluator().evaluate(Node.of(input)), is(46l));
    }

    @Test
    public void test3() {
        String input = "5 + (8 * 3 + 9 + 3 * 4 * 3)";

        List<String> parts = new Splitter().split(input);

        assertThat(parts.get(0), is("5"));
        assertThat(parts.get(1), is("+ (8 * 3 + 9 + 3 * 4 * 3)"));
        assertThat(parts.size(), is(2));

        assertThat(new LeftToRightExpressionEvaluator().evaluate(Node.of(input)), is(437l));
        assertThat(new AddFirstExpressionEvaluator().evaluate(Node.of(input)), is(1445l));
    }

    @Test
    public void test4() {
        String input = "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))";

        List<String> parts = new Splitter().split(input);

        assertThat(parts.get(0), is("5"));
        assertThat(parts.get(1), is("* 9"));
        assertThat(parts.get(2), is("* (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"));
        assertThat(parts.size(), is(3));

        assertThat(new LeftToRightExpressionEvaluator().evaluate(Node.of(input)), is(12240l));
        assertThat(new AddFirstExpressionEvaluator().evaluate(Node.of(input)), is(669060l));
    }

    @Test
    public void test5() {
        String input = "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2";

        List<String> parts = new Splitter().split(input);

        assertThat(parts.get(0), is("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6)"));
        assertThat(parts.get(1), is("+ 2"));
        assertThat(parts.get(2), is("+ 4"));
        assertThat(parts.get(3), is("* 2"));
        assertThat(parts.size(), is(4));

        assertThat(new LeftToRightExpressionEvaluator().evaluate(Node.of(input)), is(13632l));
        assertThat(new AddFirstExpressionEvaluator().evaluate(Node.of(input)), is(23340l));
    }

    @Test
    public void test6() {
        String input = "9 + (6 * (4 * 8 + 2 * 4 + 8 + 6) * 4 * 5 * (7 * 8 * 9 + 3 * 4) + 8) + ((2 + 7 * 5 + 8) * 5 * (3 + 8) + 5 + 8 * (7 + 8)) + (2 + 2 + 5 + 7 + 7)";

        List<String> parts = new Splitter().split(input);

        assertThat(parts.get(0), is("9"));
        assertThat(parts.get(1), is("+ (6 * (4 * 8 + 2 * 4 + 8 + 6) * 4 * 5 * (7 * 8 * 9 + 3 * 4) + 8)"));
        assertThat(parts.get(2), is("+ ((2 + 7 * 5 + 8) * 5 * (3 + 8) + 5 + 8 * (7 + 8))"));
        assertThat(parts.get(3), is("+ (2 + 2 + 5 + 7 + 7)"));
        assertThat(parts.size(), is(4));

    }
}
