package recursion;

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

    public int find(long searchKey) {
        return recursiveBinarySearch(searchKey, 0, numberOfElements - 1);
    }

    /**
     * Алгоритм двоичного поиска с использованием рекурсии. O(log N), но работает немного медленнее
     * варианта с циклами.
     */
    private int recursiveBinarySearch(long searchKey, int lowerBound, int upperBound) {
        int currentIndex;
        currentIndex = (lowerBound + upperBound) / 2;
        if (a[currentIndex] == searchKey) {
            return currentIndex;
        } else if (lowerBound > upperBound) {
            return -1;
        } else {
            if (a[currentIndex] < searchKey) {
                return recursiveBinarySearch(searchKey, currentIndex + 1, upperBound);
            } else {
                return recursiveBinarySearch(searchKey, lowerBound, currentIndex - 1);
            }
        }
    }

    /**
     * O(N)
     */
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

    /**
     * O(N)
     */
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

    /**
     * O(N)
     */
    public void display() {
        for (int j = 0; j < numberOfElements; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }
}

