import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            System.out.println(BFS(A, B));
        }
    }

    private static String BFS(int A, int B) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[10_000];
        String[] command = new String[10_000];
        queue.offer(A);
        visited[A] = true;
        Arrays.fill(command, "");

        while (!queue.isEmpty() && !visited[B]) {
            int current = queue.poll();

            int D = (2*current)%10000;
            int S = (current == 0) ? 9999 : current-1;
            int L = (current % 1000) * 10 + current/1000;
            int R = (current % 10) * 1000 + current/10;

            if (!visited[D]) {
                queue.offer(D);
                visited[D] = true;
                command[D] += command[current] + "D";
            }
            if (!visited[S]) {
                queue.offer(S);
                visited[S] = true;
                command[S] += command[current] + "S";
            }
            if (!visited[L]) {
                queue.offer(L);
                visited[L] = true;
                command[L] += command[current] + "L";
            }
            if (!visited[R]) {
                queue.offer(R);
                visited[R] = true;
                command[R] += command[current] + "R";
            }
        }

        return command[B];
    }

    private static int left(int number) {
        int numberLength = String.valueOf(number).length();
        if (numberLength == 1) return number;

        int operator = 1;
        for (int i = 1; i < numberLength; i++) {
            operator *= 10;
        }

        return number % operator * 10 + number / operator;
    }

    private static int right(int number) {
        int numberLength = String.valueOf(number).length();
        if (numberLength == 1) return number;

        int operator = 1;
        for (int i = 1; i < numberLength; i++) {
            operator *= 10;
        }

        return number / 10 + (number % 10) * operator;
    }
}

