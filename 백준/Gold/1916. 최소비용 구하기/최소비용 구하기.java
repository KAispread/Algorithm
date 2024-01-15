import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* Gold V - 1916번
* */
public class Main {
    static List<Node>[] node;
    static int value[];
    static boolean visited[];
    static Queue<Node> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        node = new ArrayList[N + 1];
        value = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            node[i] = new ArrayList<>();
            value[i] = Integer.MAX_VALUE;
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            node[A].add(new Node(B, cost));
        }

        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        value[start] = 0;
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            int current = n.next;

            if (visited[current]) {
                continue;
            }
            visited[current] = true;

            for (Node nextNode : node[current]) {
                int next = nextNode.next;

                value[next] = Math.min(value[next], value[current] + nextNode.cost);
                queue.offer(new Node(next, value[next]));
            }
        }
        System.out.println(value[end]);
    }

    static class Node implements Comparable<Node>{
        int next;
        int cost;

        public Node(int next, int cost) {
            this.cost = cost;
            this.next = next;
        }

        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
}
