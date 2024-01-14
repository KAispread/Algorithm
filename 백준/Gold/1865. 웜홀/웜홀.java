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

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            node = new List[N + 1];

            for (int c = 1; c < node.length; c++) {
                node[c] = new ArrayList<>();
            }

            for (int r = 0; r < M; r++) {
                st = new StringTokenizer(bf.readLine());

                int nodeA = Integer.parseInt(st.nextToken());
                int nodeB = Integer.parseInt(st.nextToken());
                int length = Integer.parseInt(st.nextToken());

                node[nodeA].add(new Node(nodeB, length));
                node[nodeB].add(new Node(nodeA, length));
            }

            for (int w = 0; w < W; w++) {
                st = new StringTokenizer(bf.readLine());

                int startNode = Integer.parseInt(st.nextToken());
                int endNode = Integer.parseInt(st.nextToken());
                int backLength = Integer.parseInt(st.nextToken()) * -1;

                node[startNode].add(new Node(endNode, backLength));
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

        for (int i = 1; i < minimum.length - 1; i++) {
            update = false;

            for (int j = 1; j < minimum.length; j++) {
                for (Node next : node[j]) {
                    if (minimum[next.number] > minimum[j] + next.length) {
                        minimum[next.number] = minimum[j] + next.length;
                        update = true;
                    }
                }
            }
        }

        if (update) {
            for (int j = 1; j < minimum.length; j++) {
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

