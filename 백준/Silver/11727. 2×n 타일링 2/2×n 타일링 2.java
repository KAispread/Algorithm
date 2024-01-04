import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        if (N < 4) {
            if (N == 1) {
                System.out.println(1);
            } else if (N == 2) {
                System.out.println(3);
            } else {
                System.out.println(5);
            }
            return;
        }

        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        for (int i = 4; i <= N; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2]) * 2) % 10_007;
        }

        System.out.println(dp[N]);
    }

}

