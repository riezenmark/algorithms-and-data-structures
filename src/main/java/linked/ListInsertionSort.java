package linked;

/**
 * O(N^2), но работает быстрее сортировки вставкой за счёт меньшего числа копирований.
 */
public class ListInsertionSort {
    public static void main(String[] args) {
        int size = 10;
        SimpleLink[] linkArray = new SimpleLink[size];
        for (int j = 0; j < size; j++) {
            int n = (int) (java.lang.Math.random() * 99);
            SimpleLink newLink = new SimpleLink(n);
            linkArray[j] = newLink;
        }

        System.out.print("Unsorted array: ");
        for (int j = 0; j < size; j++) {
            System.out.print(linkArray[j].data + " ");
        }
        System.out.println();

        SortedList theSortedList = new SortedList(linkArray);
        for (int j = 0; j < size; j++) {
            linkArray[j] = theSortedList.remove();
        }

        System.out.print("Sorted Array: ");
        for (int j = 0; j < size; j++) {
            System.out.print(linkArray[j].data + " ");
        }
        System.out.println();
    }
}
