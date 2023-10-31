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
* 다익스트라 알고리즘 사용
* 정점 N으로 오는 모든 정점에 대하여 다익스트라 알고리즘 수행
* 모든 정점에서 출발하여 정점 N으로 가는 경로에 대해 다익스트라 알고리즘 수행
* 1, 2 번을 합쳤을 때 가장 큰 값을 출력
* */
public class Main {

    static class Node {
        int idx;
        int length;

        public Node(int idx, int length) {
            this.idx = idx;
            this.length = length;
        }
    }

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Node>[] comeToNode = new List[N + 1];
        List<Node>[] fromNode = new List[N + 1];

        for (int i = 1; i < comeToNode.length; i++) {
            comeToNode[i] = new ArrayList<>();
            fromNode[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            comeToNode[end].add(new Node(start, length));
            fromNode[start].add(new Node(end, length));
        }

        int[] comeTo = dijkstra(X,N, comeToNode);
        int[] fromTo = dijkstra(X,N, fromNode);

        int max = 0;
        for (int i = 1; i < comeTo.length; i++) {
            max = Math.max(comeTo[i] + fromTo[i], max);
        }
        System.out.println(max);
    }

    private static int[] dijkstra(int X, int N, List<Node>[] node) {
        visited = new boolean[N + 1];
        Queue<Node> leftNode = new PriorityQueue<>((o1, o2) -> o1.length - o2.length);
        leftNode.offer(new Node(X, 0));

        int[] minimum = new int[N + 1];
        Arrays.fill(minimum, Integer.MAX_VALUE);
        minimum[X] = 0;

        // 한 정점에서 N으로 가는 최단거리 구하기
        while (!leftNode.isEmpty()) {
            Node n = leftNode.poll();

            if (!visited[n.idx]) {
                visited[n.idx] = true;

                for (Node current : node[n.idx]) {
                    if (!visited[current.idx] && minimum[current.idx] > n.length + current.length) {
                        minimum[current.idx] = Math.min(n.length + current.length, minimum[current.idx]);
                        leftNode.offer(new Node(current.idx, minimum[current.idx]));
                    }
                }
            }
        }

        return minimum;
    }
}
