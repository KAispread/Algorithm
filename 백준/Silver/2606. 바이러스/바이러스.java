import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int comNum = Integer.parseInt(br.readLine());
        int connectNum = Integer.parseInt(br.readLine());

        List<Integer>[] connect = new List[comNum + 1];
        for (int i = 1; i < connect.length; i++) {
            connect[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < connectNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            connect[a].add(b);
            connect[b].add(a);
        }

        boolean[] visited = new boolean[comNum + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int answer = 0;
        
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int n : connect[current]) {
                if (!visited[n]) {
                    visited[n] = true;
                    answer++;
                    queue.offer(n);
                } 
            }
        }
        
        System.out.println(answer);
    }

}
