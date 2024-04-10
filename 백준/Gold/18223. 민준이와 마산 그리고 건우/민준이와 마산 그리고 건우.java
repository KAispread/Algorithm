import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final String SAVE = "SAVE HIM";
    private static final String ABANDON = "GOOD BYE";

    private static List<Edge>[] nodes;

    static class Edge {
        int number;
        int distance;

        public Edge(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }
    }

    // 건우가 있는 정점에서 민준이가 있는 곳까지 최단거리 + 마산까지의 거리가
    // 민준이가 있는 곳에서 마산까지의 거리보다 크다면 GOOD BYE
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        nodes = new List[V + 1];
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());

            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            nodes[nodeA].add(new Edge(nodeB, distance));
            nodes[nodeB].add(new Edge(nodeA, distance));
        }

        int[] minimumDistanceFromStart = dijkstra(1);
        int[] minimumDistanceFromGoenu = dijkstra(P);

        int minimumDistanceToMasan = minimumDistanceFromStart[V];

        if (minimumDistanceToMasan >= minimumDistanceFromGoenu[1] + minimumDistanceFromGoenu[V]) {
            System.out.println(SAVE);
        } else {
            System.out.println(ABANDON);
        }
    }

    private static int[] dijkstra(int pivot) {
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        queue.offer(new Edge(pivot, 0));

        int[] minimum = new int[nodes.length];
        Arrays.fill(minimum, Integer.MAX_VALUE);
        minimum[pivot] = 0;

        boolean[] visited = new boolean[nodes.length];

        while (!queue.isEmpty()) {
            Edge current = queue.poll();

            if (visited[current.number]) continue;
            visited[current.number] = true;

            for (Edge next : nodes[current.number]) {
                if (!visited[next.number] && minimum[next.number] > next.distance + current.distance) {
                    minimum[next.number] = next.distance + current.distance;
                    queue.offer(new Edge(next.number, minimum[next.number]));
                }
            }
        }

        return minimum;
    }
}
