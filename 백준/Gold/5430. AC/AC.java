import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    // 구현 문제
    // Dequeue
    // 순방향인지 역방향인지 저장하는 boolean 값으로 연산 수행
    // 배열 크기보다 D 커맨드가 더 많다면 error
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            String command = bf.readLine();
            int arrCount = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine().replace("[", "").replace("]", ""), ",");
            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < arrCount; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            System.out.println(getResult(command, deque));
        }
    }

    private static String getResult(String command, Deque<Integer> deque) {
        boolean naturalOrder = true;

        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == 'R') {
                naturalOrder = !naturalOrder;
                continue;
            }

            if (deque.isEmpty()) return "error";

            if (!naturalOrder) deque.pollLast();
            else deque.pollFirst();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (naturalOrder) {
            while (!deque.isEmpty()) {
                int poll = deque.pollFirst();
                if (deque.isEmpty()) {
                    sb.append(poll);
                } else {
                    sb.append(poll).append(",");
                }
            }
        } else {
            while (!deque.isEmpty()) {
                int poll = deque.pollLast();
                if (deque.isEmpty()) {
                    sb.append(poll);
                } else {
                    sb.append(poll).append(",");
                }
            }
        }

        sb.append("]");
        return sb.toString();
    }
}

