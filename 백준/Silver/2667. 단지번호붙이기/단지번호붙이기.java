import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 맵을 만듦
* 0,0부터 시작해서 1인 구간을 찾으면 BFS 탐색 ㄱ
* visited로 방문한 지역 체크
* */
public class Main {

    private static int[][] move = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] house = bf.readLine().toCharArray();
            for (int j = 0; j < house.length; j++) {
                map[i][j] = house[j];
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '1') {
                    answer.add(BFS(map, i, j));
                }
            }
        }

        System.out.println(answer.size());
        answer.stream()
            .sorted()
            .forEach(System.out::println);
    }

    // return - 몇 가구인지?
    private static int BFS(char[][] map, int i, int j) {
        int answer = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        map[i][j] = '0';

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0];
            int y = p[1];

            // 상하좌우
            for (int[] m : move) {
                int cx = x +  m[0];
                int cy = y +  m[1];

                if (validate(map, cx, cy)) {
                    queue.offer(new int[] {cx, cy});
                    map[cx][cy] = '0';
                    answer++;
                }
            }
        }

        return answer;
    }

    private static boolean validate(char[][] map, int x, int y) {
        if (x < 0 || y < 0 || x >= map.length || y >= map[0].length) return false;
        if (map[x][y] != '1') return false;
        return true;
    }
}
