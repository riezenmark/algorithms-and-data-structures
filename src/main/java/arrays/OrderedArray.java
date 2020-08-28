package arrays;

public class OrderedArray {
    private final long[] a;
    private int numberOfElements;

    public OrderedArray(int maxNumberOfElements) {
        this.a = new long[maxNumberOfElements];
        this.numberOfElements = 0;
    }

    public int size() {
        return numberOfElements;
    }

    /**
     * Алгоритм двоичного поиска. Каждую итерацию берётся значение в середине диапазона и сравнивается с искомым элементом.
     * В зависимости от результата сравнения значения и искомого элемета либо уточняются границы диапазона (уменьшаются в два раза),
     * либо возвращается найденный элемент.
     * @param searchKey искомый элемент.
     * @return Индекс найденного элемента или -1, если элемент не найден.
     */
    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = numberOfElements - 1;
        int currentElement;

        while (true) {
            currentElement = (lowerBound + upperBound) / 2;
            if (a[currentElement] == searchKey) {
                return currentElement;
            } else if (lowerBound > upperBound) {
                return -1;
            } else {
                if (a[currentElement] < searchKey) {
                    lowerBound = currentElement + 1;
                } else {
                    upperBound = currentElement - 1;
                }
            }
        }
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < numberOfElements; j++) {
            if (a[j] > value) {
                break;
            }
        }
        for (int k = numberOfElements; k > j; k--) {
            a[k] = a[k - 1];
        }
        //if (numberOfElements - j >= 0) System.arraycopy(a, j, a, j + 1, numberOfElements - j);
        a[j] = value;
        numberOfElements++;
    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == -1) {
            return false;
        } else {
            for (int k = j; k < numberOfElements; k++) {
                a[k] = a[k + 1];
            }
            //if (numberOfElements - j >= 0) System.arraycopy(a, j + 1, a, j, numberOfElements - j);
            numberOfElements--;
            return true;
        }
    }

    public void display() {
        for (int j = 0; j < numberOfElements; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        OrderedArray array = new OrderedArray(7);
        System.out.printf("Размер массива: %s%n", array.size());
        System.out.println();

        array.insert(2);
        array.insert(6);
        array.insert(4);
        System.out.printf("Размер массива: %s%n", array.size());
        array.display();
        System.out.println();

        array.delete(4);
        System.out.printf("Размер массива: %s%n", array.size());
        array.display();
    }
}
