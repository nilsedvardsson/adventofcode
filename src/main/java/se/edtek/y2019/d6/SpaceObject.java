package se.edtek.y2019.d6;

public class SpaceObject {

    private String id;
    private SpaceObject next;

    public SpaceObject(String id) {
        this.id = id;
    }

    public void setNext(SpaceObject next) {
        this.next = next;
    }

    public String pathToCom() {
        if (next == null) {
            return id;
        }

        return next.pathToCom() + id;
    }
}
