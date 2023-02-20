package Do_it_Algorithm.DP;

import java.util.Scanner;

/*
* 1328번 - 빌딩 순서 구하기
*
* 맨 마지막 빌딩을 어느 곳에 놓을지에 따라 점화식 도출 가능
* 1. 맨 왼쪽
* 2. 맨 오른쪽
* 3. 가운데 (왼, 오를 제외한 N - 2위치에 둘 수 있음)
* */
public class Q92DP {
    static long[][][] dp;
    static final long MOD = 1_000_000_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();

        // dp[i][j][k] = i개의 빌딩이 있을 때 왼쪽에서 보이는 빌딩이 j개, 오른쪽에서 보이는 빌딩이 k개인 경우의 수
        dp = new long[N+1][L+1][R+1];
        dp[1][1][1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= L; j++) {
                for (int k = 1; k <= R; k++) {
                    dp[i][j][k] =
                                    dp[i - 1][j][k - 1]+        //가장 작은 빌딩을 오른쪽에 놓는 경우
                                    dp[i - 1][j - 1][k] +       //가장 작은 빌딩을 왼쪽에 놓는 경우
                                    dp[i - 1][j][k] * (i - 2);  //가장 작은 빌딩을 가운데에 놓는 경우
                    dp[i][j][k] %= MOD;
                }
            }
        }

        System.out.println(dp[N][L][R]);
    }
}
