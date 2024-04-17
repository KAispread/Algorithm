import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 단방향 도로를 역방향으로 저장
    // 면접장이 배치된 도시에서 다른 모든 도시로 가는 최단 거리에서 가장
    // Map<> 에 각 도시의 정보를 저장해놓고 면접장이 배치된 도시에 다익스트라 알고리즘을 K번 사용하면서 최단거리 update
    // Map.entry 를 통해 update 된 도시의 정보를 array에 넣고 정렬

    static class Edge {
        int number;
        long dist;

        public Edge(int number, long dist) {
            this.number = number;
            this.dist = dist;
        }
    }

    static final long INF = 100_000_000_000L;
    static List<Edge>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        nodes = new List[N + 1];
        int[] kNodes = new int[K];

        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            nodes[V].add(new Edge(U, dist));
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(st.nextToken());
            kNodes[i] = n;
        }

        long[] minimum = dijkstra(kNodes);

        long answer = 0;
        int number = 0;
        for (int i = 1; i < minimum.length; i++) {
            if (answer < minimum[i]) {
                answer = minimum[i];
                number = i;
            }
        }

        System.out.println(number);
        System.out.println(answer);
    }

    private static long[] dijkstra(int[] k) {
        Queue<Edge> queue = new PriorityQueue<>((o1, o2) -> (int) (o1.dist - o2.dist));
        long[] minimum = new long[nodes.length];
        Arrays.fill(minimum, INF);

        for (int ks : k) {
            minimum[ks] = 0;
            queue.offer(new Edge(ks, 0));
        }

        while (!queue.isEmpty()) {
            Edge current = queue.poll();

            if (minimum[current.number] < current.dist) continue;

            for (Edge next : nodes[current.number]) {
                if (minimum[next.number] > current.dist + next.dist) {
                    minimum[next.number] = current.dist + next.dist;
                    queue.offer(new Edge(next.number, minimum[next.number]));
                }
            }
        }

        return minimum;
    }
}
