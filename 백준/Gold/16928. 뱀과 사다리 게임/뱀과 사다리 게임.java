import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Map<Integer, Integer> hole = new HashMap<>();
    static boolean[] visited = new boolean[200];

    static class Route {
        int point;
        int count;

        public Route(int point) {
            this.point = point;
            this.count = 1;
        }

        public Route(int point, int count) {
            this.point = point;
            this.count = count;
        }

        public void forward(int point) {
            this.point = point;
            this.count += 1;
        }
    }

    // map 의 모든 정점에서 시작해서 상,하,좌,우 중 가장 최대인 수를 찾고 그 지점으로 이동, 4회까지만 반복 -> 최댓값 갱신
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            hole.put(A, B);
        }

        Queue<Route> queue = new LinkedList<>();

        for (int i = 7; i >= 2; i--) {
            visited[i] = true;
            int next = hole.getOrDefault(i, i);
            queue.offer(new Route(next));
        }

        int answer = 100;
        while (!queue.isEmpty()) {
            Route route = queue.poll();

            for (int i = 6; i >= 1; i--) {
                int next = route.point + i;
                int nextPoint = hole.getOrDefault(next, next);
                int count = route.count + 1;

                if (nextPoint == 100) {
                    answer = Math.min(count, answer);
                    break;
                }

                if (nextPoint < 100 && !visited[nextPoint]) {
                    visited[nextPoint] = true;
                    queue.offer(new Route(nextPoint, count));
                }
            }
        }

        System.out.println(answer);
    }

}

