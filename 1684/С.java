import java.util.PriorityQueue;
import java.util.Scanner;

public class С {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int flag = 0, max = 0;
            int[][] array = new int[n][m];
            int a = 0, b = 0;
            int counter = 0;
            int node = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    array[i][j] = in.nextInt();
            for (int i = 0; i < n; i++) {
                PriorityQueue<Integer> queue = new PriorityQueue<>();
                for (int j = 0; j < m; j++)
                    queue.add(array[i][j]);
                for (int j = 0; j < m; j++) {
                    if (!queue.isEmpty())
                        node = queue.remove();
                    if (array[i][j] != node && flag == 0) {
                        a = j;
                        flag++;
                        counter++;
                    } else if (array[i][j] != node && flag == 1) {
                        b = j;
                        counter++;
                    }
                }
                if (flag == 1)
                    break;
            }
            boolean flagg = true;
            if (counter > 2)
                flagg = false;

            for (int i = 0; i < n && b != 0; i++) {
                int temp = array[i][a];
                array[i][a] = array[i][b];
                array[i][b] = temp;
            }
            for (int i = 0; i < n && b != 0 && flagg; i++) {
                PriorityQueue<Integer> queue2 = new PriorityQueue<>();
                if (!flagg)
                    break;
                for (int j = 0; j < m; j++)
                    queue2.add(array[i][j]);
                for (int j = 0; j < m; j++) {
                    if (!queue2.isEmpty())
                        node = queue2.remove();
                    if (array[i][j] != node) {
                        flagg = false;
                        break;
                    }
                }
            }
            if (max == n && flagg) {
                a = 0;
                b = 0;
            }
            if (flagg)
                System.out.println((a + 1) + " " + (b + 1));
            else
                System.out.println(-1);
        }
    }
}
 
 