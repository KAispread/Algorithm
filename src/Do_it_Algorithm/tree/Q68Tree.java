package Do_it_Algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q68Tree {
    static List<Integer>[] node;
    static boolean[] visited;
    static int ROOT;
    static int answer = 0;
    static int rmNode;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        node = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            node[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0 ; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == -1) {
                ROOT = i;
                continue;
            }
            node[i].add(n);
            node[n].add(i);
        }

        rmNode = Integer.parseInt(bf.readLine());

        if (rmNode == ROOT) {
            System.out.println(0);
            return;
        }

        visited[rmNode] = true;
        DFS(ROOT);
        System.out.println(answer);
    }

    private static void DFS(int number) {
        visited[number] = true;
        int cNode = 0;

        for (int next : node[number]) {
            if (!visited[next] && next != rmNode) {
                cNode++;
                DFS(next);
            }
        }
        if (cNode == 0) {
            answer++;
        }
    }
}
