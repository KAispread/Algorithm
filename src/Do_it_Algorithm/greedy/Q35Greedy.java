package Do_it_Algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 1931번 - Silver II
* 핵심 로직
* - 종료시간이 빠른 것이 우선
* - 종료시간이 같을 경우 > 시작 시간이 빠른 순서대로
* */
public class Q35Greedy {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        Stack<Meet> stack = new Stack<>();
        List<Meet> meets = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            Meet meet = new Meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            meets.add(meet);
        }
        meets.sort((o1, o2) -> {
            if (o1.getEnd() != o2.getEnd()) {
                return o1.getEnd() - o2.getEnd();
            }

            if (o2.getEnd() == o2.getStart()) {
                return 1;
            } else {
                return o2.getStart() - o1.getStart();
            }
        });
        stack.add(meets.get(0));
        for (int i = 1; i < N; i++) {
            Meet peek = stack.peek();
            int end = peek.getEnd();
            if (meets.get(i).getStart() >= end) {
                stack.push(meets.get(i));
            }
        }

        System.out.println(stack.size());
    }

    static class Meet{
        private int start;
        private int end;

        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
