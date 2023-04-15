import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;

public class C {
    static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() {
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        if (count == 0 || count == 1) {
            System.out.println(count);
            return;
        }
        for (int k = count; k >= 0; k--) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < n; i++)
                if (arr[i] != 1)
                    queue.add(arr[i]);
            for (int i = 0; i < count - (k - 1); i++) {
                queue.add(1);
            }

            boolean flag = true;
            for (int j = k; j >= 1; j--) {
                while (!queue.isEmpty() && queue.peek() > j) {
                    queue.poll();
                }
                if (queue.isEmpty()) {
                    flag = false;
                    break;
                }
                queue.poll();
            }
            if (flag) {
                System.out.println(k);
                return;
            }
        }
    }
}