import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 98765_4321;

    /*
    * 1. int[] dp 에 index N 까지 가는데 걸리는 최소 시간을 저장해둠
    * 2. 현재 N 부터 시작해서 N -1, N + 1, N * 2 위치의 시간을 업데이트
    * 3. 업데이트 된 Index를 Queue<>에 담아 탐색
    * 4. 동생을 찾았다면 cost를 저장하고 다음 탐색 시 현재 cost 보다 높다면 break; + counting
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] dp = new int[1000_0001];
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        Arrays.fill(dp, INF);
        dp[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int minimumCount = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (dp[current] >= dp[target]) break;

            int front = current + 1;
            int back = current - 1;
            int multi = current * 2;

            int time = dp[current] + 1;

            if (front < dp.length) {
                if (front == target && dp[target] >= time) {
                    if (dp[target] == time) minimumCount++;
                    else minimumCount = 1;

                    dp[front] = time;
                } else if (dp[front] >= time) {
                    queue.offer(front);
                    dp[front] = dp[current] + 1;
                }
            }

            if (back >= 0) {
                if (back == target && dp[target] >= dp[current] + 1) {
                    if (dp[target] == time) minimumCount++;
                    else minimumCount = 1;
                    dp[back] = dp[current] + 1;
                } else if (dp[back] >= time) {
                    queue.offer(back);
                    dp[back] = dp[current] + 1;
                }
            }

            if (multi < dp.length) {
                if (multi == target && dp[target] >= dp[current] + 1) {
                    if (dp[target] == time) minimumCount++;
                    else minimumCount = 1;
                    dp[multi] = dp[current] + 1;
                } else if (dp[multi] >= time) {
                    queue.offer(multi);
                    dp[multi] = dp[current] + 1;
                }
            }
        }

        System.out.println(dp[target]);
        System.out.println(minimumCount);
    }

}

