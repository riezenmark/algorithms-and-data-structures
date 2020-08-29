package linked;

public class LinkedQueue {
    private DoubleLinkedList list;

    public LinkedQueue() {
        this.list = new DoubleLinkedList();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void insert(double value) {
        list.insertLast(value);
    }

    public double remove() {
        return list.deleteFirst();
    }

    public void display() {
        list.display();
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.insert(20);
        queue.insert(40);
        queue.display();

        queue.insert(60);
        queue.insert(80);
        queue.display();

        queue.remove();
        queue.remove();
        queue.display();
    }
}
