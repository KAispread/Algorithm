package Programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 전력망을 둘로 나누기
* 특정 노드 제외 BFS
* */
public class DivideTop {
    static List<Integer>[] node;
    static boolean[] visited;

    public int solution(int n, int[][] wires) {
        node = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            node[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int A = wire[0];
            int B = wire[1];
            node[A].add(B);
            node[B].add(A);
        }

        int answer = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            int A = wire[0];
            int B = wire[1];
            visited = new boolean[n + 1];
            int Acount = BFS(A, B);

            visited = new boolean[n + 1];
            int Bcount = BFS(B, A);

            answer = Math.min(answer, Math.abs(Acount - Bcount));
        }

        return answer;
    }

    private int BFS(int start, int exceptPoint) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        visited[exceptPoint] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (int next : node[n]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}
