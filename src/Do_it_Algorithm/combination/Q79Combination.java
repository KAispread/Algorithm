package Do_it_Algorithm.combination;

import java.util.Scanner;

/*
* 다리놓기 - 1010번
* */
public class Q79Combination {
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp = new int[31][31];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
            dp[i][1] = i;
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }

        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println(dp[B][A]);
        }
    }
}
