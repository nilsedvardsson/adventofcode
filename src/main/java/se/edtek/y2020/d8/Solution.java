package se.edtek.y2020.d8;

import se.edtek.common.SolutionParent;

import java.util.List;
import java.util.stream.Collectors;

public class Solution extends SolutionParent {

    public int task1() {

        List<Instruction> instructions = lines().map(s -> new Instruction(s)).collect(Collectors.toList());

        State state = new Computer().runProgram(instructions);

        return state.getAccumulator();
    }

    public int task2() {
        List<Instruction> instructions = lines().map(s -> new Instruction(s)).collect(Collectors.toList());

        for (int i = 0; i < instructions.size(); i++) {

            if (instructions.get(i).getOperation() == Operation.JMP) {
                instructions.get(i).setOperation(Operation.NOP);
                State state = new Computer().runProgram(instructions);
                if (!state.isInterrupted()) {
                    return state.getAccumulator();
                }
                instructions.get(i).setOperation(Operation.JMP);
            }
            else if (instructions.get(i).getOperation() == Operation.NOP) {
                instructions.get(i).setOperation(Operation.JMP);
                State state = new Computer().runProgram(instructions);
                if (!state.isInterrupted()) {
                    return state.getAccumulator();
                }
                instructions.get(i).setOperation(Operation.NOP);
            }


        }

        return -1;
    }



    public static void main(String[] args) {

        Solution solution = new Solution();

        int result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        int result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);
    }
}
