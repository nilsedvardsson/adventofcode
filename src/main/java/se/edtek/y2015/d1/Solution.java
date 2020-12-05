package se.edtek.y2015.d1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {

    public String loadFile() throws IOException, URISyntaxException {
        URL url = this.getClass().getClassLoader().getResource("y2015/d1/input.txt");
        return new String (Files.readAllBytes(Paths.get(url.toURI())));
    }

    public int task1() throws IOException, URISyntaxException {
        return loadFile().codePoints().mapToObj(c -> (char) c).mapToInt(c -> { return c == '(' ? +1 : -1; }).reduce(0, Integer::sum);
    }

    public int task2() throws IOException, URISyntaxException {
        return loadFile()
                .codePoints()
                .mapToObj(c -> (char) c)
                .mapToInt(c -> { return c == '(' ? +1 : -1; })
                .mapToObj(i -> new Element(i))
                .reduce(Element.starter(), (e1, e2) -> e1.getSum() < 0 ? e1 : e1.add(e2)).getIndex();
    }

    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();

        int result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        int result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);

    }
}
