import java.util.Scanner;

public class D {
    static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();
        long res = 0, mult = 1;
        for (int i = 1; i <= n; i++) {
            mult = mult % MOD * (m % MOD) % MOD;
            res = (res + mult) % MOD;
        }
        long sub = 0;
        long div = 1, curSub = 1;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                div *= i;
                if (div > m)
                    break;
            }
            curSub = m / div % MOD * curSub % MOD;
            sub = (sub + curSub) % MOD;
        }
        res = ((res - sub) % MOD + MOD) % MOD;
        System.out.println(res);
        System.out.close();
    }

    static boolean isPrime(int x) {
        if (x < 2)
            return false;
        for (long i = 2; i * i <= x; i++)
            if (x % i == 0)
                return false;
        return true;
    }
}