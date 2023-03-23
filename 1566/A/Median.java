import java.util.*;

public class Median
{
    public static void main(String[] args) {    
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0)
        {
            int n = in.nextInt();
            int s = in.nextInt();
            t--;
            n = n/2 + 1;
            if(n > s)
                System.out.println(0);
            else {
                int median = s/n;
                int sum = median * n;
                int i = 0;
                while(sum + n*i < s)
                {
                    i++;
                    if(sum + n*i - 1 < s)
                    median++;
                }
                System.out.println(median);
            }
        }
    }
}