import java.io.BufferedReader;
import java.io.FileInputStream;
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
        int distance;

        public Node(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }
    }

    static List<Node>[] nodes;
    static int scanArea;
    static int[] numberOfItemsInArea;

    // int[] 에 각 지역별 아이템의 개수를 저장
    // BFS로 모든 지역의 최대 아이템 개수를 구함
    // 다른 지역으로 갈 때 거리를 저장하여 현재 거리 + 다음 노드까지의 거리가 수색 범위보다 작거나 같다면 탐색 Queue에 삽입
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        scanArea = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nodes = new List[N + 1];
        numberOfItemsInArea = new int[N+1];

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
            numberOfItemsInArea[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int areaA = Integer.parseInt(st.nextToken());
            int areaB = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            nodes[areaA].add(new Node(areaB, distance));
            nodes[areaB].add(new Node(areaA, distance));
        }

        int maxItem = 0;
        // 모든 지역에서 내렸을 때 얻을 수 있는 아이템 최대 개수
        for (int i = 1; i <= N; i++) {
            maxItem = Math.max(maxItem, scanItemNumber(i));
        }
        System.out.println(maxItem);
    }

    private static int scanItemNumber(int startArea) {
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        queue.offer(new Node(startArea, 0));

        int[] minimum = new int[nodes.length];
        boolean[] visited = new boolean[nodes.length];
        Arrays.fill(minimum, 987654321);

        minimum[startArea] = 0;
        int itemCount = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (visited[current.number]) continue;
            visited[current.number] = true;

            if (current.distance <= scanArea) itemCount += numberOfItemsInArea[current.number];
            else break;

            for (Node next : nodes[current.number]) {
                int nextNumber = next.number;
                int nextDistance = next.distance + current.distance;

                if (!visited[nextNumber] && minimum[nextNumber] > nextDistance) {
                    queue.offer(new Node(nextNumber, nextDistance));
                    minimum[nextNumber] = nextDistance;
                }
            }
        }

        return itemCount;
    }
}

