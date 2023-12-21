import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int time = Integer.MAX_VALUE;
        int height = 0;

        int[][] map = new int[Y][X];
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < X; j++) {
                int current = Integer.parseInt(st.nextToken());
                map[i][j] = current;
                min = Math.min(min, current);
                max = Math.max(max, current);
            }
        }

        for (int m = min; m <= max; m++) {
            int calcTime = calcTime(map, m, B);
            if (calcTime == -1) continue;

            if (time >= calcTime && height <= m) {
                time = calcTime;
                height = m;
            }
        }

        System.out.println(time + " " + height);
    }

    private static int calcTime(int[][] map, int target, int block) {
        int deleteCount = 0;
        int insertCount = 0;
        int usedBlockCount = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int current = map[i][j];

                if (current > target) {
                    deleteCount += current - target;
                    usedBlockCount -= current - target;
                } else if (current < target) {
                    usedBlockCount += target - current;
                    insertCount += target - current;
                }
            }
        }

        if (usedBlockCount > block) return -1;
        return insertCount + deleteCount * 2;
    }
}

