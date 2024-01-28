import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static Set<String> set;
    static int[] numbers;
    static int[] sequence;
    static boolean[] visited;
    static int M;

    // DFS
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        sequence = new int[M];
        visited = new boolean[N];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        DFS(0);
        StringBuilder sb = new StringBuilder();
        for (String str : set) {
            st = new StringTokenizer(str, "-");

            while (st.hasMoreTokens()) {
                sb.append(st.nextToken()).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void DFS(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sequence.length; i++) {
                sb.append(sequence[i]).append("-");
            }

            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = numbers[i];
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
}

