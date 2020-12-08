package se.edtek.y2020.d8;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class InstructionUnitTest {

    @Test
    public void testParseJmp() {
        Instruction instruction = new Instruction("jmp +301");
        assertThat(instruction.getOperation(), is(Operation.JMP));
        assertThat(instruction.getArgument(), is(301));
    }

    @Test
    public void testParseAcc() {
        Instruction instruction = new Instruction("acc -15");
        assertThat(instruction.getOperation(), is(Operation.ACC));
        assertThat(instruction.getArgument(), is(-15));
    }

    @Test
    public void testParseNop() {
        Instruction instruction = new Instruction("nop +582");
        assertThat(instruction.getOperation(), is(Operation.NOP));
        assertThat(instruction.getArgument(), is(582));
    }
}
