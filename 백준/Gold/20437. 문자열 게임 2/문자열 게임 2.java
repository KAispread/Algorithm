import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int min = Integer.MAX_VALUE;
            int max = -1;

            char[] cArr = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                sb.append("1 1\n");
                continue;
            }
            int[] arr = new int[26];

            // K 이상인 문자 저장
            for (char c : cArr) {
                arr[c - 'a'] += 1;
            }

            // 하나씩 탐색
            for (int j = 0; j < cArr.length; j++) {
                if (arr[cArr[j] - 'a'] < K) {
                    continue;
                }

                int count = 1;
                for (int p = j+1; p < cArr.length; p++) {
                    if (cArr[j] == cArr[p]) count++;

                    if (count == K) {
                        min = Math.min(min, p - j + 1);
                        max = Math.max(max, p - j + 1);
                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE) sb.append("-1\n");
            else sb.append(min + " " + max + "\n");
        }
        System.out.println(sb);
    }

}
