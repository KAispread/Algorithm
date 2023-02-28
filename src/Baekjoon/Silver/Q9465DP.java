package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 9465번 스티커 - Silver I
* */
public class Q9465DP {
    private static Integer[][] dp;
    private static int[][] num;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            System.out.println(testCase(bf));
        }
    }

    private static int testCase(BufferedReader bf) throws IOException {
        int N = Integer.parseInt(bf.readLine());
        dp = new Integer[2][N + 1];
        num = new int[2][N + 1];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = num[0][1];
        dp[1][1] = num[1][1];

        return Math.max(find(N, 0), find(N, 1));
    }

    private static int find(int n, int row) {
        int Rrow = Math.abs(row - 1);
        if (dp[row][n] == null) {
            dp[row][n] = Math.max(find(n - 1, Rrow), find(n - 2, Rrow)) + num[row][n];
        }
        return dp[row][n];
    }
}
