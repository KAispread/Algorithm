package Do_it_Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 1915번 - 가장 큰 정사각형 찾기
* */
public class Q91DP {
    static int max = 1;
    static int[][] tile;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = bf.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        tile = new int[N + 1][M + 1];

        // tile 2차원 배열에 저장
        for (int i = 1; i <= N; i++) {
            String[] s = bf.readLine().split("");
            for (int j = 1; j <= s.length; j++) {
                tile[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (tile[i][j] == 1 && i > 1 && j > 1 ) tile[i][j] = Math.min(tile[i-1][j-1], Math.min(tile[i-1][j], tile[i][j-1])) + tile[i][j];
                if (max < tile[i][j]) max = tile[i][j];
            }
        }

        System.out.println(max * max);
    }

    private static int getSize(int row, int column) {
        int height = 1;
        int width = getWidth(row, column);

        for (int r = row + 1; r < tile.length; r++) {
            if (tile[r][column] == 1) {
                height++;
                width = Math.min(width, getWidth(r, column));
            } else break;
        }

        return height * width;
    }

    private static int getWidth(int row, int column) {
        int width = 1;

        for (int w = column + 1; w < tile[0].length; w++) {
            if (tile[row][w] == 1) width++;
            else break;
        }

        return width;
    }
}
