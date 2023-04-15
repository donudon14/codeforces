import java.util.Scanner;

public class A {
    static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            in.nextInt();
            in.nextInt();
        }
        System.out.println(n > m ? "YES" : "NO");
    }
}