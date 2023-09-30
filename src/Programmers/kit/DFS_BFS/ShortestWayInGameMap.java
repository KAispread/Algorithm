package Programmers.kit.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

// LEVEL 3 - 게임 맵 최단거리
public class ShortestWayInGameMap {

    /*
    매우 전형적인 BFS 길찾기 문제
    게임 캐릭터를 상,하,좌,우로 이동시킬 수 있는지 확인한 후 이동할 수 있다면 해당 좌표를 Queue에 삽입
    -- 캐릭터가 이동할 수 없는 경우
    1. 벽이 있는경우 '0'
    2. 이미 갔던 곳일 경우 visited
    3. 맵 밖을 벗어나는 경우, "x, y 좌표가 0보다 작거나, x 최대치, y 최대치 좌표인 경우"
    */
    static class Try {
        int maxX;
        int maxY;
        int[][] moving = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        boolean[][] visited;

        public int solution(int[][] maps) {
            maxX = maps.length;
            maxY = maps[0].length;
            visited = new boolean[maxX][maxY];

            // BFS 탐색용 Queue
            Queue<int[]> location = new LinkedList<>();
            location.offer(new int[] {0, 0});
            visited[0][0] = true;

            while(!location.isEmpty()) {
                int[] now = location.poll();
                int nowX = now[0];
                int nowY = now[1];

                // 상하좌우 Let's Go
                for (int[] m : moving) {
                    int forwardX = nowX + m[0];
                    int forwardY = nowY + m[1];

                    if (isAbleToGo(maps, forwardX, forwardY)) {
                        maps[forwardX][forwardY] += maps[nowX][nowY];
                        visited[forwardX][forwardY] = true;
                        location.offer(new int[] {forwardX, forwardY});
                    }
                }
            }

            // 결승지점까지 갈 수 없는 경우 -1
            int answer = maps[maxX - 1][maxY - 1];
            return answer == 1 ? -1 : answer;
        }

        private boolean isAbleToGo(int[][] maps, int x, int y) {
            if (x < 0 || y < 0 || x >= maxX || y >= maxY) return false;
            if (visited[x][y]) return false;
            if (maps[x][y] < 1) return false;
            return true;
        }
    }

    static class Answer {
        private int[][] moving = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        private boolean visited[][];
        private int N;
        private int M;

        public int solution(int[][] maps) {
            N = maps.length - 1;
            M = maps[0].length - 1;
            visited = new boolean[N + 1][M + 1];

            int answer = BFS(maps);
            return answer;
        }

        private int BFS(int[][] maps) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {0, 0});
            visited[0][0] = true;

            boolean finish = false;

            while (!queue.isEmpty()) {
                int[] p = queue.poll();
                int cx = p[0];
                int cy = p[1];

                for (int[] m : moving) {
                    int x = cx + m[0];
                    int y = cy + m[1];

                    if (validate(x, y, maps)) {
                        visited[x][y] = true;
                        maps[x][y] = maps[cx][cy] + 1;
                        queue.offer(new int[] {x, y});
                    }

                    if (x == N && y == M) finish = true;
                }
            }

            if (finish) return maps[N][M];
            return -1;
        }

        private boolean validate(int x, int y, int[][] maps) {
            if (x < 0 || y < 0 || x > N || y > M) return false;
            if (visited[x][y]) return false;
            if (maps[x][y] == 0) return false;
            return true;
        }
    }
}
