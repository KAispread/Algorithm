import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];

        // 누적합 저장
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 1; j <= N; j++) {
                int current = Integer.parseInt(st.nextToken());
                map[i][j] = current + map[i-1][j] + map[i][j-1] - map[i-1][j-1];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            System.out.println(map[y2][x2] - map[y2][x1 - 1] - map[y1 - 1][x2] + map[y1-1][x1-1]);
        }
    }

}

