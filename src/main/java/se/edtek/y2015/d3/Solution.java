package se.edtek.y2015.d3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    public String loadFile() throws IOException, URISyntaxException {
        URL url = this.getClass().getClassLoader().getResource("y2015/d3/input.txt");
        return new String (Files.readAllBytes(Paths.get(url.toURI())));
    }

    public int task1() throws IOException, URISyntaxException {

        return loadFile()
                .codePoints()
                .mapToObj(c -> (char) c)
                .map(c -> new Reducer(c))
                .reduce(new Reducer(), (r1, r2) -> r1.move(r2))
                .getNumberOfVisitedPositions();

    }

    private Set<Position> getVisitedPositions(Stream<Character> stream) {
        return stream.map(c -> new Reducer(c))
                .reduce(new Reducer(), (r1, r2) -> r1.move(r2))
                .getVisitedPositions();
    }

    public int task2() throws IOException, URISyntaxException {

        String s = loadFile();

        Stream<Character> santaDirections = IntStream.range(0, s.length()).filter(n -> n % 2 == 0).mapToObj(n -> s.charAt(n));
        Stream<Character> santaRobotDirections = IntStream.range(0, s.length()).filter(n -> n % 2 == 1).mapToObj(n -> s.charAt(n));

        Set<Position> santasPositions = getVisitedPositions(santaDirections);
        Set<Position> santaRobotPositions = getVisitedPositions(santaRobotDirections);

        Set<Position> allPositions = new HashSet<>(santasPositions);
        allPositions.addAll(santaRobotPositions);

        return allPositions.size();
    }

    public static void main(String[] args) throws IOException, URISyntaxException {

        Solution solution = new Solution();

        int result1 = solution.task1();
        System.out.println("Uppgift 1: " + result1);

        int result2 = solution.task2();
        System.out.println("Uppgift 2: " + result2);

    }

}
