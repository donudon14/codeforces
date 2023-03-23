import java.util.*;

public class Circle
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0)
		{
			t--;
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			int max = Math.abs(b-a) * 2;
			if(a > max || b > max || c > max)
				System.out.println(-1);
			else
			{
				if(c - max/2 > 0)
				{	
					c = c - max/2;
				} else 
					c = c + max/2;
				if(c <= max)
					System.out.println(c);
				else 
					System.out.println(-1);		
			}

		}
	}
}