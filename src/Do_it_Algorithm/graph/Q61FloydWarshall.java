package Do_it_Algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 11404번 - Gold IV
* */
public class Q61FloydWarshall {
    static int[][] node;

    static final int BIG_NUM = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        node = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                node[i][j] = BIG_NUM;
            }
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            node[start][end] = Math.min(cost, node[start][end]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <=N; k++) {
                    node[j][k] = Math.min(node[j][k], node[j][i] + node[i][k]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (node[i][j] == BIG_NUM) {
                    System.out.print(0 + " ");
                    continue;
                }
                System.out.print(node[i][j] + " ");
            }
            System.out.println();
        }
    }
}
