import java.util.Scanner;

public class A {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            while (t-- > 0) {
                int n=in.nextInt();
                int a[]=new int[n];
                int b[]=new int[n];
                for (int i = 0; i <= n - 1; i++) {
                    a[i] = in.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    b[i] = in.nextInt();
                }
                int aMax=0, bMax=0;
                for (int i = 0; i < n; i++) {
                    aMax=Math.max(aMax,a[i]);
                    bMax=Math.max(bMax,b[i]);
                }
                if(aMax==a[n-1] && bMax==b[n-1])
                    System.out.println("Yes");
                else{
                    for(int i=0;i<n-1;i++) {
                        if(a[i]>a[n-1] || b[i]>b[n-1]) {
                            int x = a[i];
                            a[i] = b[i];
                            b[i] = x;
                        }
                    }
                    aMax=0;
                    bMax=0;
                    for (int i = 0; i < n; i++) {
                        aMax=Math.max(aMax,a[i]);
                        bMax=Math.max(bMax,b[i]);
                    }
                    if(aMax==a[n-1] && bMax==b[n-1])
                        System.out.println("Yes");
                    else
                        System.out.println("No");
                }
            }
            System.out.close();
        }
}
