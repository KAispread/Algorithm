import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 다익스트라
* 1. 출발 노드 -> 감염된 노드
* 2. 다익스트라 알고리즘으로 queue.poll() 한 값이 visited = false 이면 max 값 비교
* 3. visited = true 로 바뀔 때 감염된 컴퓨터 수 + 1
*
* */
public class Main {

    static class Node {
        int index;
        int length;

        public Node(int index, int length) {
            this.index = index;
            this.length = length;
        }
    }

    private static List<Node>[] nodes;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(bf.readLine());
            int computerCount = Integer.parseInt(st.nextToken());
            int dependencyCount = Integer.parseInt(st.nextToken());
            int hackedIdx = Integer.parseInt(st.nextToken());

            // 노드, visited 초기화
            nodes = new List[computerCount+1];
            visited = new boolean[computerCount+1];
            for (int j = 1; j < nodes.length; j++) {
                nodes[j] = new ArrayList<>();
            }

            // 관계 추가
            for (int j = 0; j < dependencyCount; j++) {
                st = new StringTokenizer(bf.readLine());
                int endIdx = Integer.parseInt(st.nextToken());
                int fromIdx = Integer.parseInt(st.nextToken());
                int length = Integer.parseInt(st.nextToken());

                nodes[fromIdx].add(new Node(endIdx, length));
            }

            int[] timeAndCount = diikstra(computerCount, hackedIdx);
            System.out.println(timeAndCount[1] + " " + timeAndCount[0]);
        }
    }

    private static int[] diikstra(int computerCount, int hackedIdx) {
        int count = 0;
        int time = 0;
        // 최단거리 배열 초기화
        int[] minimum = new int[computerCount + 1];
        Arrays.fill(minimum, Integer.MAX_VALUE);

        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.length - o2.length);
        queue.offer(new Node(hackedIdx, 0));

        // 다익스트라 알고리즘
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (!visited[current.index]) {
                visited[current.index] = true;
                time = Math.max(current.length, time);
                count++;

                for (Node n : nodes[current.index]) {
                    if (!visited[n.index] && minimum[n.index] > current.length + n.length) {
                        minimum[n.index] = current.length + n.length;
                        queue.offer(new Node(n.index, minimum[n.index]));
                    }
                }
            }
        }

        return new int[] {time, count};
    }
}
