
import  java.util.Scanner;
public class Route {
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while (t > 0) {
            int n=in.nextInt();
            String s=in.next();
            int x=0;
            int y=0;
            for(int i=0;i<n;i++) {
                if(s.charAt(i)=='L')
                    x--;
                else if(s.charAt(i)=='R')
                    x++;
                else if(s.charAt(i)=='U')
                    y++;
                else {y--;}
                if(x==1 && y==1) {
                    System.out.println("YES");
                    break;
                }
            }
            if(x != 1 || y != 1)
                System.out.println("NO");
            t--;
        }
    }
}