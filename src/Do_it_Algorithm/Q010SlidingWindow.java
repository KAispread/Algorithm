package Do_it_Algorithm;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
백준 - 11003 Platinum

* *Feat
- Deque 자료형을 활용 LinkedList
- Deque 의 정렬 매커니즘
- Deque 뒤쪽에 값을 추가한다. 삽입할 값이 원래 있던 원소보다 큰 것을 찾는다.
  큰 것이 있으면 제거하고 작은 값을 확인하면 탐색을 멈추고 삽입한다.
- Window 크기를 벗어난 값은 제거한다.
* */
public class Q010SlidingWindow {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        // LinkedList 보다 ArrayDeque 가 더 가벼움
        Deque<Node> deque = new ArrayDeque<>();

        for (int i = 1 ; i < N+1; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.getLast().value >= now) {
                deque.pollLast();
            }
            deque.addLast(new Node(i, now));
            if (!deque.isEmpty() && deque.peek().index <= i - L) {
                deque.poll();
            }
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    // 클래스 필드를 Integer 로 하면 시간초과 발생
     static class Node {
        public final int index;
        public final int value;

        public Node(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }
    }
}
