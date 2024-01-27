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

    static int[] sequence;
    static int N;
    static int LENGTH;

    // DFS
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        LENGTH = Integer.parseInt(st.nextToken());
        sequence = new int[LENGTH];
        StringBuilder sb = new StringBuilder();

        DFS(1, 0, sb);
        System.out.println(sb);
    }

    private static void DFS(int start, int depth, StringBuilder sb) {
        if (depth == LENGTH) {
            for (int number: sequence) sb.append(number).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            sequence[depth] = i;
            DFS(i, depth + 1, sb);
        }
    }
}

