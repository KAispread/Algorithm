import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int number;
        int cost;
        List<Integer> route;

        public Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }

        public Node(int number, int cost, List<Integer> route) {
            this.number = number;
            this.cost = cost;
            this.route = new ArrayList<>(route);
            this.route.add(number);
        }
    }

    static List<Node>[] nodes;
    static final int INF = 987654321;

    /*
    * 1. 다익스트라 알고리즘 사용
    * 2. 최소 노드를 확정 지을때마다 새로운 노드 생성 new Node() -> Node에 경로도 추가 List<Integer>
    * 3. Queue에서 poll 한 Node가 도착지점 Node라면 결과 Node를 반환
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(bf.readLine());

        nodes = new List[N + 1];
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(bf.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        Node minimum = dijikstra(startNode, endNode);
        StringBuilder sb = new StringBuilder();
        sb.append(minimum.cost).append("\n");
        sb.append(minimum.route.size()).append("\n");
        for (int node : minimum.route) {
            sb.append(node).append(" ");
        }

        System.out.println(sb);
    }

    private static Node dijikstra(int start, int end) {
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        queue.offer(new Node(start, 0, new ArrayList<>()));
        boolean[] visited = new boolean[nodes.length];
        int[] minimum = new int[nodes.length];
        Arrays.fill(minimum, INF);
        minimum[start] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.number == end) return current;

            if (visited[current.number]) continue;
            visited[current.number] = true;

            for (Node next : nodes[current.number]) {
                if (!visited[next.number] && minimum[next.number] > next.cost + current.cost) {
                    minimum[next.number] = next.cost + current.cost;
                    queue.offer(new Node(next.number, minimum[next.number], current.route));
                }
            }
        }

        throw new RuntimeException();
    }

}

