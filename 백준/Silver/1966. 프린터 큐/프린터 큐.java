import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            solution(bf);
        }
    }

    private static void solution(BufferedReader bf) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int number = Integer.parseInt(st.nextToken());
        int point = Integer.parseInt(st.nextToken());

        Queue<Print> queue = new LinkedList<>();
        st = new StringTokenizer(bf.readLine());
        int[] priorityNumber = new int[10];
        int maxPriority = 0;

        for (int i = 0; i < number; i++) {
            int priority = Integer.parseInt(st.nextToken());

            maxPriority = Math.max(maxPriority, priority);
            priorityNumber[priority] += 1;

            queue.offer(new Print(i, priority));
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Print poll = queue.poll();

            if (poll.priority == maxPriority) {
                count++;

                if (poll.idx == point) break;

                priorityNumber[poll.priority] -= 1;
                if (priorityNumber[poll.priority] <= 0) maxPriority = getMaxPriority(priorityNumber);
            } else {
                queue.offer(poll);
            }
        }

        System.out.println(count);
    }

    private static int getMaxPriority(int[] priorityNumber) {
        for (int i = 9; i > 0; i--) {
            if (priorityNumber[i] > 0) return i;
        }

        return 0;
    }

    static class Print {
        int idx;
        int priority;

        public Print(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}

