package se.edtek.y2020.d7;

import se.edtek.common.SolutionParent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution extends SolutionParent {

    private Map<String, Set<String>> parentsByChild = new HashMap<>();
    private Map<String, List<Content>> childrenByParent = new HashMap<>();

    private void indexData() {

        List<String> input = lines().collect(Collectors.toList());

        for (String row : input) {

            RowData rowData = new RowData(row);

            childrenByParent.put(rowData.getName(), rowData.getContents());

            for (Content content : rowData.getContents()) {

                String bagName = content.getBagName();

                if (parentsByChild.containsKey(bagName)) {
                    parentsByChild.get(bagName).add(rowData.getName());
                }
                else {
                    Set<String> ns = new HashSet<>();
                    ns.add(rowData.getName());
                    parentsByChild.put(bagName, ns);
                }
            }
        }
    }

    private int task1(Set<String> result, String s) {

        if (!parentsByChild.containsKey(s)) {
            result.add(s);
        }
        else {
            for (String w : parentsByChild.get(s)) {
                result.add(w);
                task1(result, w);
            }
        }

        return result.size();
    }

    private int task2(String s) {
        if (!childrenByParent.containsKey(s)) {
            return 1;
        }
        else {

            int sum = 0;

            for (Content content : childrenByParent.get(s)) {
                sum += content.getNumber() + content.getNumber() * task2(content.getBagName());
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.indexData();

        int result1 = solution.task1(new HashSet<>(),"shiny gold");
        System.out.println("Uppgift 1: " + result1);

        int result2 = solution.task2("shiny gold");
        System.out.println("Uppgift 2: " + result2);
    }
}
