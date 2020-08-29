package linked;

public class SortedList {
    private SimpleLink first;

    public SortedList() {
        this.first = null;
    }

    /**
     * O(N)
     */
    public void insert(double value) {
        SimpleLink newLink = new SimpleLink(value);
        SimpleLink previous = null;
        SimpleLink current = first;
        while (current != null && value > current.data) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = newLink;
        } else {
            previous.next = newLink;
        }
        newLink.next = current;
    }

    /**
     * O(N)
     */
    public SimpleLink remove() {
        SimpleLink temp = first;
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
        SortedList list = new SortedList();
        list.insert(20);
        list.insert(40);
        list.display();

        list.insert(10);
        list.insert(30);
        list.insert(50);
        list.display();

        list.remove();
        list.display();
    }
}
