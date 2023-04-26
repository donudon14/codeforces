import java.util.Scanner;

public class C {
    static int ans;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tt = 1;
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            ans = Integer.MAX_VALUE;
            solve(n, 0, new boolean[10], 0);
            System.out.println(ans);
        }
    }

    public static void solve(int n, int num, boolean[] vis, int s) {
        if (n == s) {
            ans = Math.min(ans, num);
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (!vis[i]) {
                vis[i] = true;
                solve(n, num * 10 + i, vis, s + i);
                vis[i] = false;
            }
        }
    }
}
