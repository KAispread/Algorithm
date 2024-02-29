import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static char[] alpha;
    static int min;
    static boolean[][] palindrome;

    // DFS를 사용하여 펠린드롬 수라면 끊고 다음 Index부터 펠린드롬 탐색
    // 펠린드롬 문자가 아니라면 문자열 추가
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        alpha = st.nextToken().toCharArray();
        min = alpha.length;
        palindrome = new boolean[alpha.length][alpha.length];

        for (int i = 0; i < alpha.length; i++) {
            for (int j = i; j < alpha.length; j++) {
                if (isPalindrome(i, j)) palindrome[i][j] = true;
            }
        }

        int[] dp = new int[alpha.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;

        for (int i = 0; i < alpha.length; i++) {
            for (int j = i; j < alpha.length; j++) {
                if (palindrome[i][j]) {
                    if (i == 0) dp[j] = Math.min(dp[j], 1);
                    else dp[j] = Math.min(dp[j], dp[i-1] + 1);
                }
            }
        }

        System.out.println(dp[alpha.length - 1]);
    }

    // 3, 4, 5, 6, 7
    private static boolean isPalindrome(int start, int end) {
        int numberCount = end - start + 1;
        int iterCount = numberCount / 2;

        for (int i = 0; i < iterCount; i++) {
            if (alpha[start + i] != alpha[end - i]) return false;
        }
        return true;
    }
}
