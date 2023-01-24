package Do_it_Algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
* 11725번 - Silver II
* */
public class Q67Tree {
    static List<Integer>[] node;
    static boolean[] visited;
    static int[] answer;
    static int a;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        node = new ArrayList[N + 1];
        answer = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < node.length; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);
        }
        DFS(1);
        StringBuilder builder = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            builder.append(answer[i]).append("\n");
        }
        System.out.println(builder);
    }

    // 루트노드 1부터 순회하며 각 노드의 부모 노드를 마킹
    private static void DFS(int number) {
        for (Integer next : node[number]) {
            if (!visited[next]) {
                visited[next] = true;
                answer[next] = number;
                DFS(next);
            }
        }
    }
}
