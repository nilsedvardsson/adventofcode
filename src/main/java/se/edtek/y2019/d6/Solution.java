package se.edtek.y2019.d6;

import org.apache.commons.lang3.StringUtils;
import se.edtek.y2015.common.SolutionParent;

import java.util.HashMap;
import java.util.Map;

public class Solution extends SolutionParent {

    private Map<String, SpaceObject> objects;

    public Solution() {
        buildObjectGraph();

    }

    public int task1() {
        return objects.values().stream().mapToInt(o -> o.pathToCom().length() / 3 - 1).sum();
    }

    public int task2() {

        String y = objects.get("YOU").pathToCom();
        String s = objects.get("SAN").pathToCom();

        String prefix = StringUtils.getCommonPrefix(y, s);

        return (y.length() + s.length() - 2 * prefix.length()) / 3 - 2;
    }

    private void buildObjectGraph() {
        objects = new HashMap<>();

        lines().forEach(s -> {
            String[] values = s.split("\\)");
            getObject(values[1]).setNext(getObject(values[0]));
        });
    }

    private SpaceObject getObject(String id) {
        SpaceObject object = objects.get(id);
        if (object == null) {
            object = new SpaceObject(id);
            objects.put(id, object);
        }
        return object;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        int result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);
    }
}
