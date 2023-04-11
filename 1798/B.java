import java.util.Scanner;
import java.util.HashMap;


public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                for (int j = 0; j < x; j++) {
                    int a = in.nextInt();
                    map.put(a,i+1);
                }
            }
            int array[] = new int[n+1];
            int nums = n;
            for (int value:map.keySet()) {
                if(array[map.get(value)]==0){
                    array[map.get(value)]=value;
                    nums--;
                }
            }
            if(nums != 0)
                System.out.println(-1);
            else {
                for (int i = 1; i < n - 1; i++) {
                    if (i != 1)
                        System.out.print(" ");
                    System.out.print(array[i]);
                }
                System.out.println();
            }
        }
        System.out.close();
    }
}
