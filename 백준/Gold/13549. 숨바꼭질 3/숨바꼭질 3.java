import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Route {
        int index;
        int time;

        public Route(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

    static int MAX = 150_001;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());


        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            MAX = N + 1;
        } else {
            int temp =  K + K - N;
            if (temp < 50000) MAX = K + temp;
        }

        int[] dp = new int[MAX];

        Arrays.fill(dp, INF);
        dp[N] = 0;
        Queue<Route> queue = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        queue.offer(new Route(N, 0));

        while (!queue.isEmpty()) {
            Route current = queue.poll();
            if (current.index == K) {
                System.out.println(current.time);
                return;
            }

            int currentTime = current.time;
            int currentIndex = current.index;

            if (currentIndex * 2 < dp.length && dp[currentIndex * 2] > currentTime) {
                queue.offer(new Route(currentIndex * 2, currentTime));
                dp[currentIndex * 2] = currentTime;
            }

            if (currentIndex > 0 && dp[currentIndex - 1] > currentTime + 1)  {
                queue.offer(new Route(currentIndex - 1, currentTime + 1));
                dp[currentIndex - 1] = currentTime + 1;
            }

            if (currentIndex < dp.length - 1 && dp[currentIndex + 1] > currentTime + 1)  {
                queue.offer(new Route(currentIndex + 1, currentTime + 1));
                dp[currentIndex + 1] = currentTime + 1;
            }
        }
    }

}

