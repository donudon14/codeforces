import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.sort;
import static java.util.Collections.reverseOrder;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            List<Integer> positive = new ArrayList<>();
            List<Integer> negative = new ArrayList<>();
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                max = Math.max(max, x);
                min = Math.min(min, x);
                if (x < 0)
                    negative.add(x);
                else positive.add(x);
            }
            sort(positive, reverseOrder());
            sort(negative, reverseOrder());
            long lim = max - min;
            if (lim == 0) {
                System.out.println("No");
                continue;
            }
            int array[] = new int[n];
            long sum = 0;
            int i = 0, p = 0, q = 0;
            for (i = 0; i < n; i++) {
                if (p < positive.size() && sum + positive.get(p) < lim) {
                    array[i] = positive.get(p);
                    p++;
                    sum += array[i];
                } else if (q < negative.size() && sum + negative.get(q) < lim) {
                    array[i] = negative.get(q);
                    q++;
                    sum += array[i];
                } else
                    break;
            }
            if (i != n)
                System.out.println("No");
            else {
                System.out.println("Yes");
                for (int j = 0; j < n; j++) {
                    if (j != 0)
                        System.out.print(" ");
                    System.out.print(array[j]);
                }
                System.out.println();
            }
        }
    }
}

