import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* Gold IV - 1717번 - 집합 표현하기
* */
public class Main {
    static int[] unionFind;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        unionFind = new int[n + 1];
        for (int i = 1; i < unionFind.length; i++) {
            unionFind[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (flag == 0) {
                unionFind[find(A)] = find(B);
            } else {
                if (find(A) == find(B)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static int find(int num) {
        if (unionFind[num] != num) {
            int root = find(unionFind[num]);
            unionFind[num] = root;
        }
        return unionFind[num];
    }
}
