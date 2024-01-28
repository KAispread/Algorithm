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

    static int[] numbers;
    static int[] sequence;
    static int M;
    static LinkedHashSet<String> set;

    // DFS
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new LinkedHashSet<>();
        numbers = new int[N];
        sequence = new int[M];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers[i] = number;
        }

        Arrays.sort(numbers);

        DFS(0, 0);
        StringBuilder sb = new StringBuilder();

        for (String str : set) {
            StringTokenizer token = new StringTokenizer(str, "-");

            while (token.hasMoreTokens()) {
                sb.append(token.nextToken()).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void DFS(int depth, int start) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int n : sequence) {
                sb.append(n).append("-");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            sequence[depth] = numbers[i];
            DFS(depth + 1, i);
        }
    }
}

