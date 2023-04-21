import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;


public class D {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n][k];
        Map<String, Integer> set = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < k; j++) {
                arr[i][j] = sc.nextInt();
                s.append(arr[i][j]);
            }
            set.put(s.toString(), i);
        }
        Set<pair> ch = new HashSet<>();
        int ans = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pair p = new pair(i, j);
                if (ch.contains(p))
                    continue;
                StringBuilder sb = new StringBuilder();
                for (int j2 = 0; j2 < k; j2++) {
                    if (arr[i][j2] == arr[j][j2]) {
                        sb.append(arr[i][j2]);
                    } else {
                        sb.append(3 - arr[i][j2] - arr[j][j2]);
                    }
                }
                String s = sb.toString();
                if (set.containsKey(s)) {
                    int ind = set.get(s);
                    ans += a[i] + a[j] + a[ind];
                    a[i]++;
                    a[j]++;
                    a[ind]++;
                    ch.add(new pair(i, ind));
                    ch.add(new pair(j, ind));
                }
            }
        }
        System.out.print(ans);
    }

    static class pair {
        int x, y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            pair p = (pair) o;
            if (x == p.x && y == p.y)
                return true;
            if (x == p.y && y == p.x)
                return true;
            return false;
        }
        @Override
        public int hashCode() {
            return x + y;
        }
        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}