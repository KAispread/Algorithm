import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int nodeA;
        int nodeB;
        int weight;

        public Edge(int nodeA, int nodeB, int weight) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.weight = weight;
        }
    }

    static Queue<Edge> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
    static int[] union;

    /*
    *
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        union = new int[N + 1];

        for (int i = 1; i < union.length; i++) {
            union[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            queue.add(new Edge(nodeA, nodeB, weight));
        }

        int maxWeight= 0;
        int sum = 0;
        int edgeCount = 0;

        while (!queue.isEmpty() && edgeCount < N - 1) {
            Edge current = queue.poll();
            int findA = find(current.nodeA);
            int findB = find(current.nodeB);

            if (findA == findB) continue;
            union(findA, findB);
            
            maxWeight = Math.max(maxWeight, current.weight);
            sum += current.weight;
            edgeCount++;
        }

        System.out.println(sum - maxWeight);
    }


    private static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA != findB) {
            union[findB] = findA;
        }
    }

    private static int find(int a) {
        if (union[a] == a) return a;
        return union[a] = find(union[a]);
    }
}

