package Do_it_Algorithm;

/* 백준 - 17298 Gold IV
*  STACK 활용
*
*  System.out.print 는 횟수가 많아질수록 성능에 안좋은 영향
*  -> BufferedWriter 에 모아서 한꺼번에 flush
*  -> StringBuilder 에 모아서 출력 하는게 더 빠름
* */

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q012Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int A[] = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i =0; i< N; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                    result[stack.pop()] = A[i];
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int re : result) {
            sb.append(re).append(" ");
        }

        System.out.println(sb);
    }
}
