package linked;

public class DoubleLinkedList {
    private DoubleLink first;
    private DoubleLink last;

    public DoubleLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long value) {
        DoubleLink newLink = new DoubleLink(value);
        if (this.isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long value) {
        DoubleLink newLink = new DoubleLink(value);
        if (this.isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public DoubleLink deleteFirst() {
        DoubleLink temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    public DoubleLink deleteLast() {
        DoubleLink temp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    public boolean insertAfter(long key, long value) {
        DoubleLink current = first;
        while (current.data != key) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        DoubleLink newLink = new DoubleLink(value);
        if (current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }

    public DoubleLink deleteByKey(long key) {
        DoubleLink current = first;
        while (current.data != key) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }
        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }
        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current;
    }

    public void displayForward() {
        System.out.println("List (first --> last): ");
        DoubleLink current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        System.out.println("List (last --> first): ");
        DoubleLink current = last;
        while (current != null) {
            current.display();
            current = current.previous;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.insertFirst(22);
        list.insertFirst(44);
        list.insertFirst(66);

        list.insertLast(11);
        list.insertLast(33);
        list.insertLast(55);
        list.displayForward();

        list.displayBackward();

        list.deleteFirst();
        list.deleteLast();
        list.deleteByKey(11);
        list.displayForward();

        list.insertAfter(22, 77);
        list.insertAfter(33, 88);
        list.displayForward();
    }
}
