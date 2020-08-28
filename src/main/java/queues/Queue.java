package queues;

/**
 * First In - First Out.
 */
public class Queue {
    private final int maximumSize;
    private final long[] a;
    private int front;
    private int rear;
    private int numberOfElements;

    public Queue(int maximumSize) {
        this.maximumSize = maximumSize;
        this.a = new long[maximumSize];
        this.front = 0;
        this.rear = -1;
        this.numberOfElements = 0;
    }

    /**
     * O(1)
     */
    public void insert(long value) {
        if (rear == maximumSize - 1) {
            rear = -1;
        }
        a[++rear] = value;
        numberOfElements++;
    }

    /**
     * O(1)
     */
    public long remove() {
        long temp = a[front++];
        if (front == maximumSize) {
            front = 0;
        }
        numberOfElements--;
        return temp;
    }

    /**
     * O(1)
     */
    public long peek() {
        return a[front];
    }

    /**
     * O(1)
     */
    public boolean isEmpty() {
        return (numberOfElements == 0);
    }

    /**
     * O(1)
     */
    public boolean isFull() {
        return (numberOfElements == maximumSize);
    }

    /**
     * O(1)
     */
    public int size() {
        return numberOfElements;
    }

    public static void main(String[] args) {
        Queue theQueue = new Queue(5);
        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);
        while (!theQueue.isEmpty()) {
            long n = theQueue.remove();
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println();
    }
}
