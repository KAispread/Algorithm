import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

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

    static Queue<Edge> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    static int[] union;

    /*
    * 크루스칼 알고리즘
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(bf.readLine());

        union = new int[V + 1];
        for (int i = 2; i <= V; i++) {
            union[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            queue.offer(new Edge(nodeA, nodeB, cost));
        }

        int edgeCount = 0;
        int cost = 0;

        while (!queue.isEmpty() && edgeCount < V - 1) {
            Edge current = queue.poll();
            int findA = find(current.nodeA);
            int findB = find(current.nodeB);

            if (findA == findB) continue;
            union(findA, findB);
            edgeCount++;
            cost += current.cost;
        }

        System.out.println(cost);
    }

    private static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA != findB) {
            union[findB] = findA;
        }
    }

    private static int find(int number) {
        if (union[number] == number) return number;
        return union[number] = find(union[number]);
    }
}

