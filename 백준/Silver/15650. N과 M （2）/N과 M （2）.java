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

    static StringBuilder sb;
    static int N;
    static int length;

    // DFS
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        dfs(1, new ArrayList<>());
        System.out.println(sb.toString());
    }

    private static void dfs(int start, List<Integer> numbers) {
        if (numbers.size() == length) {
            for (int number : numbers) sb.append(number).append(" ");
            sb.append("\n");
            return;
        }

        for (Integer i = start; i <= N; i++) {
            numbers.add(i);
            dfs(i + 1, numbers);
            numbers.remove(i);
        }
    }
}

