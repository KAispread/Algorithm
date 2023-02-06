package Do_it_Algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 1991 - 트리 순회하기
* */
public class Q70Retry {
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        tree = new int[26][2];

        // -1 이면 자식이 없는 것
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < 2; j++) {
                tree[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int idx = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';

            if (left >= 0 && left <= 'Z' - 'A') {
                tree[idx][0] = left;
            }
            if (right >= 0 && right <= 'Z' - 'A') {
                tree[idx][1] = right;
            }
        }

        StringBuilder forward  = new StringBuilder();
        StringBuilder middle  = new StringBuilder();
        StringBuilder last  = new StringBuilder();

        forward(forward, 0);
        middle(middle, 0);
        last(last, 0);

        System.out.println(forward);
        System.out.println(middle);
        System.out.println(last);
    }

    private static void forward(StringBuilder builder, int idx) {
        if (idx == -1) return;

        char alpha = (char) (idx + 'A');
        builder.append(alpha);
        forward(builder, tree[idx][0]);
        forward(builder, tree[idx][1]);
    }

    private static void middle(StringBuilder builder, int idx) {
        if (idx == -1) return;

        char alpha = (char) (idx + 'A');
        middle(builder, tree[idx][0]);
        builder.append(alpha);
        middle(builder, tree[idx][1]);
    }

    private static void last(StringBuilder builder, int idx) {
        if (idx == -1) return;

        char alpha = (char) (idx + 'A');
        last(builder, tree[idx][0]);
        last(builder, tree[idx][1]);
        builder.append(alpha);
    }
}
