package commuLearning.week3.step2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question2 {
    boolean[] send;
    int[] receive;
    List<Integer>[] node;

    public int solution(int n, int c, int k, int[][] contact) {
        node = new ArrayList[n + 1];
        send = new boolean[n + 1];
        receive = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            node[i] = new ArrayList<>();
        }

        for (int[] con : contact) {
            int a = con[0];
            int b = con[1];
            node[a].add(b);
        }

        // 악동 주민은 무조건 편지를 보내므로 악동 주민만큼 BFS
        for (int i = 1; i <= c; i++) {
            BFS(i, k);
        }

        int answer = 0;

        // receive가 0이면 편지를 한 통도 받지 않은 것
        for (int i = c + 1; i < n + 1; i++) {
            if (receive[i] == 0) answer++;
        }

        return answer;
    }

    private void BFS(int bad, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(bad);

        send[bad] = true;

        while (!queue.isEmpty()) {
            int s = queue.poll();

            for (int r : node[s]) {
                receive[r]++;

                // 편지를 일정 횟수 이상 받았고 아직 편지를 보낸 적이 없다면 편지를 돌림
                if (receive[r] >= k && !send[r]) {
                    queue.offer(r);
                    send[r] = true;
                }
            }
        }
    }
}

