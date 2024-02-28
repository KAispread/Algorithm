import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] nodes;

    // 위상 정렬 -> A가 B 앞에 서야하므로 B에 위상 +1 을 더함
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] forces = new int[N+1];
        nodes = new List[N + 1];
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            nodes[A].add(B);
            forces[B] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        // 위상이 0인 사람부터 Queue 에 삽입
        for (int i = 1; i < forces.length; i++) {
            if (forces[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int student = queue.poll();
            sb.append(student).append(" ");

            for (int next : nodes[student]) {
                forces[next] -= 1;
                if (forces[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        System.out.println(sb);
    }
}
