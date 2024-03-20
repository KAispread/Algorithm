class Solution {
    // int[][] dp;  n 1이고 큰 정삼각형일 때 dp[1][0], n이 1이고 오른쪽 아래 정삼각형이 비어있는 형태일 때 dp[1][1]
    public int solution(int n, int[] tops) {
        // dp[n][0] = 오른쪽으로 튀어나온 3번 타일 적용
        // dp[n][1] = 오른쪽으로 튀어나온 3번 타일 적용하지 않은 경우
        int[][] dp = new int[n][2];
        
        final int DIV = 10007;
        
        dp[0][0] = 1;
        if (tops[0] == 1) {
            dp[0][1] = 3;
        } else{
            dp[0][1] = 2;
        }
    
        
        for (int i = 1; i < tops.length; i++) {
            if (tops[i] == 1) {
                dp[i][0] = (dp[i-1][1] + dp[i-1][0]) % DIV;
                dp[i][1] = (dp[i-1][1] * 3 + dp[i-1][0] * 2) % DIV;
            } else {
                dp[i][0] = (dp[i-1][1] + dp[i-1][0]) % DIV;
                dp[i][1] = (dp[i-1][1] * 2 + dp[i-1][0]) % DIV;
            }
        }
        
        
        return (dp[n-1][1] + dp[n-1][0]) % DIV;
    }
}