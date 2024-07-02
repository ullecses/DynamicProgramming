import java.util.Scanner;

public class Units2 {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(combinations(n, k) % MOD);
    }

    public static int combinations(int n, int k) {
        if (k > n - k) {
            k = n - k;
        }

        long numerator = 1;
        long denominator = 1;

        for (int i = 1; i <= k; i++) {
            numerator = (numerator * (n - i + 1)) % MOD;
            denominator = (denominator * i) % MOD;
        }

        long result = numerator * modInverse(denominator) % MOD;

        return (int) result;
    }

    public static long modInverse(long num) {
        return power(num, MOD - 2);
    }

    public static long power(long base, int exponent) {
        long result = 1;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exponent /= 2;
        }

        return result;
    }
}
