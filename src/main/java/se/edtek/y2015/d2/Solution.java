package se.edtek.y2015.d2;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {



    public int task1() throws URISyntaxException, IOException {

        return Files.lines(Paths.get(getURI())).map(s -> new Element(s).getRequiredWrappingPaper()).reduce(0, Integer::sum);
    }

    public int task2() throws IOException, URISyntaxException {

        return Files.lines(Paths.get(getURI())).map(s -> new Element(s).getRequiredRibbon()).reduce(0, Integer::sum);
    }

    private URI getURI() throws URISyntaxException {
        return this.getClass().getClassLoader().getResource("y2015/d2/input.txt").toURI();
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Solution solution = new Solution();

        int result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        int result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);

    }
}
