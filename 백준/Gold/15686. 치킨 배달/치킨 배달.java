import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Distance {
        int chickenIndex;
        int dist;

        public Distance(int chickenIndex, int dist) {
            this.chickenIndex = chickenIndex;
            this.dist = dist;
        }
    }

    static List<List<Distance>> chickenDistance = new ArrayList<>();
    static Map<String, Integer> chickenIndex = new HashMap<>();
    static int[][] map;

    static int N;
    static int M;
    static int[][] moving = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static int minimum = 987654321;

    // 각 치킨집에는 Index 가 있음
    // 각 집에서 각 치킨집까지 치킨 거리를 구함 List<List<Dist>> distance = 각 집 별 최소 거리는 오름차순 정렬
    // N 개 중에 M 을 고르는 조합을 통해 각 집과 치킨 거리를 구함
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        int chickenCount = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 1; j <= N; j++) {
                int flag = Integer.parseInt(st.nextToken());
                map[i][j] = flag;

                if (flag == 2) {
                    chickenIndex.put(i+"-"+j, chickenCount++);
                }
            }
        }

        setChickenDistance(chickenCount);
        combination(0, 0, new ArrayList<>(), chickenCount);
        System.out.println(minimum);
    }

    private static void combination(int count, int start, List<Integer> indexes, int chickenCount) {
        if (count == M) {
            updateMinimum(indexes);
            return;
        }

        for (int i = start; i < chickenCount; i++) {
            Integer index = i;
            indexes.add(index);
            combination(count+1, i+1, indexes, chickenCount);
            indexes.remove(index);
        }
    }

    private static void updateMinimum(List<Integer> indexes) {
        int dist = 0;

        for (List<Distance> distances : chickenDistance) {
            for (Distance dists : distances) {
                if (indexes.contains(dists.chickenIndex)) {
                    dist += dists.dist;
                    break;
                }
            }
        }

        minimum = Math.min(minimum, dist);
    }

    private static void setChickenDistance(int chickenCount) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) saveDistance(i, j, chickenCount);
            }
        }
    }

    private static void saveDistance(int y, int x, int chickenCount) {
        List<Distance> distances = new ArrayList<>();

        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y, x, 0});
        boolean[][] visited = new boolean[N+1][N+1];
        visited[y][x] = true;

        while (!queue.isEmpty() && count < chickenCount) {
            int[] current = queue.poll();

            for (int[] move : moving) {
                int tx = move[1] + current[1];
                int ty = move[0] + current[0];

                if (validate(ty, tx, visited)) {
                    if (map[ty][tx] == 2) {
                        int index = chickenIndex.get(ty+"-"+tx);
                        distances.add(new Distance(index, current[2] + 1));
                        count++;
                    }

                    queue.offer(new int[] {ty, tx, current[2] + 1});
                    visited[ty][tx] = true;
                }
            }
        }

        Collections.sort(distances, (o1, o2) -> o1.dist - o2.dist);
        chickenDistance.add(distances);
    }

    private static boolean validate(int y, int x , boolean[][] visited) {
        if (y < 1 || x < 1 || x > N || y > N) return false;
        if (visited[y][x]) return false;
        return true;
    }
}

