import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean[] alpha;
    static boolean[][] visited;
    static int max = 0;
    static int[][] moving = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

    // 브루트 포스
    // boolean[] alpha 에 어떤 알파벳이 있었는지 적재해놓고 상하좌우 탐색하면서 이동할 칸의 알파벳이 이미 방문했는지 따짐
    // DFS
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        map = new char[Y][X];
        alpha = new boolean['Z' - 'A' + 1];
        visited = new boolean[Y][X];

        for (int i = 0; i < Y; i++) {
            String row = bf.readLine();

            for (int j = 0; j < X; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        alpha[map[0][0] - 'A'] = true;
        visited[0][0] = true;

        // 브루트포스
        DFS(0, 0, 1);

        System.out.println(max);
    }

    private static void DFS(int y, int x, int dist) {
        boolean forward = false;

        for (int[] move : moving) {
            int tx = x + move[0];
            int ty = y + move[1];

            if (validate(ty, tx)) {
                forward = true;

                alpha[map[ty][tx] - 'A'] = true;
                visited[ty][tx] = true;
                DFS(ty, tx, dist + 1);
                visited[ty][tx] = false;
                alpha[map[ty][tx] - 'A'] = false;
            }
        }

        if (!forward) max = Math.max(max, dist);
    }

    private static boolean validate(int y, int x) {
        if (y < 0 || x < 0 || y >= map.length || x >= map[0].length) return false;
        if (visited[y][x]) return false;
        if (alpha[map[y][x] - 'A']) return false;
        return true;
    }

}

