import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = in.nextInt();
            }
            int ans = 0;
            int[] arr1 = new int[200001];
            for (int i = n - 1; i >= 0; --i) {
                arr1[arr[i]]++;
                if (arr1[arr[i]] == 2) {
                    ans = i + 1;
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}