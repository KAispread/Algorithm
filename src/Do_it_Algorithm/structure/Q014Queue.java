package Do_it_Algorithm.structure;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/* public PriorityQueue(Comparator<? super E> comparator)
*  ===>> PriorityQueue 는 함수형 인터페이스를 람다식으로 재정의 함으로써
*        정렬 순서를 직접 지정할 수 있음
*
* ==> compare(T o1, T o2) -> 뒤에 오는 인자를 기준으로 양수면 우선순위가 더 높음
* */
public class Q014Queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new PriorityQueue<>((o1, o2) -> {
            int q1 = Math.abs(o1);
            int q2 = Math.abs(o2);
            if (q1 == q2) {
                return o1 > o2 ? 1 : -1;
            }
            else return q1 - q2;
        });
        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (input == 0) {
                if (que.isEmpty()) sb.append(0).append("\n");
                else sb.append(que.poll()).append("\n");
            } else {
                que.add(input);
            }
        }

        System.out.println(sb);
        sc.close();
    }
}
