package linked;

public class SimpleLink {
    public double data;
    public SimpleLink next;

    public SimpleLink(double data) {
        this.data = data;
    }

    public void display() {
        System.out.println(data + " ");
    }
}
