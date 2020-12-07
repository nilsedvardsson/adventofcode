package se.edtek.y2020.d7;

public class Content {

    private String bagName;
    private int number;

    public Content(String name, int number) {
        this.bagName = name;
        this.number = number;
    }

    public String getBagName() {
        return bagName;
    }

    public int getNumber() {
        return number;
    }
}
