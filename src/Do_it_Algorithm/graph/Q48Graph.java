package Do_it_Algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
*
* */
public class Q48Graph {
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean visited[];
    static boolean IsEven;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for (int t = 0; t < N; t++) {
            String[] s = bf.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            IsEven = true;
            for (int i = 1; i <= V; i++) {
                A[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < E; i++) {
                s = bf.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }

            for (int i = 1; i <= V; i++) {
                if (IsEven){
                    DFS(i);
                } else {
                    break;
                }
            }
            check[1] = 0;
            if (IsEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void DFS(int node) {
        visited[node] = true;
        for (int i : A[node]) {
            if (!visited[i]) {
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            } else if (check[node] == check[i]) {
                IsEven = false;
            }
        }
    }
}
