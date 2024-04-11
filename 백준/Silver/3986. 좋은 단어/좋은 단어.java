import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    // Stack의 size가 2보다 크면서 스택의 가장 위에 있는 문자가 현재 문자와 일치하지 않을 때 NO
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int number = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < number; i++) {
            char[] chars = bf.readLine().toCharArray();
            ArrayDeque<Character> deque = new ArrayDeque<>();

            for (int j = 0; j < chars.length; j++) {
                char current = chars[j];

                if (!deque.isEmpty() && deque.peekLast() == current) {
                    deque.pollLast();
                } else  {
                    deque.offerLast(current);
                }
            }

            if (deque.isEmpty()) count++;
        }

        System.out.println(count);
    }
}
