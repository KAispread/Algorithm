import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    // M * S + x == N * F + y;
    // 7 .. 17 .. 27 .. 37 .. 47 .. 57 .. 67 .. 77 .. 87 .. 97  .. 107
    // 2 .. 14 .. 26 .. 38 .. 50 .. 62 .. 74 .. 86 .. 98 .. 110 ..
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bf.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Deque<Integer> MQueue = new ArrayDeque<>();
            Deque<Integer> NQueue = new ArrayDeque<>();
            MQueue.offer(x);
            NQueue.offer(y);

            int answer = -1;
            for (int j = 1; j <= Math.max(M, N); j++) {
                Integer mp = MQueue.peek();
                Integer np = NQueue.peek();
                MQueue.offer(MQueue.peekLast() + M);
                NQueue.offer(NQueue.peekLast() + N);

                if (np < mp) {
                    NQueue.poll();
                } else if (np > mp) {
                    MQueue.poll();
                } else {
                    answer = mp;
                    break;
                }
            }

            if (answer != - 1) {
                System.out.println(answer);
                continue;
            }

            while (!MQueue.isEmpty() && !NQueue.isEmpty()) {
                Integer mp = MQueue.peek();
                Integer np = NQueue.peek();

                if (np < mp) {
                    NQueue.poll();
                } else if (np > mp) {
                    MQueue.poll();
                } else {
                    answer = mp;
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}

