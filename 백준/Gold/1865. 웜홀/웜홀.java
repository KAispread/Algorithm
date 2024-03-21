import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int number;
        int dist;

        public Edge(int number, int dist) {
            this.number = number;
            this.dist = dist;
        }
    }

    static List<Edge>[] nodes;
    static final int MAX = 987654321;

    // Bellman ford
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(bf.readLine());

            int nodesNumber = Integer.parseInt(st.nextToken());
            int roadsNumber = Integer.parseInt(st.nextToken());
            int holeNumber = Integer.parseInt(st.nextToken());

            nodes = new List[nodesNumber + 1];

            for (int i = 1; i < nodes.length; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0; i < roadsNumber + holeNumber; i++) {
                // 도로일경우
                if (i < roadsNumber) {
                    st = new StringTokenizer(bf.readLine());

                    int nodeA = Integer.parseInt(st.nextToken());
                    int nodeB = Integer.parseInt(st.nextToken());
                    int dist = Integer.parseInt(st.nextToken());

                    nodes[nodeA].add(new Edge(nodeB, dist));
                    nodes[nodeB].add(new Edge(nodeA, dist));

                    continue;
                }

                // 웜홀일경우
                st = new StringTokenizer(bf.readLine());

                int nodeA = Integer.parseInt(st.nextToken());
                int nodeB = Integer.parseInt(st.nextToken());
                int back = Integer.parseInt(st.nextToken());

                nodes[nodeA].add(new Edge(nodeB, -back));
            }

            if (bellmanFord(1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean bellmanFord(int start) {
        int[] minimum = new int[nodes.length];
        Arrays.fill(minimum, MAX);
        minimum[start] = 0;

        for (int i = 1; i < nodes.length - 1; i++) {

            boolean update = false;
            for (int j = 1; j < nodes.length; j++) {
                for (Edge next : nodes[j]) {
                    if (minimum[next.number] > next.dist + minimum[j]) {
                        minimum[next.number] = next.dist + minimum[j];
                        update = true;
                    }
                }
            }

            if (!update) break;

            if (i == nodes.length - 2) {
                for (int j = 1; j < nodes.length; j++) {
                    for (Edge next : nodes[j]) {
                        if (minimum[next.number] > next.dist + minimum[j]) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
