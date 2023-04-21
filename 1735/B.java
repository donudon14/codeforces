import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int min = 0;
            int steps = 0;
            for (int i = 0; i < n; i++) {
                int curr = in.nextInt();
                if (i == 0) {
                    min = curr;
                }
                if (curr >= (2 * min)) {
                    steps += (curr % (2 * min - 1) == 0) ? curr / (2 * min - 1) - 1 : curr / (2 * min - 1);
                }
            }
            System.out.println(steps);
        }
    }
}