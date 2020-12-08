package se.edtek.y2020.d8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Instruction {

    private final static Pattern INSTRUCTION_PATTERN = Pattern.compile("(jmp|acc|nop) (.*)");

    private Operation operation;
    private int argument;

    public Instruction(String s) {
        Matcher matcher = INSTRUCTION_PATTERN.matcher(s);
        matcher.find();
        operation = Operation.valueOf(matcher.group(1).toUpperCase());
        argument = Integer.parseInt(matcher.group(2));
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int getArgument() {
        return argument;
    }
}
