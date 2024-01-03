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

    private static List<Integer>[] node;

    // Blue 색깔은 미리 계산 후 0으로 초기화 -> 이후 배열 복사 -> 적록색약인 경우, 아닌 경우 따로 BFS Go
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        node = new List[N + 1];

        for (int i = 1; i < node.length; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 1; j <= N; j++) {
                int flag = Integer.parseInt(st.nextToken());

                if (flag == 1) {
                    node[i].add(j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(isAbleToGo(i, j, N)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int isAbleToGo(int start, int end, int N) {
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : node[current]) {
                if (next == end) return 1;

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return 0;
    }
}

