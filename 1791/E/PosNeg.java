import java.util.Scanner;
import java.util.Arrays;

import static java.lang.Math.abs;

public class PosNeg {
    public static long sumAbs(int[] arr)  {
        long sum=0;
        for(int i=0;i<arr.length;i++) {
            sum += abs(arr[i]);
        }
        return sum;
    }
    public static void sumNegs(int[] arr) {
        if(arr.length%2==0)
            System.out.println(sumAbs(arr));
        else
            System.out.println(sumAbs(arr)+2*arr[arr.length-1]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int counter = 1; counter <= t; counter++){
            int n=sc.nextInt();
            int [] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }

            Arrays.sort(arr);
            int firstPos =0;
            int countNeg=0;

            for(int i=0;i<n;i++) {   
                if(arr[i]<0) countNeg++;
                if(arr[i]>=0){
                    firstPos=i;
                    break;
                }
                if(countNeg==n){
                    sumNegs(arr); 
                }
            }
            if(firstPos==0 && countNeg==0){
                System.out.println(sumAbs(arr));
            }
            if(countNeg>0 && countNeg!=arr.length) {
                if(countNeg%2==1){
                    if(arr[firstPos]> abs(arr[firstPos-1])){
                        System.out.println(sumAbs(arr)+2*arr[firstPos-1]);
                    }
                    else
                        System.out.println(sumAbs(arr)-2*arr[firstPos]);
                }
                else System.out.println(sumAbs(arr));
            }
        }

    }
}
