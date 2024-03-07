import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final int INF = 16_000_000;
    static int[][] W, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) W[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][(1<<N)-1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i], -1);

        bw.write(dfs(0, 1)+"\n");
        bw.flush();
        br.close();
    }

    static int dfs(int now, int visit) {

        // 모든 도시를 지난 경우
        if(visit == (1<<N)-1) {
            // now -> 0(출발도시)로 가는 경로가 존재해야 돌아갈 수 있음
            if(W[now][0] == 0) return INF;
            return W[now][0];
        }

        if(dp[now][visit] != -1) return dp[now][visit];
        dp[now][visit] = INF;

        for(int i=0;i<N;i++) {
            // now -> 아직 방문하지 않는 i번 도시 가는 경로가 있는 경우
            if((visit & (1<<i)) == 0 && W[now][i] != 0) {
                // d[i][j] = 현재 있는 도시가 i이고 이미 방문한 도시들의 집합이 j일때,
                // 방문하지 않은 나머지 도시들을 모두 방문한 뒤 출발 도시로 돌아올 때 드는 최소 비용.
                // 즉, 방문해야하는 도시(여기에 시작지점으로 돌아오는 것 포함) 들까지 가는 최소 비용
                dp[now][visit] = Math.min(dfs(i, visit | (1 << i)) + W[now][i], dp[now][visit]);   // 최소비용 갱신
                // dfs(다음 도시, 다음도시 방문했다고 가정) + 여기서 다음 도시까지의 거리 와 최소거리 비교
            }
        }
        return dp[now][visit];
    }
}