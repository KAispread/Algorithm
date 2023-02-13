package Do_it_Algorithm.combination;

import java.util.Scanner;

/*
* 1947번 - 선물 전달하기
* D[N] = (N - 1) * (D[N - 2] + D[N - 1]) 점화식 도출 핵심
* */
public class Q83Combination {
    static final long MOD = 1_000_000_000;
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp = new long[1000001];
        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % MOD;
        }

        System.out.println(dp[N]);
    }
}
