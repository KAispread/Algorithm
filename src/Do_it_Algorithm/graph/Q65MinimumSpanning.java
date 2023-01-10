package Do_it_Algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

/*
* 17472번 - Gold III
* *****미해결******
* */
public class Q65MinimumSpanning {
    static int[][] node;
    static int[] routeX = {0, 0, -1, 1};
    static int[] routeY = {1, -1, 0, 0};
    static int[] union;
    static int islandNumber = 0;
    static List<int[]>[] island;
    static List<Edge> edges;
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        node = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < M; j++) {
                int tile = Integer.parseInt(st.nextToken());
                node[i][j] = tile;
            }
        }

        checked = new boolean[N][M];

    }

    private void BFS() {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < checked.length; i++) {
                for (int j = 0; j < checked[0].length; j++) {
                    if (!checked[i][j] && node[i][j] > 0) {

                    }
                }
            }
        }
    }

    static class Edge {
        int toA;
        int toB;
        int w;

        public Edge(int toA, int toB, int w) {
            this.toA = toA;
            this.toB = toB;
            this.w = w;
        }
    }
}
