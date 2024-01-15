import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    static final int INF = 987654321;

    // bellmanFord
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            node = new List[N + 1];
            for (int i = 1; i < node.length; i++) {
                node[i] = new ArrayList<>();
            }

            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(bf.readLine());

                int nodeA = Integer.parseInt(st.nextToken());
                int nodeB = Integer.parseInt(st.nextToken());
                int length = Integer.parseInt(st.nextToken());

                if (i >= M) {
                    node[nodeA].add(new Node(nodeB, -length));
                    continue;
                }

                node[nodeA].add(new Node(nodeB, length));
                node[nodeB].add(new Node(nodeA, length));
            }

            if (bellmanFord(1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean bellmanFord(int start) {
        int[] minimum = new int[node.length];
        Arrays.fill(minimum, INF);
        minimum[start] = 0;
        boolean update = false;

        // 전체 노드의 수보다 1 적게 반복
        for (int i = 1; i < minimum.length - 1; i++) {
            update = false;

            // 모든 노드를 순회하며 노드 값 update
            for (int j = 1; j < node.length; j++) {
                for (Node next : node[j]) {
                    if (minimum[next.number] > minimum[j] + next.length) {
                        minimum[next.number] = minimum[j] + next.length;
                        update = true;
                    }
                }
            }

            if (!update) {
                break;
            }
        }

        if (update) {
            // 업데이트가 발생한다면 음수 사이클이 있는 것
            for (int j = 1; j < node.length; j++) {
                for (Node next : node[j]) {
                    if (minimum[next.number] > minimum[j] + next.length) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

