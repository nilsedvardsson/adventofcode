package se.edtek.y2020.d2;

public class Rule {

    private int integer1;
    private int integer2;
    private String character;

    public Rule(String s) {

        String[] values = s.split(" ");
        String[] minMax = values[0].split("-");
        this.integer1 = Integer.parseInt(minMax[0]);
        this.integer2 = Integer.parseInt(minMax[1]);
        this.character = values[1];
    }

    public int getInteger1() {
        return integer1;
    }

    public int getInteger2() {
        return integer2;
    }

    public String getCharacter() {
        return character;
    }
}
