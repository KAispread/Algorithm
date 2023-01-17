package Do_it_Algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* 1197번 다시 풀어보기
* 최소 신장 트리
* */
public class Q64Remind {

    static int[] union;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        union = new int[V + 1];
        for (int i = 1; i < union.length; i++) {
            union[i] = i;
        }

        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());

            edges[i] = new Edge(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(edges);

        int count = 0;
        int min = 0;
        for (int i = 0; i < edges.length; i++) {
            if (count == V - 1) {
                break;
            }
            Edge e = edges[i];
            if (find(e.a) != find(e.b)) {
                union(e.a, e.b);
                count++;
                min += e.w;
            }
        }
        System.out.println(min);
    }

    private static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A != B) {
            union[B] = A;
        }
    }

    private static int find(int a) {
        if (union[a] == a) {
            return a;
        }
        return union[a] = find(union[a]);
    }

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int w;

        public Edge (int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}
