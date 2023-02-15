package Do_it_Algorithm.DP;

import java.util.Scanner;

/*
* 1463 번
* */
public class Q84DP_re {
    /*
    * 정수를
    * */
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp = new long[N + 1];

        // 숫자 N까지 1을 만들 수 있는 최소 경우를 판단
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[N]);
    }
}
