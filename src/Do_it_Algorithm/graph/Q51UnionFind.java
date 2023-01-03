package Do_it_Algorithm.graph;

import java.io.IOException;
import java.util.Scanner;

/*
* Gold VI - 1976번 - 여행 가자
* */
public class Q51UnionFind {
    static int[] graph;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        graph = new int[N + 1];

        for (int i = 1; i < graph.length; i++) {
            graph[i] = i;
        }

        int[] route = new int[M];
        for (int i = 0; i < M; i++) {
            route[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (sc.nextInt() == 1) {
                    int a = find(i);
                    int b = find(j);
                    if (a != b) {
                        graph[b] = a;
                    }
                }
            }
        }

        int root = find(route[0]);
        for (int r : route) {
            if (root != find(r)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static int find(int num) {
        if (graph[num] == num) {
            return num;
        }
        return graph[num] = find(graph[num]);
    }
}
