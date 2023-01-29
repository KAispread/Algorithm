package commuLearning.week3.step2;

import java.util.LinkedList;
import java.util.Queue;

/*
* 게임 맵 최단거리 풀이
* */
public class Answer1 {
    class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isValid(int width, int height) {
            if (x < 0 || x >= width) return false;
            if (y < 0 || y >= height) return false;
            return true;
        }
    }

    public int solution(int[][] maps) {
        int mapHeight = maps.length;
        int mapWidth = maps[0].length;

        Queue<Position> queue = new LinkedList<>();
        int[][] count = new int[mapHeight][mapWidth];
        boolean[][] visited = new boolean[mapHeight][mapWidth];

        queue.offer(new Position(0, 0));
        count[0][0] = 1;
        visited[0][0] = true;

        final int[][] moving = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            int currentCount = count[current.y][current.x];

            for (int i = 0; i < moving.length; i++) {
                Position moved = new Position(current.x + moving[i][0], current.y + moving[i][1]);
                if (!moved.isValid(mapWidth, mapHeight)) continue;
                if (visited[moved.y][moved.x]) continue;
                if (maps[moved.y][moved.x] == 0) continue;

                count[moved.y][moved.x] = currentCount + 1;
                visited[moved.y][moved.x] = true;
                queue.offer(moved);
            }
        }

        int answer = count[mapHeight - 1][mapWidth - 1];
        if (answer == 0) return -1;

        return answer;
    }
}
