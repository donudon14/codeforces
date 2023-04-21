import java.util.Scanner;
import java.util.Arrays;


public class C {
    public static boolean isloop(int src, int des, int[] out) {
        int counter = 0;
        while (src != des && src != -1) {
            src = out[src];
            counter++;
        }
        if (src == des)
            counter++;
        return counter == 26 || src == -1;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String str = in.next();
            int[] inc = new int[26];
            int[] out = new int[26];
            Arrays.fill(inc, -1);
            Arrays.fill(out, -1);
            String string = new String();
            for (int i = 0; i < n; i++) {
                int chr = str.charAt(i) - 'a';
                if (inc[chr] != -1)
                    string += (char) (inc[chr] + 'a');
                else {
                    for (int j = 0; j < 26; j++) {
                        if (chr == j)
                            continue;
                        if (out[j] == -1 && isloop(chr, j, out) == true) {
                            out[j] = chr;
                            inc[chr] = j;
                            string += (char) (j + 'a');
                            break;
                        }
                    }
                }
            }
            System.out.println(string);
        }
    }
}