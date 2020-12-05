package se.edtek.y2015.d1;

public class Element {

    private int inc;
    private int sum;
    private int index;

    public Element(int inc) {
        this.inc = inc;
    }

    public Element(int inc, int sum, int index) {
        this.inc = inc;
        this.sum = sum;
        this.index = index;
    }

    public static Element starter() {
        return new Element(0, 0, 0);
    }

    public Element add(Element e) {
        return new Element(e.getInc(), getSum() + e.getInc(), getIndex() + 1);
    }

    public int getInc() {
        return inc;
    }

    public void setInc(int inc) {
        this.inc = inc;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
