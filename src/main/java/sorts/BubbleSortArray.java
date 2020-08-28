package sorts;

public class BubbleSortArray {
    private final long[] a;
    private int numberOfElements;

    public BubbleSortArray(int maximumOfElements) {
        this.a = new long[maximumOfElements];
        this.numberOfElements = 0;
    }

    public void insert(long value) {
        a[numberOfElements] = value;
        numberOfElements++;
    }

    public void display() {
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * Пузырьковая сортировка. Два цикла проходят по массиву и сравнивают стоящие рядом элементы.
     * Если порядок нарушен, меняет эти элементы местами. O(N^2).
     */
    public void sort() {
        for (int i = 0; i < numberOfElements - 1; i++) {
            for (int j = i + 1; j < numberOfElements; j++) {
                if (a[j] > a[i]) {
                    long tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSortArray array = new BubbleSortArray(10);
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
