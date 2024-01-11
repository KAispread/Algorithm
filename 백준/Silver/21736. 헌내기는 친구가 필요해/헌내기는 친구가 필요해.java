import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static String NO_FRIENDS = "TT";
    static int[][] map;
    static Map<Character, Integer> elementsMap = Map.of('O', 0, 'I', 0, 'P', 1, 'X', -1);
    static int[][] moving = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

    // 그냥 BFS로 뚜까패
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int startY=0;
        int startX=0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String element = st.nextToken();

            for (int j = 0; j < M; j++) {
                char e = element.charAt(j);
                map[i][j] = elementsMap.get(e);

                if (e == 'I') {
                    startY = i;
                    startX = j;
                }
            }
        }

        int answer = findFriends(startX, startY);
        if (answer == 0) {
            System.out.println(NO_FRIENDS);
        } else {
            System.out.println(answer);
        }
    }

    private static int findFriends(int x, int y) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y, x});
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] move : moving) {
                int ty = move[0] + current[0];
                int tx = move[1] + current[1];

                if (validate(tx, ty, visited)) {
                    queue.offer(new int[] {ty, tx});
                    visited[ty][tx] = true;

                    if (map[ty][tx] == 1) count++;
                }
            }
        }

        return count;
    }

    private static boolean validate(int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= visited[0].length || y >= visited.length) return false;
        if (map[y][x] == -1) return false;
        if (visited[y][x]) return false;
        return true;
    }
}

