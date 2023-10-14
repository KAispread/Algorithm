import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* DP
* N까지의 정수를 K개 더해서 나올 수 있는 경우의 수
* --> 0도 더할 수 있음
* 만약에 K가 4 / N이 5 라면?
* 3개써서 5
* 3개써서 4
* 3개써서 3
* 3개써서 2
* 3개써서 1
* 3개써서 0
* 인 경우의 수를 모두 더함
* */

public class Main {

    private static final int DIV = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // [N][M] = N개의 숫자로 M을 만들 수 있는 경우의 수
        int[][] dp = new int[201][201];

        for (int i = 0; i <= K; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % DIV;
            }
        }

        System.out.println(dp[K][N]);
    }

}
