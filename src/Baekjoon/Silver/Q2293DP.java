package Baekjoon.Silver;

import java.util.Scanner;

/*
 * 2293 - 동전1 - Gold V
 * */
public class Q2293DP {
    private static int[] coin;
    private static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        dp = new long[K + 1];
        coin = new int[N];

        for (int i = 0; i < N; i++) {
            coin[i] = sc.nextInt();
        }

        dp[0] = 1;

        for (int c = 0; c < N; c++) {
            for (int i = 1; i <= K; i++) {
                if (i >= coin[c]) dp[i] += dp[i - coin[c]];
            }
        }
        System.out.println(dp[K]);
    }
}
