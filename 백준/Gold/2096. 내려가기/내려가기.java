import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // dp
    // N 번째 줄에서 최대 또는 최소 값은 바로 윗 줄에서 현재 위치로 올 수 있는 경우의 수 중, 최대 또는 최소 값을 더한 값이다.
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][3];
        int[][] minimum = new int[N][3];
        int[][] maximum = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            minimum[0][i] = map[0][i];
            maximum[0][i] = map[0][i];
        }

        for (int i = 1; i < minimum.length; i++) {
            minimum[i][0] = Math.min(minimum[i-1][0], minimum[i-1][1]) + map[i][0];
            minimum[i][1] = Math.min(Math.min(minimum[i-1][0], minimum[i-1][1]), minimum[i-1][2]) + map[i][1];
            minimum[i][2] = Math.min(minimum[i-1][1], minimum[i-1][2]) + map[i][2];

            maximum[i][0] = Math.max(maximum[i-1][0], maximum[i-1][1]) + map[i][0];
            maximum[i][1] = Math.max(Math.max(maximum[i-1][0], maximum[i-1][1]), maximum[i-1][2]) + map[i][1];
            maximum[i][2] = Math.max(maximum[i-1][1], maximum[i-1][2]) + map[i][2];
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(minimum[N-1][i], min);
            max = Math.max(maximum[N-1][i], max);
        }

        System.out.println(max + " " + min);
    }

}

