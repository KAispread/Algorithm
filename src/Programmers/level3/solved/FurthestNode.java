package Programmers.level3.solved;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 가장 먼 노드
* */
public class FurthestNode {
    private List<Integer>[] node;
    private int[] weight;
    private static final int START = 1;

    public int solution(int n, int[][] edge) {
        setUp(n, edge);

        int max = calcWeight();
        int count = countMaxWeight(max);

        return count;
    }

    private int countMaxWeight(int max) {
        int count = 0;
        for (int w : weight) {
            if (w == max) count++;
        }
        return count;
    }

    private int calcWeight() {
        boolean[] visited = new boolean[node.length];
        int max = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {START, 0});
        visited[START] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int c = poll[0];
            int w = poll[1];
            weight[c] = w;

            max = Math.max(max, w);

            for (Integer next : node[poll[0]]) {
                if (!visited[next]) {
                    queue.offer(new int[] {next, w + 1});
                    visited[next] = true;
                }
            }
        }

        return max;
    }

    private void setUp(int n, int[][] edge) {
        node = new ArrayList[n + 1];
        weight = new int[n + 1];
        for (int i = 1; i < node.length; i++) {
            node[i] = new ArrayList<>();
        }

        setUpNode(edge);
    }

    private void setUpNode(int[][] edge) {
        for(int[] e : edge) {
            node[e[0]].add(e[1]);
            node[e[1]].add(e[0]);
        }
    }
}
