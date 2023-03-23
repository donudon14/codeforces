import java.util.*;


public class Cinema
{
    public static void main(String[] args) {    
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t > 0)
        {
            int n = in.nextInt();
            int m = in.nextInt();
            int answer = 0;
            int[] order = new int[m];
            for(int i = 0; i < m; i++)
                order[i] = in.nextInt();
            int[] mass = new int[m];
            for(int i = 0; i < m; i++)
            {
                for(int j = 0; j < m; j++)
                {
                    if(order[i] > mass[j] && mass[j] != 0)
                        answer++;
                    else if(mass[j] == 0)
                    {
                        mass[j] = order[i];
                        break;
                    }    
                }
            }
            t--;
            System.out.println(answer);
        }
    }
}