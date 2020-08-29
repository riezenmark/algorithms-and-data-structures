package linked;

public class LinkedList {
    private Link first;

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * O(1)
     */
    public void insertFirst(int id, double data) {
        Link newLink = new Link(id, data);
        newLink.next = first;
        first = newLink;
    }

    /**
     * O(1)
     */
    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    /**
     * O(N)
     */
    public void display() {
        Link currentLink = first;
        while (currentLink != null) {
            currentLink.display();
            currentLink = currentLink.next;
        }
        System.out.println();
    }

    /**
     * O(N)
     */
    public Link find(int key) {
        Link currentLink = first;
        while (currentLink.id != key) {
            if (currentLink.next == null) {
                return null;
            } else {
                currentLink = currentLink.next;
            }
        }
        return currentLink;
    }

    /**
     * O(N), но работает быстрее удаления в массиве из-за отсутствия необходимости перемещать значения
     */
    public Link delete(int key) {
        Link currentLink = first;
        Link previousLink = first;
        while (currentLink.id != key) {
            if (currentLink.next == null) {
                return null;
            } else {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        if (currentLink == first) {
            first = first.next;
        } else {
            previousLink.next = currentLink.next;
        }
        return currentLink;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFirst(22, 2.99);
        list.insertFirst(44, 4.99);
        list.insertFirst(66, 6.99);
        list.insertFirst(88, 8.99);
        list.display();

        while (!list.isEmpty()) {
            Link link = list.deleteFirst();
            System.out.print("Deleted ");
            link.display();
        }
        list.display();

        LinkedList theList = new LinkedList();
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);
        theList.display();

        Link f = theList.find(44);
        if (f != null) {
            System.out.println("Found link with key " + f.id);
        } else {
            System.out.println("Can’t find link");
        }
        Link d = theList.delete(66);
        if (d != null) {
            System.out.println("Deleted link with key " + d.id);
        } else {
            System.out.println("Can’t delete link");
        }
        theList.display();
    }
}
