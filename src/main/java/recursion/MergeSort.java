package recursion;

/**
 * Сортировка слиянием требует выделения области памяти,
 * равной по размеру области, занимаемой сортируемым массивом. O(N + log(N)).
 * Бысрее сортировки пузырьком, вставкой и выбором. Массив делится пополам,
 * пока не достигнет массива из одного элемента, после чего происходит слияние в отсортированный массив.
 */
public class MergeSort {
    private static class Array {
        private final long[] array;
        private int numberOfElements;

        public Array(int max) {
            this.array = new long[max];
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

        public void mergeSort() {
            long[] sortedArray = new long[numberOfElements];
            recursiveMergeSort(sortedArray, 0, numberOfElements - 1);
        }

        private void recursiveMergeSort(long[] workspace, int lowerBound, int upperBound) {
            if (lowerBound == upperBound) {
                return;
            } else {
                int middle = (lowerBound + upperBound) / 2;
                recursiveMergeSort(workspace, lowerBound, middle);
                recursiveMergeSort(workspace, middle + 1, upperBound);
                merge(workspace, lowerBound, middle + 1, upperBound);
            }
        }
        private void merge(long[] workspace, int indexOfFirstPart, int indexOfSecondPart, int upperBound) {
            int i = 0;
            int lowerBound = indexOfFirstPart;
            int middle = indexOfSecondPart - 1;
            int numberOfElements = upperBound - lowerBound + 1;

            while (indexOfFirstPart <= middle && indexOfSecondPart <= upperBound) {
                if (array[indexOfFirstPart] < array[indexOfSecondPart]) {
                    workspace[i++] = array[indexOfFirstPart++];
                } else {
                    workspace[i++] = array[indexOfSecondPart++];
                }
            }
            while (indexOfFirstPart <= middle) {
                workspace[i++] = array[indexOfFirstPart++];
            }
            while (indexOfSecondPart <= upperBound) {
                workspace[i++] = array[indexOfSecondPart++];
            }
            for (int j = 0; j < numberOfElements; j++) {
                array[lowerBound + j] = workspace[j];
            }
        }
    }

    public static void main(String[] args) {
        int maximumSize = 100;
        Array array;
        array = new Array(maximumSize);

        array.insert(64);
        array.insert(21);
        array.insert(33);
        array.insert(70);
        array.insert(12);
        array.insert(85);
        array.insert(44);
        array.insert(3);
        array.insert(99);
        array.insert(0);
        array.insert(108);
        array.insert(36);

        array.display();

        array.mergeSort();

        array.display();
    }
}
