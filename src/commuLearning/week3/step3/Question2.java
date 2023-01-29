package commuLearning.week3.step3;

import java.util.HashSet;
import java.util.Set;

/*
* 가면 감
* */
public class Question2 {
    private int[] union;
    private boolean[] visited;

    public int solution(int[][] reply) {
        int answer = 0;

        union = new int[reply.length];
        visited = new boolean[reply.length];

        for (int i = 1; i < union.length; i++) {
            union[i] = i;
        }

        for (int i = 1; i < reply.length; i++) {
            for (int r : reply[i]) {

                union(i, r);

            }
        }

        return search();
    }

    private int search() {
        Set<Integer> list = new HashSet<>();

        for (int i = 1; i < union.length; i++) {
            int a = union[i];
            if (!list.contains(a)) {

                list.add(a);
            }
        }

        return list.size();
    }

    private void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A != B) {
            int m = Math.max(A, B);
            int n = Math.min(A, B);
            union[m] = n;
        }
    }

    private int find(int num) {
        if (union[num] == num) {
            return num;
        }
        return union[num] = find(union[num]);
    }
}
