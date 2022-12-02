package se.edtek.y2022.d1;

import org.apache.commons.lang3.StringUtils;
import se.edtek.common.SolutionParent;

public class Solution extends SolutionParent {

    public long task1() {

        return getCaloriesSum(1);
    }

    public long task2() {

        return getCaloriesSum(3);
    }

    private long getCaloriesSum(long numberOfElfs) {

        final long[] current = {0l};

        return lines().mapToLong(s -> {
                    if (StringUtils.isBlank(s)) {
                        long tmp = current[0];
                        current[0] = 0l;
                        return tmp;
                    } else {
                        current[0] += Long.parseLong(s);
                        return 0l;
                    }
                })
                .filter(l -> l > 0)
                .map(i -> -i)
                .sorted()
                .map(i -> -i)
                .limit(numberOfElfs)
                .sum();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        long result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        long result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);

    }
}
