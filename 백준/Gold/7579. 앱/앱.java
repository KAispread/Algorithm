import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 비용이 0인 앱들을 모두 찾아 M에서 빼줌
    // 메모리가 큰 순으로 정렬하고 0번째 인덱스 앱부터 포함시키며 최솟값을 찾음
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        int[] memory = new int[N];
        int[] cost = new int[N];

        for (int i = 0; i < N; i++) {
            int mem = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            memory[i] = mem;
            cost[i] = c;
        }

        int[][] dp = new int[N][10001];
        int answer = 987654321;

        for (int i = 0; i < N; i++) {
            int c = cost[i];
            int mem = memory[i];

            for (int j = 0; j < 10001; j++) {
                if (i == 0) {
                    if (j >= c) dp[i][j] = mem;
                } else {
                    dp[i][j] = dp[i-1][j];

                    if (j >= c) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-c] + mem);
                }

                if (dp[i][j] >= M) answer = Math.min(answer, j);
            }
        }

        System.out.println(answer);
    }
}
