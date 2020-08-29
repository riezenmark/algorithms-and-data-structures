package linked;

public class DoubleSideLinkedList {
    private SimpleLink first;
    private SimpleLink last;

    public DoubleSideLinkedList() {
        this.first = null;
        this.last = null;
    }

    /**
     * O(1)
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * O(1)
     */
    public void insertFirst(double value) {
        SimpleLink newLink = new SimpleLink(value);
        if (this.isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    /**
     * O(1)
     */
    public void insertLast(double value) {
        SimpleLink newLink = new SimpleLink(value);
        if (this.isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    /**
     * O(1)
     */
    public double deleteFirst() {
        double temp = first.data;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    /**
     * O(N)
     */
    public void display() {
        SimpleLink currentLink = first;
        while (currentLink != null) {
            currentLink.display();
            currentLink = currentLink.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleSideLinkedList list = new DoubleSideLinkedList();

        list.insertFirst(22);
        list.insertFirst(44);
        list.insertFirst(66);
        list.display();

        list.insertLast(11);
        list.insertLast(33);
        list.insertLast(55);
        list.display();

        list.deleteFirst();
        list.deleteFirst();
        list.display();
    }
}
