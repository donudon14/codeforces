import java.util.*;

public class StringTransform
{
	static String deletedString(String t)
	{
		String deleted = "";
		for(int i = t.length() - 1; i >= 0; i--)
		{
			boolean alreadyIs = false;
			for(int j = 0; j < deleted.length(); j++)
			{
				if(t.charAt(i) == deleted.charAt(j))
				{
					alreadyIs = true;
					break;
				}	
			}
			if(!alreadyIs) {
				deleted = t.charAt(i) + deleted;
			}
		}
		return(deleted);	
	}
	static String checkString(String t, String deleted)	{
		String s = t;
		for(int i = 0; i < deleted.length(); i++)
		{
			for(int j = 0; j < s.length(); j++)
			{
				if(s.charAt(j) == deleted.charAt(i))
				{
					s = s.substring(0, j) + s.substring(j + 1, s.length());
					j--;
				}
			}
			t = t + s;
		}
		return t;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n > 0)
		{
			String t = in.next();
			String copy = t;
			String s = "";
			String deleted = deletedString(t);
			
			int[] amount = new int[deleted.length()];
			for(int i = 0; i < t.length(); i++)
			{
				for(int j = 0; j < deleted.length(); j++)
				{
					if(t.charAt(i) == deleted.charAt(j))
					{
						amount[j]++;
						break; //?
					}
				}
			}
			
			for(int i = 1; i < deleted.length(); i++)
			{	
				if(deleted.length() == 1)
					break;
				amount[i] = amount[i] / (i+1);
				for(int j = 0; j < t.length(); j++)	{
					if(t.charAt(j) == deleted.charAt(i)) {
						if(amount[i] > 0)
						{
							amount[i]--;
						}
						else 
						{
							t = t.substring(0, j) + t.substring(j + 1, t.length());
							j--;
						}
					}	
				}
			}			
			if(copy.equals(checkString(t, deleted)))
			{
				System.out.println(t + " " + deleted);
			}
			else
				System.out.println(-1);
			n--;
		}
	}
}