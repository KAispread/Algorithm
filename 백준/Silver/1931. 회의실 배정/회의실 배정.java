import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 1931번 - Silver II
* */
public class Main {
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
            if (o1.getEnd() == o2.getEnd()) {
                return o1.getStart() - o2.getStart();
            }

            return o1.getEnd() - o2.getEnd();
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
