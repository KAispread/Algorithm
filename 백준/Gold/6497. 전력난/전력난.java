import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
    * 모든 집이 연결되어있어야 하고 그 가중치는 최소여야함 -> 크루스칼 알고리즘
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if (V == 0 && E == 0) break;
            solution(V, E, bf);
        }
    }

    static class Edge {
        int nodeA;
        int nodeB;
        int cost;

        public Edge(int nodeA, int nodeB, int cost) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.cost = cost;
        }
    }

    private static void solution(int V, int E, BufferedReader bf) throws IOException {
        Queue<Edge> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        int[] union = new int[V];

        for (int i = 1; i < V; i++) {
            union[i] = i;
        }

        int total = 0;

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            total += cost;
            queue.offer(new Edge(a, b, cost));
        }

        int edgeCount = 0;
        int cost = 0;

        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int findA = find(union, current.nodeA);
            int findB = find(union, current.nodeB);

            if (findA == findB) continue;

            edgeCount++;
            cost += current.cost;
            union(union, findA, findB);
        }

        System.out.println(total - cost);
    }

    private static void union(int[] union, int a, int b) {
        int findA = find(union, a);
        int findB = find(union, b);

        if (findA != findB) {
            union[findB] = findA;
        }
    }

    private static int find(int[] union, int number) {
        if (union[number] == number) return number;
        return union[number] = find(union, union[number]);
    }
}

