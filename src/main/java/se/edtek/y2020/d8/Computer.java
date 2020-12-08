package se.edtek.y2020.d8;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    public State runProgram(List<Instruction> instructions) {

        int currentInstructionNumber = 0;
        int accumulator = 0;

        Set<Integer> alreadyExecutedInstructions = new HashSet<>();

        while (currentInstructionNumber != instructions.size()) {

            if (alreadyExecutedInstructions.contains(currentInstructionNumber)) {
                return new State(currentInstructionNumber, accumulator, true);
            }

            Instruction instruction = instructions.get(currentInstructionNumber);

            alreadyExecutedInstructions.add(currentInstructionNumber);

            switch (instruction.getOperation()) {

                case ACC:
                    accumulator += instruction.getArgument();
                    currentInstructionNumber++;
                    break;

                case JMP:
                    currentInstructionNumber += instruction.getArgument();
                    break;

                case NOP:
                    currentInstructionNumber++;
                    break;

            }
        }

        return new State(currentInstructionNumber, accumulator, false);

    }
}
