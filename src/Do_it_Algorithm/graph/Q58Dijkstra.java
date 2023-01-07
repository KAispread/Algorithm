package Do_it_Algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* Platinum - 1854번
* */
public class Q58Dijkstra {
    static boolean[] visited;
    static int[] distance;
    static List<Node>[] nodes;
    static Queue<Node> queue = new PriorityQueue<>();
    static Queue<Integer>[] listQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N + 1];
        listQueue = new PriorityQueue[N + 1];
        distance = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
            listQueue[i] = new PriorityQueue<>(Comparator.reverseOrder());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            nodes[A].add(new Node(B, W));
        }

        queue.offer(new Node(1, 0));
        distance[1] = 0;
        listQueue[1].add(0);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int v = current.v;

            if (visited[v]) {
                continue;
            }
            visited[v] = true;

            for (Node temp : nodes[v]) {
                int next = temp.v;

                distance[next] = Math.min(distance[v] + temp.w, distance[next]);
                queue.offer(new Node(next, distance[next]));

                if (listQueue[next].size() < K) {
                    listQueue[next].offer( distance[v] + temp.w);
                } else if (listQueue[next].peek() > distance[v] + temp.w) {
                    listQueue[next].poll();
                    listQueue[next].offer( distance[v] + temp.w);
                }
            }
        }

        for (int i = 1; i < listQueue.length; i++) {
            if (listQueue[i].size() != K) {
                System.out.println("-1");
            } else {
                System.out.println(listQueue[i].peek());
            }
        }
    }

    static class Node implements Comparable<Node>{
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public int compareTo(Node n) {
            return this.w - n.w;
        }
    }
}
