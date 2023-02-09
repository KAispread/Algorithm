package Do_it_Algorithm.combination;

import java.util.Scanner;

/*
* 2775번 - 부녀회장이 될테야
* */
public class Q78Combination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(factorial(k, n));
        }
    }

    private static long factorial(int k, int n) {
        if (n == 1) return 1;

        int[][] dp = new int[k+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[k][n];
    }
}
