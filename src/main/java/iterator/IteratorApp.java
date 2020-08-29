package iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IteratorApp {
    public static void main(String[] args) throws IOException {
        LinkedList list = new LinkedList();
        ListIterator iterator = list.getIterator();
        long value;

        iterator.insertAfter(20);
        iterator.insertAfter(40);
        iterator.insertAfter(80);
        iterator.insertBefore(60);

        while (true) {
            System.out.print("Enter first letter of show, reset, ");
            System.out.print("next, get, before, after, delete: ");
            System.out.flush();
            int choice = getChar();
            switch (choice) {
                case 's':
                    if (!list.isEmpty()) {
                        list.display();
                    } else {
                        System.out.println("List is empty.");
                    }
                    break;
                case 'r':
                    iterator.reset();
                    break;
                case 'n':
                    if (!list.isEmpty() && !iterator.atEnd()) {
                        iterator.nextLink();
                    } else {
                        System.out.println("Can't go to the next link.");
                    }
                    break;
                case 'g':
                    if (!list.isEmpty()) {
                        value = iterator.getCurrent().data;
                        System.out.println("Returned: " + value);
                    } else {
                        System.out.println("List is empty.");
                    }
                    break;
                case 'b':
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iterator.insertBefore(value);
                    break;
                case 'a':
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iterator.insertAfter(value);
                    break;
                case 'd':
                    if (!list.isEmpty()) {
                        value = iterator.deleteCurrent();
                        System.out.println("Deleted: " + value);
                    } else {
                        System.out.println("Can't delete");
                        break;
                    }
                default:
                    System.out.println("Invalid key.");
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        return bufferedReader.readLine();
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
