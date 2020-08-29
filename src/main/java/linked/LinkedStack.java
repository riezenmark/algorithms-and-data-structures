package linked;

public class LinkedStack {
    private final LinkedList list;

    public LinkedStack() {
        this.list = new LinkedList();
    }

    public void push(int id, double value) {
        list.insertFirst(id, value);
    }

    public Link pop() {
        return list.deleteFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void display() {
        list.display();
    }

    public static void main(String[] args) {
        LinkedStack theStack = new LinkedStack();
        theStack.push(1, 20);
        theStack.push(2, 40);
        theStack.display();

        theStack.push(3, 60);
        theStack.push(4, 80);
        theStack.display();

        theStack.pop();
        theStack.pop();
        theStack.display();
    }
}
