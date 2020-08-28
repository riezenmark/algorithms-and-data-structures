package sorts;

public class InsertionSortArray {
    private final long[] a;
    private int numberOfElements;

    public InsertionSortArray(int maximumOfElements) {
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
     * Сортировка вставкой. Во внешнем цикле for счетчик начинает с позиции 1 и двигается вправо. Он
     * отмечает крайний левый неотсортированный элемент. Во внутреннем цикле while
     * счетчик inner начинает с позиции outer и двигается влево — либо пока temp не станет
     * меньше элемента массива, либо когда дальнейшее смещение станет невозможным.
     * При каждом проходе по циклу while следующий отсортированный элемент сдви-
     * гается на одну позицию вправо. O(N^2), но выполняется быстрее пузырьковой сортировки
     * и сортировки выбором.
     */
    public void sort() {
        for (int outer = 1; outer < numberOfElements; outer++) {
            long temp = a[outer];
            int inner = outer;
            while (inner > 0 && a[inner - 1] >= temp) {
                a[inner] = a[inner - 1];
                --inner;
            }
            a[inner] = temp;
        }
    }

    public static void main(String[] args) {
        InsertionSortArray array = new InsertionSortArray(10);
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
