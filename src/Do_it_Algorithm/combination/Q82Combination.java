package Do_it_Algorithm.combination;

import java.util.Scanner;

/*
* 1256번 - 사전찾기
* */
public class Q82Combination {
    static int[][] dp;
    public static void main(String[] args) {
        dp = new int[101][101];
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    if (dp[i][j] > 100000000) dp[i][j] = 100000001;
                }
            }
        }

        if (dp[N + M][M] < K) {
            System.out.println("-1");
        } else {
            while (!(N == 0 && M == 0)) {
                if (dp[N + M - 1][M] >= K) {
                    System.out.print("a");
                    N--;
                } else {
                    System.out.print("z");
                    K = K - dp[N + M - 1][M];
                    M--;
                }
            }
        }
    }
}
