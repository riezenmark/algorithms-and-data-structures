package partition;

public class Array {
    private final long[] array;
    private int numberOfElements;

    public Array(int maximumOfElements) {
        this.array = new long[maximumOfElements];
        this.numberOfElements = 0;
    }

    public void insert(long value) {
        array[numberOfElements++] = value;
    }

    public int size() {
        return numberOfElements;
    }

    public void display() {
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public int partition(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;

        while (true) {
            while (leftPtr < right && array[++leftPtr] < pivot) { }
            while (rightPtr > left && array[--rightPtr] > pivot) { }
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        return leftPtr;
    }

    private void swap(int index1, int index2) {
        long temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int maximumSize = 16;
        Array array = new Array(maximumSize);

        for (int i = 0; i < maximumSize; i++) {
            long n = (int) (java.lang.Math.random() * 199);
            array.insert(n);
        }
        array.display();

        long pivot = 99;
        System.out.print("Pivot is " + pivot + "; ");
        int size = array.size();

        int partitionIndex = array.partition(0, size - 1, pivot);

        System.out.println("Partition is at index " + partitionIndex + ".");
        array.display();
    }
}
