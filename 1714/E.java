import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] arr = new int[n];
            boolean same = true;
            int num = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
                if (j == 0)
                    num = arr[j];
                else if (num != arr[j])
                    same = false;
                HashSet<Integer> set = new HashSet<>();
                int start = arr[j];
                if (arr[j] % 2 != 0)
                    start += (arr[j] % 10);
                if (start % 10 == 0) {
                    if (map.containsKey(start))
                        map.put(start, map.get(start) + 1);
                    else
                        map.put(start, 1);
                    continue;
                }
                while (!set.contains(start % 10)) {
                    set.add(start % 10);
                    if (map.containsKey(start % 20))
                        map.put(start % 20, map.get(start % 20) + 1);
                    else
                        map.put(start % 20, 1);
                    start += (start % 10);
                }
            }
            if (same) {
                System.out.println("YES");
                continue;
            }
            boolean flag = false;
            for (int j : map.keySet())
                if (map.get(j) == n)
                    flag = true;
            System.out.println(flag ? "YES" : "NO");
        }
    }
}