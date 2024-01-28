import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] numbers;
    private static int[] sequence;
    private static int M;
    private static boolean[] visited;

    // DFS
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        numbers = new int[N];
        sequence = new int[M];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();
        DFS(0, sb);
        System.out.println(sb);
    }

    private static void DFS(int depth, StringBuilder sb) {
        if (depth == M) {
            for (int i = 0; i < sequence.length; i++) sb.append(sequence[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = numbers[i];
                DFS(depth + 1, sb);
                visited[i] = false;
            }
        }
    }

}

