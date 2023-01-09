package Do_it_Algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* Silver I - 1389번
* */
public class Q63FloydWarshall {
    static int[][] node;
    static int BIG_NUM = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        node = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                node[i][j] = BIG_NUM;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int fA = Integer.parseInt(st.nextToken());
            int fB = Integer.parseInt(st.nextToken());
            node[fA][fB] = 1;
            node[fB][fA] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    node[i][j] = Math.min(node[i][j], node[i][k] + node[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int[] result = new int[N+1];

        for (int i = 1; i <= N; i++) {
            int kevin = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                if (node[i][j] != Integer.MAX_VALUE) {
                    kevin += node[i][j];
                }
            }
            min = Math.min(min, kevin);
            result[i] = kevin;
        }

        for (int i = 1; i <= N; i++) {
            if (result[i] == min) {
                System.out.println(i);
                return;
            }
        }
    }
}
