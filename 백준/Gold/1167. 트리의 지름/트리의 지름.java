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
        int length;

        public Node(int number, int length) {
            this.number = number;
            this.length = length;
        }
    }

    static List<Node>[] node;

    // 1. 임의의 노드에서 가장 멀리 떨어진 노드 번호를 구함
    // 2. 가장 멀리 떨어진 노드에서 다익스트라 알고리즘을 통해 가장 먼 거리를 구함
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int count = Integer.parseInt(st.nextToken());
        node = new List[count + 1];
        for (int i = 1; i < node.length; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(bf.readLine());
            int currentNode = Integer.parseInt(st.nextToken());

            while (true) {
                int nextNode = Integer.parseInt(st.nextToken());
                if (nextNode == -1) break;

                int length = Integer.parseInt(st.nextToken());
                node[currentNode].add(new Node(nextNode, length));
            }
        }

        int[] maxLength = dijicstra(1);
        int nodeNumber = getMaxNode(maxLength);
        int[] dijicstra = dijicstra(nodeNumber);

        int max = 0;
        for (int i = 1; i < dijicstra.length; i++) {
            max = Math.max(dijicstra[i], max);
        }

        System.out.println(max);
    }

    private static int getMaxNode(int[] maxLength) {
        int max = 0;
        int maxNode = 0;
        for (int i = 1; i < maxLength.length; i++) {
            if (max < maxLength[i]) {
                max = maxLength[i];
                maxNode = i;
            }
        }

        return maxNode;
    }

    private static int[] dijicstra(int pivot) {
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> {
            return o2.length - o1.length;
        });

        boolean[] visited = new boolean[node.length];
        int[] maximum = new int[node.length];

        queue.offer(new Node(pivot, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (visited[current.number]) continue;
            visited[current.number] = true;

            for (Node next : node[current.number]) {
                if (!visited[next.number] && maximum[next.number] < current.length + next.length) {
                    maximum[next.number] = Math.max(maximum[next.number], current.length + next.length);
                    queue.offer(new Node(next.number, current.length + next.length));
                }
            }
        }

        return maximum;
    }
}

