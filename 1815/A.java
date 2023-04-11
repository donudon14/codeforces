import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(in.readLine());
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            if (n % 2 == 1) {
                System.out.println("YES");
            } else {
                long[] result = new long[n - 1];
                for (int i = 0; i < n - 1; i++) {
                    result[i] = array[i + 1] - array[i];
                }
                for (int i = 0; i < n - 3; i += 2) {
                    result[i + 2] += result[i];
                }
                if (result[n - 2] >= 0)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
}