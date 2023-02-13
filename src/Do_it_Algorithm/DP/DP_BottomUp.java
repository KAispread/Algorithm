package Do_it_Algorithm.DP;

import java.util.Arrays;
import java.util.Scanner;

public class DP_BottomUp {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[N + 1];

        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        // Bottom Up 방식
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        System.out.println(dp[N]);
    }
}
