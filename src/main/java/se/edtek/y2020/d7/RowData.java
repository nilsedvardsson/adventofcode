package se.edtek.y2020.d7;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RowData {

    private String name;
    private List<Content> contents;

    private final static Pattern NAME_REGEX = Pattern.compile("([^ ]* [^ ]*) .*");
    private final static Pattern CONTENT_REGEX = Pattern.compile("(\\d+) ([^ ]* [^ ]*)");

    public RowData(String s) {
        Matcher nameMatcher = NAME_REGEX.matcher(s);

        if (nameMatcher.find()) {
            name = nameMatcher.group(1);
        }

        Matcher contentMatcher = CONTENT_REGEX.matcher(s);

        contents = new ArrayList<>();
        while (contentMatcher.find()) {
            contents.add(new Content(contentMatcher.group(2), Integer.parseInt(contentMatcher.group(1))));
        }
    }

    public String getName() {
        return name;
    }

    public List<Content> getContents() {
        return contents;
    }
}
