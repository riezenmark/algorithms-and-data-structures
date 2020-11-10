package ShellAndQuick;

public class SimpleQuickSort {
    private static class Array {
        private final long[] array;
        private int numberOfElements;

        public Array(int maximumOfElements) {
            this.array = new long[maximumOfElements];
            this.numberOfElements = 0;
        }

        public void insert(long value) {
            array[numberOfElements++] = value;
        }

        public void display() {
            for (int i = 0; i < numberOfElements; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }

        public void quickSort() {
            recursiveQuickSort(0, numberOfElements - 1);
        }

        private void recursiveQuickSort(int left, int right) {
            if (right - left <= 0) {
                return;
            } else {
                long pivot = array[right];

                int partition = partitionIt(left, right, pivot);
                recursiveQuickSort(left, partition - 1);
                recursiveQuickSort(partition + 1, right);
            }
        }

        private int partitionIt(int left, int right, long pivot) {
            int leftPtr = left - 1;
            int rightPtr = right;
            while (true) {
                while (array[++leftPtr] < pivot);
                while (rightPtr > 0 && array[--rightPtr] > pivot);
                if (leftPtr >= rightPtr) {
                    break;
                } else {
                    swap(leftPtr, rightPtr);
                }
            }
            swap(leftPtr, right);
            return leftPtr;
        }

        private void swap(int index1, int index2) {
            long temp;
            temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
    }

    public static void main(String[] args) {
        int arraySize = 16;
        Array array = new Array(arraySize);
        for (int i = 0; i < arraySize; i++) {
            long n = (int) (Math.random() * 99);
            array.insert(n);
        }

        array.display();
        array.quickSort();
        array.display();
    }
}
