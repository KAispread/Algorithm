package Do_it_Algorithm.DP;

import java.util.Scanner;

/*
* 1463번 - 정수를 1로 만들기
* Bottom Up 방식으로 작은 수를 1로 만들 수 있는 최소 수를 알면 큰 수를 1로 만들 수 있는 최소의 수도 구할 수 있다.
* */
public class Q84DP {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[N]);
    }
}
