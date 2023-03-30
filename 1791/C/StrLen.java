import java.util.*;


public class StrLen {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int counter = 0;
            if (n == 1) 
                System.out.println("1");
            else {
                for (int j = 0; j < n / 2; j++) {
                    if (s.charAt(j) != s.charAt(n - 1 - j)) {
                        counter++;
                    } else 
                        break;
                }
                System.out.println(n - counter * 2);
            }
            t--;
        }
    }
}