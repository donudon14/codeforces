import java.util.*;

public class EndlessTable
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t > 0)
		{
			int k = in.nextInt();
			int step = 1;
			int i = 1;
			int j = 1;
			int first = 1;
			while (first + step <= k)
			{
				first += step;
				step += 2;
				j++;
			}
			for(int n = 0; n < (k - first); n++)
			{
				if (n < step/2)
					i++;
				else 
					j--;
			}
			System.out.println(i + " " + j);
			t--;
		}
	}
} 