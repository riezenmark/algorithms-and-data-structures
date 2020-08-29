package iterator;

public class LinkedList {
    private Link first;

    public LinkedList() {
        this.first = null;
    }

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public ListIterator getIterator() {
        return new ListIterator(this);
    }

    public void display() {
        Link current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }
}
