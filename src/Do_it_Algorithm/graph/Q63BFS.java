package Do_it_Algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * Silver I - 1389번
 * BFS 로 풀어보기
 * */
public class Q63BFS {
    static List<Integer>[] node;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        node = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int fA = Integer.parseInt(st.nextToken());
            int fB = Integer.parseInt(st.nextToken());
            node[fA].add(fB);
            node[fB].add(fA);
        }

        int min = Integer.MAX_VALUE;
        int[] result = new int[N+1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            visited[i] = true;
            result[i] = BFS(i, N);
            min = Math.min(result[i], min);
        }

        for (int i = 1; i <= N; i++) {
            if (result[i] == min) {
                System.out.println(i);
                return;
            }
        }
     }

    private static int BFS(int start, int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int count = 0;
        int[] depth = new int[N + 1];
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (int next : node[poll]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    depth[next] = depth[poll] + 1;
                    count += depth[next];
                }
            }
        }
        return count;
    }
}
