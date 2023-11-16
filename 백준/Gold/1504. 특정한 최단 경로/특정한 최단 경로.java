import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    private static List<Node>[] nodes;
    private static boolean[] visited;
    private static int MAX = 1000 * 800 * 10;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        nodes = new List[N + 1];

        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes[a].add(new Node(b, cost));
            nodes[b].add(new Node(a, cost));
        }

        st = new StringTokenizer(bf.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] dijstraV1 = dijstra(N, v1);
        int[] dijstraV2 = dijstra(N, v2);

        int answer = 0;
        answer = Math.min((dijstraV1[1] + dijstraV1[v2] + dijstraV2[N]), (dijstraV2[1] + dijstraV2[v1] + dijstraV1[N]));

        if (answer >= MAX) {
            System.out.println("-1");
            return;
        }
        System.out.println(answer);
    }

    public static int[] dijstra(int N, int pivot) {
        visited = new boolean[N + 1];
        int[] minimum = new int[N + 1];
        Arrays.fill(minimum, MAX);

        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        queue.offer(new Node(pivot, 0));
        minimum[pivot] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (!visited[current.index]) {
                visited[current.index] = true;

                for (Node node : nodes[current.index]) {
                    int cost = node.cost + current.cost;

                    if (!visited[node.index] && minimum[node.index] > cost) {
                        minimum[node.index] = cost;
                        queue.offer(new Node(node.index, cost));
                    }
                }
            }
        }

        return minimum;
    }
}
