import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int m = in.nextInt();
            long array1[] = new long[m];
            long k = 0, n = 0, a = 0;
            for (int i = 0; i < m; i++) {
                array1[i] = in.nextInt();
                k += array1[i];
            }
            long array2[] = new long[m];
            for (int i = 0; i < m; i++) {
                array2[i] = in.nextInt();
                a += array2[i];
                n = Math.max(n, array2[i]);
            }
            long res = k + a - n;
            System.out.println(res);
        }
    }
}