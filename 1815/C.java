import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.StringJoiner;

public class C {
    public static ArrayList<ArrayList<Integer>> list1;
    public static ArrayList<ArrayList<Integer>> list2;
    public static int[] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for (int amt = 1; amt <= t; amt++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            list1 = new ArrayList<>(n + 1);
            list2 = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) {
                list1.add(new ArrayList<Integer>());
                list2.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list1.get(a).add(b);
                list2.get(b).add(a);
            }
            depth = new int[n + 1];
            depth[1] = 1;
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            while (!q.isEmpty()) {
                int v = q.poll();
                for (int nei : list2.get(v)) {
                    if (depth[nei] != 0)
                        continue;
                    depth[nei] = depth[v] + 1;
                    q.add(nei);
                }
            }
            boolean fail = false;
            for (int k = 1; k <= n; k++) {
                if (depth[k] == 0) {
                    fail = true;
                    break;
                }
            }
            if (fail) {
                System.out.println("INFINITE");
                continue;
            }
            ArrayList<ArrayList<Integer>> sections = new ArrayList<>(n + 1);
            for (int k = 0; k <= n; k++) sections.add(new ArrayList<Integer>());
            for (int k = 1; k <= n; k++) {
                sections.get(depth[k]).add(k);
            }
            int size = 0;
            StringJoiner joiner = new StringJoiner(" ");
            ArrayList<Integer> path = gen(n);
            for (int p : path) {
                if (p < sections.size()) {
                    for (int i : sections.get(p)) {
                        joiner.add("" + i);
                        size++;
                    }
                }
            }
            System.out.println("FINITE");
            System.out.println(size);
            System.out.println(joiner);
        }
    }
    public static ArrayList<Integer> gen(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int k = n; k >= 1; k--) {
            for (int j = k; j <= n; j++) {
                list.add(j);
            }
        }
        return list;
    }
}