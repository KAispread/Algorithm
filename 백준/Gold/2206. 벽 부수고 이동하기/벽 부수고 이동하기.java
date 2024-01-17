import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Route {
        int crashCount;
        int x;
        int y;
        int dist;

        public Route(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.crashCount = 1;
        }

        public Route(int crashCount, int x, int y, int dist) {
            this.crashCount = crashCount;
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int[][] map;
    static int[][] moving = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

    // BFS로 맵을 순회
    // Crash Count 가 1이라면 벽을 부수고 이동, 0이라면 벽을 만났을 때
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        if (Y == 1 && X == 1) {
            System.out.println(1);
            return;
        }

        map = new int[Y][X];
        for (int i = 0; i < Y; i++) {
            String current = bf.readLine();

            for (int j = 0; j < X; j++) {
                int number = current.charAt(j) - '0';
                map[i][j] = number;
            }
        }

        System.out.println(BFS());
    }

    private static int BFS() {
        Queue<Route> queue = new LinkedList<>();
        queue.offer(new Route(0, 0, 1));
        boolean[][][] visited = new boolean[map.length][map[0].length][2];
        visited[0][0][0] = true;

        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Route route = queue.poll();
            int crashed = route.crashCount == 0 ? 1 : 0;

            for (int[] move : moving) {
                int tx = route.x + move[0];
                int ty = route.y + move[1];

                if (validate(tx, ty, visited, crashed)) {
                    if (ty == map.length - 1 && tx == map[0].length - 1) {
                        answer = Math.min(route.dist + 1, answer);
                        continue;
                    }

                    int crashCount = route.crashCount;
                    if (map[ty][tx] == 1) crashCount = 0;

                    visited[ty][tx][crashed] = true;
                    queue.offer(new Route(crashCount, tx, ty, route.dist + 1));
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private static boolean validate(int x, int y, boolean[][][] visited, int crashed) {
        if (x < 0 || y < 0 || y >= map.length || x >= map[0].length) return false;
        if (visited[y][x][crashed]) return false;
        if (map[y][x] == 1 && crashed == 1) return false;
        return true;
    }

}

