import java.util.*;
 
public class HateThree
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0)
		{
			t--;
			int k = in.nextInt();
			int answer = 0;
			for(int i = 0; i < k; i++)
			{
				answer++;
				if(answer % 3 == 0 || answer % 10 == 3)
				{	
					while(answer % 3 == 0 || answer % 10 == 3)
						answer++;
				}			
			}	
			System.out.println(answer);
		}
	}
}