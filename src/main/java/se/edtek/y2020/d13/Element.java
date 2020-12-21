package se.edtek.y2020.d13;

public class Element implements Comparable<Element> {

    private long id;
    private int index;

    public Element(long id, int index) {
        this.id = id;
        this.index = index;
    }

    public long getId() {
        return id;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Element o) {
        return -Long.compare(id, o.id);
    }
}
