import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 1 이 되는 경우 - (1)
    // 2 가 되는 경우 - (1 + 1), (2)
    // 3 이 되는 경우 - (1 + 1 + 1), (1 + 2), (2 + 1), (3)
    // 4 가 되는 경우 - (3의 경우의 수 + 1) = 4 + (2의 경우의 수 + 2) = 2 + (1의 경우의 수 + 3) = 1 개 => 7개
    // 결국 dp[N] = dp[N -1] + dp[N - 2] + dp[N - 3]
    // dp[N - 3] 에는 + 3만 해주면 됨
    // dp[N - 2] 에는 + 2만 해주면 됨
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int t = 0; t < T; t++) {
            int number = Integer.parseInt(bf.readLine());
            System.out.println(dp[number]);
        }
    }

}

