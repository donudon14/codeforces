import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class D {
    static class Pair {
        int start;
        int num;

        public Pair(int start, int num) {
            this.start = start;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            String str = in.next();
            int n = in.nextInt();
            HashMap<String, Integer> set = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String curr = in.next();
                set.put(curr, i + 1);
            }
            int arr[][] = new int[str.length()][2];
            for (int i = 0; i < str.length(); i++) {
                int max = 0;
                int strNum = -1;
                for (int j = i; j < str.length(); j++) {
                    String curr = str.substring(i, j + 1);
                    int len = curr.length();
                    if (set.containsKey(curr)) {
                        if (len > max) {
                            max = len;
                            strNum = set.get(curr);
                        }
                    }
                }
                arr[i][0] = max;
                arr[i][1] = strNum;
            }
            ArrayList<Pair> list = new ArrayList<>();
            boolean ans = true;
            int jump = 1;
            int maxReach = arr[0][0];
            int end = arr[0][0];
            list.add(new Pair(arr[0][1], 1));
            int wj = arr[0][1];
            int pj = 1;
            for (int i = 1; i < arr.length; i++) {
                if (i > end) {
                    ans = false;
                    break;
                }
                if (i + arr[i][0] > maxReach) {
                    maxReach = i + arr[i][0];
                    wj = arr[i][1];
                    pj = i + 1;
                }
                if (i == end) {
                    end = maxReach;
                    jump++;
                    list.add(new Pair(wj, pj));
                }
            }
            if (end < arr.length) {
                ans = false;
            }
            if (ans) {
                System.out.println(jump);
                for (Pair curr : list) {
                    System.out.println(curr.start + " " + curr.num);
                }
            } else {
                System.out.println(-1);
            }
        }
    }
}
