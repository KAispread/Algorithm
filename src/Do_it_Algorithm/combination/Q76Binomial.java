package Do_it_Algorithm.combination;

import java.util.Scanner;

/*
 * 이항계수 구하기 - 11050
 * */
public class Q76Binomial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] dp = new int[N + 1][N + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
            dp[i][i] = 1;
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        System.out.println(dp[N][M]);
    }
}
