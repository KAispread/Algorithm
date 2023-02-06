package Do_it_Algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 구간 합 구하기 3 - 2042번
* - 구간 합 저장을 long 자료형으로 하자
* */
public class Q71SegmentTree {
    static long[] tree;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 배열 초기화
        k = 0;
        int p = 1;
        while (k < N) {
            k = (int) Math.pow(2, p);
            p++;
        }
        tree = new long[k * 2];

        // 리프노드 채우기
        for (int i = 0; i < N; i++) {
            tree[i + k] = Long.parseLong(bf.readLine());
        }

        // 부모노드 채우기
        for (int i = k - 1; i > 0; i--) {
            // 왼쪽 오른쪽 자식 노드의 합
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(bf.readLine());
            int flag = Integer.parseInt(st.nextToken());

            // 변경
            if (flag == 1) {
                int target = Integer.parseInt(st.nextToken()) + k - 1;
                long replace = Long.parseLong(st.nextToken());
                replaceNumber(target, replace);
            } else if (flag == 2) { // 출력
                int start = Integer.parseInt(st.nextToken()) + k - 1;
                int end = Integer.parseInt(st.nextToken()) + k - 1;
                printSum(start, end);
            }
        }
    }

    // 숫자 바꾸기
    private static void replaceNumber(int target, long replace) {
        tree[target] = replace;
        int idx = target / 2;

        while (idx >= 1) {
            tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
            idx = idx / 2;
        }
    }

    // 구간합 출력
    private static void printSum(int start, int end) {
        long result = 0;

        while (start <= end) {
            if (start % 2 == 1) result += tree[start];
            if (end % 2 == 0) result += tree[end];

            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        System.out.println(result);
    }
}
