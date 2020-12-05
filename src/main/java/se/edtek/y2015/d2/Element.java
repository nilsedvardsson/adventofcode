package se.edtek.y2015.d2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Element {

    private List<Integer> sortedDimensions;

    public Element(String s) {

        sortedDimensions = Arrays.asList(s.split("x")).stream().map(Integer::parseInt).collect(Collectors.toList());
        sortedDimensions.sort(Integer::compareTo);
    }

    public int getSurfaceArea() {
        return 2 * (sortedDimensions.get(0) * sortedDimensions.get(1) +
                sortedDimensions.get(0) * sortedDimensions.get(2) +
                sortedDimensions.get(1) * sortedDimensions.get(2));
    }

    public int getAreaOfSmallestSide() {
        return sortedDimensions.get(0) * sortedDimensions.get(1);
    }

    public int getRequiredWrappingPaper() {
        return getSurfaceArea() + getAreaOfSmallestSide();
    }

    public int getRequiredRibbon() {
        return getPerimeterOfSmallestSide() + getVolume();
    }

    public int getVolume() {
        return sortedDimensions.stream().reduce(1, (i1, i2) -> i1 * i2).intValue();
    }

    public int getPerimeterOfSmallestSide() {
        return 2 * (sortedDimensions.get(0) + sortedDimensions.get(1));
    }
}
