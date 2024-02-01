import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][][] dp = new int[n][n][3];  // 0=가로, 1=세로, 2=대각

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][0] = 1;  // 최초 상태
        for(int i = 0; i < n; i++) {
            for(int j = 2; j < n; j++) {
                if(j - 1 >= 0 && map[i][j] == 0) {  // 가로
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                }
                if(i - 1 >= 0 && map[i][j] == 0) {  // 세로
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                }
                if(i-1 >= 0 && j-1 >= 0 && map[i][j] == 0 && map[i-1][j] == 0 && map[i][j-1] == 0) {  // 대각
                    dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                }
            }
        }

        int ans = dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2];
        System.out.println(ans);
    }
}