import java.util.*;
 
public class LongWords
{
    public static void main(String[] args) {    
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t > 0)
        {
            t--;
            String s = in.next();
            byte mex = 0;
            boolean iszero = false;
            for(int i = 0; i < s.length(); i++)
            {
                if(s.charAt(i) == '0' && iszero == false)
                {    
                    mex++;
                    iszero = true;
                }    
                else if(s.charAt(i) == '1')
                {
                    iszero = false;
                }
            }
            if(mex > 2)
                mex = 2;
            System.out.println(mex);
        }
    }
}