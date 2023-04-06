package Do_it_Algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q72Segment_Retry {
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int k = 2;
        int p = 1;

        while (k < N) {
            p++;
            k = (int) Math.pow(2, p);
        }

        tree = new int[k * 2];

        // 리프노드 채우기
        for (int i = 0; i < N; i++) {
            tree[k + i] = Integer.parseInt(bf.readLine());
        }

        // 부모 노드 채우기
        for (int i = k - 1; i >= 1; i--) {
            int parent = Math.min(tree[i * 2], tree[i * 2 + 1]);

            if (parent == 0) {
                parent = Math.max(tree[i * 2], tree[i * 2 + 1]);
            }
            tree[i] = parent;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken()) + k - 1;
            int end = Integer.parseInt(st.nextToken()) + k - 1;

            builder.append(getMinInRange(start, end)).append("\n");
        }
        System.out.println(builder);
    }

    private static int getMinInRange(int start, int end) {
        int answer = Integer.MAX_VALUE;

        while (start <= end) {
            if (start % 2 == 1) answer = Math.min(tree[start], answer);
            if (end % 2 == 0) answer = Math.min(tree[end], answer);
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        return answer;
    }
}
