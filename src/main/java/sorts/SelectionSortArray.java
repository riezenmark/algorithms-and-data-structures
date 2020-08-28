package sorts;

public class SelectionSortArray {
    private final long[] a;
    private int numberOfElements;

    public SelectionSortArray(int maximumOfElements) {
        this.a = new long[maximumOfElements];
        this.numberOfElements = 0;
    }

    /**
     * O(1)
     */
    public void insert(long value) {
        a[numberOfElements] = value;
        numberOfElements++;
    }

    /**
     * O(N)
     */
    public void display() {
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * Сортировка выбором. При последовательном переборе выбирается самое малое значение
     * и меняется местами со значением на том месте, откуда начался перебор. O(N^2), но
     * работает быстрее пузырьковой сортировки за счёт меньшего количества перестановок.
     */
    public void sort() {
        for (int i = 0; i < numberOfElements - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numberOfElements; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            long temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSortArray array = new SelectionSortArray(10);
        array.insert(7);
        array.insert(2);
        array.insert(9);
        array.insert(4);
        array.insert(5);
        array.display();
        System.out.println();

        array.sort();
        array.display();
    }
}
