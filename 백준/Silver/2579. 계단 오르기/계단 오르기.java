import java.util.Scanner;

/*
* 2579 계단 오르기 - Silver III
* */
public class Main {
    static Integer[] dp;
    static int[] num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp = new Integer[N + 1];
        num = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            num[i] = sc.nextInt();
        }

        dp[0] = 0;
        dp[1] = num[1];
        if (N >= 2) dp[2] = num[2] + num[1];

        System.out.println(find(N));
    }

    // N번째 계단의 최대값
    private static int find(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(find(n - 2), find(n - 3) + num[n - 1]) + num[n];
        }
        return dp[n];
    }
}
