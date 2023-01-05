package Do_it_Algorithm.graph;

import java.util.*;

/*
* Gold II - 2252번
* 줄 세우기
* - 자신을 가리키는 엣지 개수인 depth[] 배열 선언
* - queue 에 엣지 개수가 0인 것을 모두 넣어놓고 depth를 제거
* */
public class Q53TopologySort {
    static List<Integer>[] node;
    static int[] depth;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        node = new ArrayList[N + 1];
        depth = new int[N + 1];

        for (int i = 1; i < node.length; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            node[A].add(B);
            depth[B]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < depth.length; i++) {
            if (depth[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
           int now = queue.poll();
            System.out.println(now + " ");
            for (int next : node[now]) {
                depth[next]--;
                if (depth[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
