package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
* 파일 합치기 - Gold III
* */
public class Q11066 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;

    public static void main(String[] args) throws Exception {
        int t;

        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int k;
            int[] novel;
            int[] sum;
            int[][] dp;

            k = Integer.parseInt(br.readLine());
            novel = new int[k + 1];
            dp = new int[k + 1][k + 1];
            sum = new int[k + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= k; i++) {
                novel[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + novel[i];
            }

            for (int n = 1; n <= k; n++) {
                for (int from = 1; from + n <= k; from++) {
                    int to = from + n;
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int divide = from; divide < to; divide++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from - 1]);
                    }
                }
            }

            System.out.println(dp[1][k]);
        }

    }
}

