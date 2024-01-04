import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] node;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int vertexCount = Integer.parseInt(st.nextToken());
        int trunkCount = Integer.parseInt(st.nextToken());

        node = new List[vertexCount + 1];
        visited = new boolean[vertexCount + 1];

        for (int i = 1; i < node.length; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < trunkCount; i++) {
            st = new StringTokenizer(bf.readLine());
            int vertexA = Integer.parseInt(st.nextToken());
            int vertexB = Integer.parseInt(st.nextToken());

            node[vertexA].add(vertexB);
            node[vertexB].add(vertexA);
        }

        int answer = 0;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                answer++;
                scanVertex(i);
            }
        }

        System.out.println(answer);
    }

    private static void scanVertex(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : node[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

}

