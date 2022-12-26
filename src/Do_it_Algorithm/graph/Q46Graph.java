package Do_it_Algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 18352번 - Silver II
* 최단거리 문제는 BFS로 풀자
* */
public class Q46Graph {
    private static List<Integer>[] node;
    private static List<Integer> answer = new ArrayList<>();
    private static int[] visited;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        node = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int target = Integer.parseInt(st.nextToken());
            node[target].add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
        }
        BFS(X);

        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == K) {
                answer.add(i);
            }
        }
        if (answer.isEmpty()) {
            System.out.println(-1);
            return;
        }
        Collections.sort(answer);
        for (int temp : answer) {
            System.out.println(temp);
        }
    }

    private static void BFS(int target) {
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(target);
        visited[target]++;

        while (!bfs.isEmpty()) {
            Integer poll = bfs.poll();
            for (Integer forward : node[poll]) {
                if (visited[forward] == -1) {
                    visited[forward] = visited[poll] + 1;
                    bfs.add(forward);
                }
            }
        }
    }
}
