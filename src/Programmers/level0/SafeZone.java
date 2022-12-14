package Programmers.level0;

/*
* 안전지대
* */
public class SafeZone {
    public static void main(String[] args) {

    }

    static int[][] danger;

    // 상 하 좌 우 좌상 우상 우하 좌하
    static int[] moveX = {0, 0, -1, 1, -1, 1, 1, -1};
    static int[] moveY = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int maxX;
    static int maxY;

    public int solution(int[][] board) {
        maxX = board[0].length;
        maxY = board.length;
        danger = new int[maxY][maxX];

        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                if (board[y][x] == 1) {
                    markDanger(x, y);
                }
            }
        }

        int count = 0;
        // 마킹되지 않은 지역 카운팅
        for (int[] row : danger) {
            for (int element : row) {
                if (element == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // 위험 지역 마킹
    private void markDanger(int x, int y) {
        danger[y][x] += 1;
        for (int coor = 0; coor < moveX.length; coor++) {
            int forwardX = x + moveX[coor];
            int forwardY = y + moveY[coor];

            if (forwardY < maxY && forwardY >= 0 && forwardX < maxX && forwardX >= 0) {
                danger[forwardY][forwardX] += 1;
            }
        }
    }
}
