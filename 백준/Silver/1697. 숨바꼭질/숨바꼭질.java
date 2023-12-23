import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int answer = 100_000;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        findShortestWay(N, K);
        System.out.println(answer);
    }

    private static void findShortestWay(int current, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {current, 0});
        boolean[] visited = new boolean[100_0000];
        visited[current] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int number = poll[0];

            if (number == target) answer = Math.min(answer, poll[1]);

            if (number < 10_0000 && !visited[number + 1]) {
                queue.offer(new int[] {number + 1, poll[1] + 1});
                visited[number + 1] = true;
            }
            if (number > 0 && !visited[number - 1]) {
                queue.offer(new int[] {number - 1, poll[1] + 1});
                visited[number - 1] = true;
            }
            if (number <= 60000 && !visited[number * 2]) {
                queue.offer(new int[] {number * 2, poll[1] + 1});
                visited[number * 2] = true;
            }
        }
    }

}

