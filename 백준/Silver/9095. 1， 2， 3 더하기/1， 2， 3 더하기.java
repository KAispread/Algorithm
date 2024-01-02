import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;

        for (int t = 0; t < T; t++) {
            answer = 0;
            int number = Integer.parseInt(bf.readLine());
            DFS(0, number);
            System.out.println(answer);
        }
    }

    private static void DFS(int sum, int target) {
        if (sum == target) {
            answer++;
            return;
        }

        if (sum + 1 <= target) DFS(sum + 1, target);
        if (sum + 2 <= target) DFS(sum + 2, target);
        if (sum + 3 <= target) DFS(sum + 3, target);
    }

}

