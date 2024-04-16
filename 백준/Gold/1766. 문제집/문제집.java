import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] nodes;

    // 위상이 0인 문제부터 Queue에 삽입 -> PriorityQueue 사용 -> 문제가 쉬운순으로 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nodes = new List[N+1];
        int[] forces = new int[N+1];

        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            forces[after] += 1;
            nodes[pre].add(after);
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < forces.length; i++) {
            if (forces[i] == 0) queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");

            for (int next : nodes[current]) {
                forces[next] -= 1;
                if (forces[next] == 0) queue.offer(next);
            }
        }

        System.out.println(sb.toString());
    }
}
