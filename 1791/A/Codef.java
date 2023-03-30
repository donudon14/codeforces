
import java.util.Scanner;

public class Codef {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int i=1; i<=t; i++) {
            char c = in.next().charAt(0);
            if(c=='c'|| c=='o'|| c=='d'||c=='e'||c=='f'||c=='r'||c=='s')
                System.out.println("YES");
            else
                System.out.println("NO");
            }
        }
}