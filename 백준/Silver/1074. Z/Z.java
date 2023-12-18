import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int size = 1;
        for (int i = 0; i < N; i++) {
            size *= 2;
        }

        System.out.println(calcZ(size, x, y, 0));
    }

    private static int calcZ(int size, int x, int y, int start) {
        if (size == 1) return start;

        int end = size * size + start;
        int partArea = (end - start) / 4;

        // 1사분면
        if (size / 2 > x && size / 2 > y) {
            return calcZ(size / 2, x, y, start);

            // 2사분면
        } else if (size / 2 <= x && size / 2 > y ) {
            return calcZ(size / 2, x - size / 2, y, start + partArea * 1);

            // 3사분면
        } else if (size / 2 > x && size / 2 <= y) {
            return calcZ(size / 2, x, y - size / 2, start + partArea * 2);

            // 4사분면
        } else {
            return calcZ(size / 2, x - size / 2, y - size / 2, start + partArea * 3);
        }
    }
}

