import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private static int[][] map;
    private static int[][] moving = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String mapLine = bf.readLine();

            for (int s = 0; s < mapLine.length(); s++) {
                map[i][s] = mapLine.charAt(s) - '0';
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) answer.add(checkApart(j, i));
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());

        for (int a : answer) {
            System.out.println(a);
        }
    }

    private static int checkApart(int x, int y) {
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        map[y][x] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] move : moving) {
                int tx = current[0] + move[0];
                int ty = current[1] + move[1];

                if (validate(tx, ty)) {
                    queue.offer(new int[] {tx, ty});
                    map[ty][tx] = 0;
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean validate(int x, int y) {
        if (x < 0 || y < 0 || x >= map[0].length || y >= map.length) return false;
        if (map[y][x] <= 0) return false;
        return true;
    }
}

