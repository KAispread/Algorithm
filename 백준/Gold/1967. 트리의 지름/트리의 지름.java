import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
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

    // 루트 노드에서 시작해서 가장 먼 노드를 구함
    // 가장 먼 노드에서 모든 노드로 뻗어나가며 거리를 구하고 가장 큰 거리를 출력
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        if (N == 1) {
            System.out.println(0);
            return;
        }
        node = new List[N + 1];

        for (int i = 1; i < node.length; i++) {
            node[i] = new ArrayList<>();
        }

        // 양방향으로 노드 생성
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            node[parent].add(new Node(child, length));
            node[child].add(new Node(parent, length));
        }

        // 루트에서 시작하여 가장 먼 노드의 번호를 구함
        int[] distFrom1 = getLengthFromStartNode(1);
        int max = 0;
        int nodeNumber = 0;
        for (int i = 1; i < distFrom1.length; i++) {
            if (distFrom1[i] > max) {
                max = distFrom1[i];
                nodeNumber = i;
            }
        }

        int[] distFromNode = getLengthFromStartNode(nodeNumber);
        max = 0;
        for (int dist : distFromNode) {
            if (dist > max) max = dist;
        }

        System.out.println(max);
    }

    private static int[] getLengthFromStartNode(int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        int[] minimum = new int[node.length];
        boolean[] visited = new boolean[node.length];
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node next : node[current.number]) {
                if (!visited[next.number]) {
                    visited[next.number] = true;
                    int length = current.length + next.length;
                    queue.offer(new Node(next.number, length));
                    minimum[next.number] = length;
                }
            }
        }

        return minimum;
    }

}

