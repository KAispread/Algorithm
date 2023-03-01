package Baekjoon.Silver;

import java.util.Scanner;

/*
* 1965번 상자넣기 - Silver II
* */
public class Q1965DP {
    static int[] dp;
    static int[] num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[N];
        num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
            dp[i] = 1;
        }

        int answer = 0;
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (num[i] > num[j] && max < dp[j]) max = dp[j];
            }

            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
