package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReverser {
    private final String input;
    private String output;

    public StringReverser(String input) {
        this.input = input;
    }

    public String reverse() {
        Stack stack = new Stack(input.length());
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        output = "";
        while (!stack.isEmpty()) {
            output += stack.pop();
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            InputStreamReader streamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            System.out.print("Введите строку: ");
            System.out.flush();
            String input = bufferedReader.readLine();
            if (input.equals("")) {
                break;
            }
            StringReverser reverser = new StringReverser(input);
            String output = reverser.reverse();
            System.out.println("Reversed: " + output);
        }
    }
}
