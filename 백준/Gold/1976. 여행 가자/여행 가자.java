import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* Gold VI - 1976번 - 여행 가자
* */
public class Main {
    static int[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        graph = new int[N + 1];

        for (int i = 1; i < graph.length; i++) {
            graph[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    int a = find(Math.max(i, j));
                    int b = find(Math.min(i, j));
                    if (a != b) {
                        graph[a] = b;    
                    }
                }
            }
        }
        int[] route = new int[M];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        int root = find(route[0]);
        for (int r : route) {
            if (root != find(r)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static int find(int num) {
        if (graph[num] == num) {
            return num;
        } 
        return graph[num] = find(graph[num]);
    }
}
