import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX = 10_0000_0001;

    // 10_0000_0000
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Map<Long, Integer> dp = new HashMap<>();

        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());

        dp.put(A, 0);

        Queue<Long> queue = new LinkedList<>();
        queue.offer(A);

        while (!queue.isEmpty()) {
            Long current = queue.poll();
            if (current > B) continue;

            long multi2 = current * 2L;
            long append1 = current * 10L + 1;

            int currentCount = dp.get(current);
            int multiCount = dp.getOrDefault(multi2, -1);
            int appendCount = dp.getOrDefault(append1, -1);

            if (multi2 <= B && (multiCount == -1 || multiCount > currentCount + 1)) {
                if (multi2 == B) {
                    System.out.println(currentCount + 2);
                    return;
                }

                dp.put(multi2, currentCount + 1);
                queue.offer(multi2);
            }

            if (append1 <= B && (appendCount == -1 || appendCount > currentCount + 1)) {
                if (append1 == B) {
                    System.out.println(currentCount + 2);
                    return;
                }

                dp.put(append1, currentCount + 1);
                queue.offer(append1);
            }
        }

        System.out.println(-1);
    }
}

