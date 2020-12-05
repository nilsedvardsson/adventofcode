package se.edtek.common;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class SolutionParent {

    public Stream<String> lines() {
        try {
            return Files.lines(Paths.get(getURI()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private URI getURI() {
        Package p = this.getClass().getPackage();
        String s = p.getName();

        String[] cs = s.split("\\.");

        String fileName = cs[cs.length - 2] + "/" + cs[cs.length - 1] + "/input.txt";

        try {
            return this.getClass().getClassLoader().getResource(fileName).toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
