import java.util.*;

public class Max_mex
{

    public static void main(String[] args) {    
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t > 0)
        {
            t--;
            int n = in.nextInt();
            String s1 = in.next();
            String s2 = in.next();
            int mex = 0;
            for(int i = 0; i < n; i++)
            {
                if(s1.charAt(i) != s2.charAt(i))
                {    
                    mex += 2;
                }    
                else if(s1.charAt(i) == '0')
                {
                    if(i+1 < n)
                    {
                        if(s1.charAt(i+1) == '1' && s2.charAt(i+1) == '1')
                        {
                            mex += 1;
                            i++;
                        }
                    }
                    mex += 1;    
                } 
                else if(s1.charAt(i) == '1')
                {
                    if(i+1 < n)
                    {      
                        if(s1.charAt(i+1) == '0' || s1.charAt(i+1) == '0')
                        {
                            mex += 2;
                            i++;
                        }    
                    }
                }
            }
            System.out.println(mex);
        }
    }
}