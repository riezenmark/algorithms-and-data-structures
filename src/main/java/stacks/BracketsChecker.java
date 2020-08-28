package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketsChecker {
    private final String input;

    public BracketsChecker(String input) {
        this.input = input;
    }

    public void check() {
        Stack stack = new Stack(input.length());

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;

                case '}':
                case ']':
                case ')':
                    if (!stack.isEmpty()) {
                        char chx = stack.pop();
                        if ((ch == '}' && chx != '{')
                                || (ch == ']' && chx != '[')
                                || (ch == ')' && chx != '(')) {
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    } else {
                        System.out.println("Error: " + ch + " at " + i);
                    }
                default:
                    break;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Error: missing right delimiter.");
        }
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            InputStreamReader streamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            System.out.print("Enter string containing delimiters: ");
            System.out.flush();
            input = bufferedReader.readLine();
            if (input.equals("")) {
                break;
            }
            BracketsChecker checker = new BracketsChecker(input);
            checker.check();
        }
    }
}
