import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int whiteArea = 0;
    private static int blueArea = 0;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int color = Integer.parseInt(st.nextToken());
                map[i][j] = color;
            }
        }

        dividePaper(0, N -1, 0, N - 1);
        System.out.println(whiteArea);
        System.out.println(blueArea);
    }

    private static void dividePaper(int startX, int endX, int startY, int endY) {
        int flag = isAllSame(startX, endX, startY, endY);
        if (flag >= 0) {
            if (flag == 0) whiteArea++;
            else blueArea++;

            return;
        }

        dividePaper(startX, (startX + endX) / 2, startY, (startY + endY) / 2);
        dividePaper((startX + endX) / 2 + 1, endX, startY, (startY + endY) / 2);
        dividePaper(startX, (startX + endX) / 2, (startY + endY) / 2 + 1, endY);
        dividePaper((startX + endX) / 2 + 1, endX,(startY + endY) / 2 + 1, endY);
    }

    private static int isAllSame(int startX, int endX, int startY, int endY) {
        int white = 0;
        int blue = 0;

        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                if (map[i][j] == 0) white++;
                else blue++;
            }
        }

        if (white > 0 && blue == 0) return 0;
        else if (blue > 0 && white == 0) return 1;
        else return -1;
    }
}

