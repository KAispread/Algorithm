import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nodes = new List[N + 1];
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        int[] forces = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int number = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());
            for (int j = 1; j < number; j++) {
                int after = Integer.parseInt(st.nextToken());
                nodes[before].add(after);
                forces[after] += 1;
                before = after;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < forces.length; i++) {
            if (forces[i] == 0) queue.offer(i);
        }

        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            answer.add(current);

            for (int node : nodes[current]) {
                forces[node] -= 1;
                if (forces[node] == 0) queue.offer(node);
            }
        }

        if (answer.size() != N) {
            System.out.println(0);
            return;
        }

        for (int number : answer) {
            System.out.println(number);
        }
    }
}
