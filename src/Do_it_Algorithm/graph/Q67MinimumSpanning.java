package Do_it_Algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* 1414번 - Gold I
* */
public class Q67MinimumSpanning {
    static int[] union;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        union = new int[N + 1];
        for (int i = 1; i < union.length; i++) {
            union[i] = i;
        }

        int total = 0;
        List<Edge> edges = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            String l = bf.readLine();
            for (int j = 1; j <= N; j++) {
                char c = l.charAt(j - 1);
                int length = 0;
                if (c >= 'a' && c <= 'z') {
                    length = c - 'a' + 1;
                } else if (c >= 'A' && c <= 'Z') {
                    length = c - 'A' + 27;
                }

                total += length;
                if (length != 0 && i != j) {
                    edges.add(new Edge(i, j, length));

                }
            }
        }

        Collections.sort(edges);

        int count = 0;
        int need = 0;
        for (int i = 0; i < edges.size(); i++) {
            if (count == N - 1) {
                break;
            }
            Edge e = edges.get(i);
            if (find(e.a) != find(e.b)) {
                union(e.a, e.b);
                count++;
                need += e.w;
            }
        }

        int u = union[1];

        if (count < N - 1) {
            System.out.println(-1);
            return;
        }
        System.out.println(total - need);
    }

    private static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A != B) {
            int m = Math.min(A, B);
            int x = Math.max(A, B);
            union[x] = m;
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

        public Edge(int a, int b, int w) {
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
