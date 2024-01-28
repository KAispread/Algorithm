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

    static int[] numbers;
    static int[] sequence;
    static int M;

    // DFS
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sequence = new int[M];
        numbers = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();
        DFS(0, 0, sb);
        System.out.println(sb);
    }

    private static void DFS(int depth, int start, StringBuilder sb) {
        if (depth == M) {
            for (int num : sequence) sb.append(num).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            sequence[depth] = numbers[i];
            DFS(depth + 1, i, sb);
        }
    }

}

