import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class D {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- != 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            long[] a = new long[n];
            long ans = 0;
            ArrayList<Long> array = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
                ans += a[i];
                long temp = a[i] - (n - 1 - i);
                array.add(temp);
            }
            Collections.sort(array, Collections.reverseOrder());
            for (int i = 0; i < k; i++)
                ans -= array.get(i);
            long extra = (long) (k * (long) (k - 1)) / 2L;
            ans -= extra;
            System.out.println(ans);
        }
    }
}