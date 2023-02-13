package Do_it_Algorithm.DP;

import java.util.Arrays;
import java.util.Scanner;

public class DP_TopDown {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[N + 1];

        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        // Top Down 방식
        fibonacci(N);
        System.out.println(dp[N]);
    }

    private static int fibonacci(int N) {
        if (dp[N] != -1) {
            return dp[N];
        }
        return dp[N] = fibonacci(N - 1) + fibonacci(N - 2);
    }
}
