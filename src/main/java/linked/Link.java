package linked;

public class Link {
    public int id;
    public double data;
    public Link next;

    public Link(int id, double data) {
        this.id = id;
        this.data = data;
    }

    public void display() {
        System.out.println("{" + id + ": " + data + "} ");
    }
}
