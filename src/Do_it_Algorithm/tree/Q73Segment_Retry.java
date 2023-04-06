package Do_it_Algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q73Segment_Retry {
    static long[] tree;
    static final int DIVIDE = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int k = 2;
        int p = 1;
        while (k < N) {
            p++;
            k = (int) Math.pow(2, p);
        }

        tree = new long[k * 2];

        // 1로 초기화
        for (int i = 0; i < tree.length; i++) {
            tree[i] = 1;
        }

        // 리프노드 생성
        for (int i = 0; i < N; i++) {
            tree[k + i] = Long.parseLong(bf.readLine());
        }

        // 부모노드 생성
        for (int i = k - 1; i > 0; i--) {
            tree[i] = tree[i * 2] * tree[i * 2 + 1] % DIVIDE;
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(bf.readLine());
            int flag = Integer.parseInt(st.nextToken());

            if (flag == 1) {
                int target = Integer.parseInt(st.nextToken()) + k - 1;
                long replace = Long.parseLong(st.nextToken());
                replaceNode(target, replace);
            } else {
                int start = Integer.parseInt(st.nextToken()) + k - 1;
                int end = Integer.parseInt(st.nextToken()) + k - 1;
                printResult(start, end);
            }
        }
    }

    private static void replaceNode(int target, long replace) {
        tree[target] = replace;

        target = target / 2;
        while (target >= 1) {
            tree[target] = tree[target * 2] * tree[target * 2 + 1] % DIVIDE;
            target = target / 2;
        }
    }

    private static void printResult(int start, int end) {
        long result = 1;

        while (start <= end) {
            if (start % 2 == 1) result = result * tree[start] % DIVIDE;
            if (end % 2 == 0) result = result * tree[end] % DIVIDE;

            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }

        System.out.println(result % DIVIDE);
    }
}
