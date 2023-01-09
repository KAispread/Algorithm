package Do_it_Algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 11403번 - Silver I
* */
public class Q62FloydWarshall {
    static int[][] node;
    static final int BIG_NUM = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        node = new int[N+1][N+1];


        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n != 0) {
                    node[i][j] = n;
                }
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <=N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (node[i][k] == 1 && node[k][j] == 1) {
                        node[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (0 < node[i][j]) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
