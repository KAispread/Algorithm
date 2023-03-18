package Programmers.level2;

/*
* 리코챗 로봇
* */
public class RicochatRobot {
    private int[][] visited;
    private int[][] map;
    private final int[][] moving = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int endX;
    private int endY;
    private int min = Integer.MAX_VALUE;

    public int solution(String[] board) {
        endX = board.length;
        endY = board[0].length();

        map = new int[endX][endY];
        visited = new int[endX][endY];

        int[] goal = new int[2];
        int[] start = new int[2];

        for (int i = 0; i < endX; i++) {
            for (int j = 0 ; j < endY; j++) {
                if (board[i].charAt(j) == 'D') {
                    map[i][j] = 1;
                } else if (board[i].charAt(j) == 'G') {
                    map[i][j] = 2;
                    goal[0] = i;
                    goal[1] = j;
                } else if (board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        if (!isReachable(goal[0], goal[1])) return -1;

        getMin(start[0], start[1], 0);

        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    private void getMin(int x, int y, int depth) {
        if (map[x][y] == 2) {
            min = Math.min(depth, min);
            return;
        }

        for (int[] m : moving) {
            int cx = x + m[0];
            int cy = y + m[1];

            while (validate(cx, cy)) {
                cx += m[0];
                cy += m[1];
            }

            cx -= m[0];
            cy -= m[1];

            if (visited[cx][cy] == 0 || visited[cx][cy] > depth) {
                visited[cx][cy] = depth;
                getMin(cx, cy, depth + 1);
            }
        }
    }

    private boolean isReachable(int x, int y) {
        int block = 0;
        for (int[] m : moving) {
            int cx = x + m[0];
            int cy = y + m[1];
            if (!validate(cx, cy)) block++;
        }

        if (block == 0 || block == 4) return false;
        return true;
    }

    private boolean validate(int x, int y) {
        if (x < 0 || y < 0 || x >= endX || y >= endY) return false;
        if (map[x][y] == 1) return false;
        return true;
    }
}
