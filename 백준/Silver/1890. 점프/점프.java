import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static long[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new long[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = -1;
			}
		}

		bw.write(DFS(1, 1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static long DFS(int x, int y) {
		if (dp[x][y] != -1) {
			return dp[x][y];
		}

		if (x == N && y == N) {
			return 1;
		}

		dp[x][y] = 0;

		int dx = x + map[x][y];
		int dy = y + map[x][y];

		// 아래와 오른쪽 이동이 모두 불가한 경우
		if (dx > N && dy > N) {
			return 0;
		}

		// 아래로 내려갈 수 있는 경우
		if (dx <= N) {
			dp[x][y] = Math.max(dp[x][y], dp[x][y] + DFS(x + map[x][y], y));
		}

		// 오른쪽으로 갈 수 있는 경우
		if (dy <= N) {
			dp[x][y] = Math.max(dp[x][y], dp[x][y] + DFS(x, y + map[x][y]));
		}

		return dp[x][y];
	}

}