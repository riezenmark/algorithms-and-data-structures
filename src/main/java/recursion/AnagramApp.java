package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnagramApp {
    static int size;
    static int count;
    static char[] charArray = new char[100];

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a word: ");
        String input = getString();
        size = input.length();
        count = 0;
        for (int i = 0; i < size; i++) {
            charArray[i] = input.charAt(i);
        }
        doAnagram(size);
    }

    public static void doAnagram(int newSize) {
        if (newSize == 1) {
            return;
        }
        for (int i = 0; i < newSize; i++) {
            doAnagram(newSize - 1);
            if (newSize == 2) {
                displayWord();
            }
            rotate(newSize);
        }
    }

    public static void rotate(int newSize) {
        int i;
        int position = size - newSize;
        char temp = charArray[position];
        for (i = position + 1; i < size; i++) {
            charArray[i - 1] = charArray[i];
        }
        charArray[i - 1] = temp;
    }

    public static void displayWord() {
        if (count < 99) {
            System.out.print(" ");
        }
        if (count < 9) {
            System.out.print(" ");
        }
        System.out.print(++count + " ");
        for (int i = 0; i < size; i++) {
            System.out.print(charArray[i]);
        }
        System.out.print("\t");
        System.out.flush();
        if (count % 6 == 0) {
            System.out.println();
        }
    }

    public static String getString() throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        return bufferedReader.readLine();
    }
}
