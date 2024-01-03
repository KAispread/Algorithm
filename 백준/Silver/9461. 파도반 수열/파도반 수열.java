import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    // 1, 1, 1, 2, 2, 3
    // P(7) = dp[7 - 1] + dp[7 - 5] = 4
    // P(8) = dp[8 - 1] + dp[8 - 5] = 5
    // P(9) = dp[8 - 1] + dp[8 - 5] = 5
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long[] dp = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 5;
        dp[9] = 7;
        dp[10] = 9;

        for (int i = 11; i < 101; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            System.out.println(dp[Integer.parseInt(bf.readLine())]);
        }
    }

}

