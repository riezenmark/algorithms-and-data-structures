package iterator;

public class Link {
    public long data;
    public Link next;

    public Link(long data) {
        this.data = data;
    }

    public void display() {
        System.out.print(data + " ");
    }
}
