package se.edtek.y2020.d13;

import se.edtek.common.SolutionParent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution extends SolutionParent {

    public long task1() {
        List<String> input = lines().collect(Collectors.toList());

        long earliestStart = Long.parseLong(input.get(0));
        String ids = input.get(1);

        long[] result =
                Arrays.stream(ids.split(","))
                        .filter(s -> !s.equals("x"))
                        .map(s -> Long.parseLong(s))
                        .map(l -> new long[] {l, l - earliestStart % l})
                        .min(Comparator.comparingLong(o -> o[1])).get();

        return result[0] * result[1];
    }

    public long task2() {
        List<String> input = lines().collect(Collectors.toList());

        String ids = input.get(1);

        // String ids = "7,13,x,x,59,x,31,19";
        // String ids = "17,x,13,19";
        // String ids = "67,7,59,61";
        // String ids = "67,x,7,59,61";
        // String ids = "67,7,x,59,61";
        // String ids = "1789,37,47,1889";

        List<String> values = Arrays.stream(ids.split(",")).collect(Collectors.toList());

        List<Element> elements = new ArrayList<>();
        int index = 0;

        for (String s : values) {
            if (!s.equals("x")) {
                elements.add(new Element(Long.parseLong(s), index));
            }
            index++;
        }

        Collections.sort(elements);

        for (int y = 0; y < 100000000000000l; y++) {
            System.out.println(y);
        }

        /*
        for (long i = 200000000000l; i < 300000000000l; i++) {

            long t = elements.get(0).getId() * i - elements.get(0).getIndex();

            boolean success = true;

            // for (Element element : elements) {
            for (int k = 1; k < elements.size(); k++) {
                Element element = elements.get(k);

                if ((t + element.getIndex()) % element.getId() != 0) {
                    success = false;
                    break;
                }
            }

            if (success) {
                return t;
            }
        }

         */

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        long result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        long result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);
    }
}
