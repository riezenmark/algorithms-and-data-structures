package linked;

public class DoubleLink {
    public long data;
    public DoubleLink next;
    public DoubleLink previous;

    public DoubleLink(long data) {
        this.data = data;
    }

    public void display() {
        System.out.print(data + " ");
    }
}
