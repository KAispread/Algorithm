package Do_it_Algorithm;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
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

        Deque<Node> deque = new LinkedList<>();

        for (int i = 1 ; i < N+1; i++) {
            int now = Integer.parseInt(st.nextToken());

            Node nd = new Node(i, now);
            if (i == 1) {
                deque.addLast(nd);
                bw.write(now + " ");
                continue;
            }

            while (!deque.isEmpty() && deque.getLast().value >= now) {
                deque.removeLast();
            }

            if (!deque.isEmpty() && deque.getFirst().getIndex() <= i - L) {
                deque.removeFirst();
            }
            deque.addLast(nd);
            bw.write(deque.getFirst().getValue() + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        private final Integer index;
        private final Integer value;

        public Node(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }

        public Integer getIndex() {
            return index;
        }

        public Integer getValue() {
            return value;
        }
    }
}
