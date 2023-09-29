package Programmers.kit.DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// LEVEL3 - 네트워크
public class Network {
    /*
    ** BFS **
    - 한 노드가 어떤 노드까지 뻗어나갈 수 있는지 찾고 마킹하는 문제
    - 0번부터 시작해서 갈 수 있는 모든 노드를 탐색 -> 탐색한 노드는 boolean[] 에 마킹
    - 0번 부터 N-1번까지 반복 -> boolean 에 마킹된 노드는 BFS 탐색을 시작하지 않음
    - Queue와 List[] 로 풀자
    */
    private List<Integer>[] reach;
    private boolean[] visited;

    public int solution(int n, int[][] computers) {
        reach = new List[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            reach[i] = new ArrayList<>();
        }

        // 갈 수 있는 노드 세팅
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    reach[i].add(j);
                }
            }
        }

        // BFS 탐색
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            answer++;

            BFS(i);
        }

        return answer;
    }

    private void BFS(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            List<Integer> list = reach[now];

            for (int node : list) {
                if (!visited[node]) {
                    queue.offer(node);
                    visited[node] = true;
                }
            }
        }
    }
}
