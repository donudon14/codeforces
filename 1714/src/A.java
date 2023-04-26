import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int sh = in.nextInt();
            int sm = in.nextInt();
            int sleep = (sh * 60) + sm;
            int arr[] = new int[n];
            int h = 0, m = 0, time = 0;
            int mintime = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                h = in.nextInt();
                m = in.nextInt();
                arr[i] = (60 * h) + m;
                if (arr[i] >= sleep) {
                    time = arr[i] - sleep;
                } else {
                    time = (1440 - sleep) + arr[i];
                }
                if (time < mintime) {
                    mintime = time;
                }
            }
            int hour = mintime / 60;
            int minit = mintime % 60;
            System.out.println(hour + " " + minit);
        }
    }
}
