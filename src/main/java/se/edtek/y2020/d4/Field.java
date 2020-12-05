package se.edtek.y2020.d4;

import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;

public class Field {

    private String name;
    private Pattern pattern;

    private Function<String, Boolean> valueValidator;

    public Field(String name, String regex) {
        this(name, regex, s -> { return true; });
    }

    public Field(String name, String regex, Function<String, Boolean> valueValidator) {
        this.name = name;
        this.pattern = Pattern.compile(regex);
        this.valueValidator = valueValidator;
    }

    public boolean isValid(Map<String, String> pairs) {
        if (!pairs.containsKey(name)) {
            return false;
        }

        return isValueValid(pairs.get(name));
    }

    public boolean isValueValid(String s) {
        if (!pattern.matcher(s).matches()) {
            return false;
        }

        return valueValidator.apply(s);
    }
}
