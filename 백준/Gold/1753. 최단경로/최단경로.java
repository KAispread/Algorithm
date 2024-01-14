import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

/*
 * Gold V - 1753번
 * */
public class Main {
    static int V, E, K;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Edge>[] list;
    static PriorityQueue<Edge> q = new PriorityQueue<Edge>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(bf.readLine());

        distance = new int[V+1];
        visited = new boolean[V +1];
        list = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Edge>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            list[A].add(new Edge(B, W));
        }

        q.offer(new Edge(K, 0));
        distance[K] = 0;

        while (!q.isEmpty()) {
            Edge current = q.poll();
            int c_v = current.next;

            if (visited[c_v]) {
                continue;
            }
            visited[c_v] = true;

            for (Edge tmp : list[c_v]) {
                int next = tmp.next;
                int value = tmp.w;
                distance[next] = Math.min(distance[next], distance[c_v] + value);
                q.offer(new Edge(next, distance[next]));
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                builder.append("INF").append("\n");
                continue;
            }
            builder.append(distance[i]).append("\n");
        }
        System.out.println(builder);
    }

    static class Edge implements Comparable<Edge> {
        int next;
        int w;

        public Edge(int next, int w) {
            this.next = next;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}
