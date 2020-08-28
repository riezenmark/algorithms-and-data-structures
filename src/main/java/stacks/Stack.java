package stacks;

/**
 * Last In - First Out.
 */
public class Stack {
    private final int maxSize;
    private final char[] a;
    private int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        a = new char[maxSize];
        top = -1;
    }

    /**
     * O(1)
     */
    public void push(char value) {
        a[++top] = value;
    }

    /**
     * O(1)
     */
    public char pop() {
        return a[top--];
    }

    /**
     * O(1)
     */
    public char peek() {
        return a[top];
    }

    /**
     * O(1)
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * O(1)
     */
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push('s');
        stack.push('o');
        stack.push('m');
        stack.push('e');

        System.out.println(stack.isFull());
        System.out.println(stack.peek());
        System.out.println();

        while (!stack.isEmpty()) {
            char value = stack.pop();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println();
    }
}
