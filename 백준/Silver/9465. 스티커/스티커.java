import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            int X = Integer.parseInt(bf.readLine());
            map = new int[2][X + 1];
            dp = new int[2][X + 1];

            System.out.println(solution(X, bf));
        }

    }

    private static int solution(int X, BufferedReader bf) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 1; j <= X; j++) {
                int number = Integer.parseInt(st.nextToken());
                map[i][j] = number;
            }
        }

        dp[0][1] = map[0][1];
        dp[1][1] = map[1][1];

        int max = Math.max(dp[0][1], dp[1][1]);
        for (int i = 2; i <= X; i++) {
            dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + map[0][i];
            dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + map[1][i];

            max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
        }

        return max;
    }
}

