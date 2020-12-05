package se.edtek.y2019.d4;

import java.util.ArrayList;
import java.util.List;

public class Password2 extends Password {

    public Password2(int number) {
        super(number);
    }

    public boolean isValid() {
        if (!super.isValid()) {
            return false;
        }

        List<Integer> digitsList = new ArrayList<>();

        for (char d : digits) {
            digitsList.add(Integer.parseInt(String.valueOf(d)));
        }

        return digitsList
                .stream()
                .map(n -> new Accumulator(n, 1))
                .reduce(new Accumulator(), (r1, r2) -> r1.combine(r2)).getNumberOfSimilar() == 2;
    }


}
