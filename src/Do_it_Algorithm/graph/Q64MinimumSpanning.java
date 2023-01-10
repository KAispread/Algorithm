package Do_it_Algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* 1197번 - Gold IV
* */
public class Q64MinimumSpanning {
    static int[] union;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        union = new int[V+1];
        for (int i = 1; i < union.length; i++) {
            union[i] = i;
        }

        edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(A, B, W);
        }

        Arrays.sort(edges, (o1, o2) -> { return (int) (o1.W - o2.W);});

        int minWeight = 0;
        int count = 0;

        for (int i = 0; i < edges.length; i++) {
            if (count == V - 1) {
                break;
            }
            Edge edge = edges[i];
            int rootA = find(edge.A);
            int rootB = find(edge.B);

            if (rootA != rootB) {
                union(rootA, rootB);
                minWeight += edge.W;
                count++;
            }
        }

        System.out.println(minWeight);
    }

    private static void union(int nodeA, int nodeB) {
        if (nodeA != nodeB) {
            union[nodeA] = nodeB;
        }
    }

    private static int find(int node) {
        if (union[node] == node) {
            return node;
        }
        // 경로 압축 필쑤
        return union[node] = find(union[node]);
    }

    static class Edge {
        int A;
        int B;
        long W;

        public Edge(int A, int B, long W) {
            this.A = A;
            this.B = B;
            this.W = W;
        }
    }
}
