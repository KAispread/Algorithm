package Do_it_Algorithm.combination;

import java.util.Scanner;

/*
* 이항계수 2 - 11051
* */
public class Q77Binomial {
    private static final int MOD = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =  sc.nextInt();
        int K =  sc.nextInt();

        long[][] dp = new long[N+1][N+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
            dp[i][1] = i;
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 2; j < i; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % MOD;
            }
        }

        System.out.println(dp[N][K]);
    }
}
