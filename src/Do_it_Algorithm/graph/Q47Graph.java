package Do_it_Algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q47Graph {
    private static List<Integer>[] node;
    private static boolean[] visited;
    static int answer[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        node = new ArrayList[N + 1];
        for (int i = 1; i < node.length; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            node[B].add(A);
        }

        int max = 0;
        answer = new int[N + 1];
        for (int i = 1; i < node.length; i++) {
            visited = new boolean[node.length];
            int count = BFS(i);
            answer[i] = count;
            if (max < count) {
                max = count;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < answer.length; i++) {
            if (answer[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static int BFS(int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target);
        visited[target] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (Integer forward : node[poll]) {
                if (!visited[forward]) {
                    visited[forward] = true;
                    queue.add(forward);
                    count++;
                }
            }
        }
        return count;
    }
}
