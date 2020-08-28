package queues;

public class PriorityQueue {
    private final int maximumSize;
    private final long[] a;
    private int numberOfElements;

    public PriorityQueue(int maximumSize) {
        this.maximumSize = maximumSize;
        this.a = new long[maximumSize];
        this.numberOfElements = 0;
    }

    /**
     * O(N)
     */
    public void insert(long item) {
        int i;
        if (numberOfElements == 0) {
            a[numberOfElements++] = item;
        } else {
            for (i = numberOfElements - 1; i >= 0; i--) {
                if (item > a[i]) {
                    a[i + 1] = a[i];
                } else {
                    break;
                }
            }
            a[i + 1] = item;
            numberOfElements++;
        }
    }

    /**
     * O(1)
     */
    public long remove() {
        return a[--numberOfElements];
    }

    /**
     * O(1)
     */
    public long peek() {
        return a[numberOfElements - 1];
    }

    /**
     * O(1)
     */
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    /**
     * O(1)
     */
    public boolean isFull() {
        return numberOfElements == maximumSize;
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.insert(30);
        priorityQueue.insert(50);
        priorityQueue.insert(10);
        priorityQueue.insert(40);
        priorityQueue.insert(20);
        while (!priorityQueue.isEmpty()) {
            long item = priorityQueue.remove();
            System.out.print(item + " ");
        }
    }
}
