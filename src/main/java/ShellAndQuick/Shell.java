package ShellAndQuick;

public class Shell {
    private final long[] array;
    private int numberOfElements;

    public Shell(int maximumOfElements) {
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

    public void shellSort() {
        int inner, outer;
        long temp;
        int h = 1;

        //Вычисление исходного значения h. 1, 4, 13, 40, 121...
        while (h <= numberOfElements / 3) {
            h = h * 3 + 1;
        }

        //Последовательное уменьшение h до 1.
        while (h > 0) {
            //h-сортировка
            for (outer = h; outer < numberOfElements; outer++) {
                temp = array[outer];
                inner = outer;

                //Первый подмассив (0, 4, 8)
                while (inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }

    public static void main(String[] args) {
        int maxSize = 10;
        Shell arr = new Shell(maxSize);

        for (int j = 0; j < maxSize; j++) {
            long n = (int) (java.lang.Math.random() * 99);
            arr.insert(n);
        }
        arr.display();
        arr.shellSort();
        arr.display();
    }
}
