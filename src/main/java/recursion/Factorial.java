package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        int number = getInt();
        int answer = factorial(number);
        System.out.println("Answer is " + answer);
    }

    public static int factorial(int n) {
        System.out.println("Entering: n=" + n);
        if (n == 0) {
            System.out.println("Returning 1");
            return 1;
        } else {
            int temp = n * factorial(n - 1);
            System.out.println("Returning " + temp);
            return temp;
        }
    }

    public static String getString() throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        return bufferedReader.readLine();
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
