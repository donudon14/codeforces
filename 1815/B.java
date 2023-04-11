import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class B {
    public static BufferedReader in;
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for (int q = 1; q <= t; q++) {
            int n = Integer.parseInt(in.readLine());
            if (n == 2) {
                System.out.println("! 1 2 2 1");
                System.out.flush();
                in.readLine();
                continue;
            }
            System.out.println("+ " + (n + 1));
            System.out.flush();
            in.readLine();
            System.out.println("+ " + (n + 2));
            System.out.flush();
            in.readLine();
            int[] array = new int[n];
            array[0] = 1;
            int add = n - 1, sign = 1;
            for (int k = 1; k < n; k++) {
                array[k] = array[k - 1] + (add * sign);
                add--;
                sign *= -1;
            }
            int maxValue = 1;
            int maxD = 0;
            for (int k = 2; k <= n; k++) {
                int i = query(1, k);
                if (i > maxD) {
                    maxValue = k;
                    maxD = i;
                }
            }
            int[] path1 = new int[n + 1];
            int[] path2 = new int[n + 1];
            path1[maxValue] = array[0];
            path2[maxValue] = array[n - 1];
            for (int k = 1; k <= n; k++) {
                if (k == maxValue)
                    continue;
                int i = query(maxValue, k);
                path1[k] = array[i];
                path2[k] = array[n - i - 1];
            }
            StringJoiner joiner = new StringJoiner(" ");
            joiner.add("!");
            for (int k = 1; k <= n; k++)
                joiner.add("" + path1[k]);
            for (int k = 1; k <= n; k++)
                joiner.add("" + path2[k]);
            System.out.println(joiner);
            System.out.flush();
            in.readLine();
        }
    }

    public static int query(int a, int b) throws IOException {
        System.out.println("? " + a + " " + b);
        System.out.flush();
        return Integer.parseInt(in.readLine());
    }
}