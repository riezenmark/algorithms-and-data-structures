package recursion;

public class Towers {
    static int numberOfDisks = 3;

    public static void main(String[] args) {
        doTowers(numberOfDisks, 'A', 'B', 'C');
    }

    public static void doTowers(int n, char from, char center, char to) {
        if (n == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(n - 1, from, to, center);
            System.out.println("Disk " + n + " from " + from + " to " + to);
            doTowers(n - 1, center, from, to);
        }
    }
}
