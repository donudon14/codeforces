import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int k, temp, counter = 0;
            int flag = 999999;
            k = in.nextInt();
            temp = k;
            while (temp > 0) {
                int f = temp % 10;
                if (flag > f) {
                    flag = f;
                }
                temp = temp / 10;
                counter++;
            }
            if (counter > 2) {
                System.out.println(flag);
            } else {
                System.out.println(k % 10);
            }
            System.out.println();
        }
    }
}
