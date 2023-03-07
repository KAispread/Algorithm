package Programmers.level2;

/*
* 숫자 변환하기
* */
public class ConvertNumber {

    public static void main(String[] args) {
        solution(10, 25, 5);
    }
    static int[] dp;

    public static int solution(int x, int y, int n) {
        dp = new int[y + 1];

        if (x + n <= y) {
            dp[x + n] = 1;
        }
        if (x * 2 <= y) {
            dp[x * 2] = 1;
        }
        if (x * 3 <= y) {
            dp[x * 3] = 1;
        }


        for (int i = x; i <= y; i++) {
            if (dp[i] == 0) continue;

            if (i + n <= y) {
                if (dp[i + n] == 0) dp[i + n] = dp[i] + 1;
                else dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }
            if (i * 2 <= y) {
                if (dp[i * 2] == 0) dp[i * 2] = dp[i] + 1;
                else dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            if (i * 3 <= y) {
                if (dp[i * 3] == 0) dp[i * 3] = dp[i] + 1;
                else dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }

        if (x == y) return 0;
        if (dp[y] == 0) return -1;
        return dp[y];
    }
}
