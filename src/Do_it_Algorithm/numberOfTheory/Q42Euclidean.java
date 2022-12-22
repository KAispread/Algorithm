package Do_it_Algorithm.numberOfTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 1934번 - 최소 공배수 구하기
* */
public class Q42Euclidean {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(getMinMulti(a, b));
        }
    }

    // 유클리드 호제법
    private static int getMinMulti(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        while (max % min != 0) {
            int temp = max;
            max = min;
            min = temp % min;
        }
        return a * b / min;
    }
}
