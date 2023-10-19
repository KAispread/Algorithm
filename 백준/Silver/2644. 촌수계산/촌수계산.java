import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* BFS로 시작점으로부터 계속 탐색
* 탐색하며 Depth가 깊어질수록 1을 더함
* Queue에서 poll했을 때 원하는 상대방이 나오면 그 때의 Depth를 출력
* */
public class Main {

    private static List<Integer>[] node;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int peopleCount = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int targetA = Integer.parseInt(st.nextToken());
        int targetB = Integer.parseInt(st.nextToken());

        int relationCount = Integer.parseInt(bf.readLine());
        
        visited = new boolean[peopleCount + 1]; 
        node = new List[peopleCount + 1];
        
        for (int i = 1; i < node.length; i++) {
            node[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < relationCount; i++) {
            st = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            
            node[parent].add(child);
            node[child].add(parent);
        }
        
        System.out.println(BFS(targetA, targetB));
    }
    
    private static int BFS(int start, int target) {
        int answer = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, 0});
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curr = current[0];
            int weight = current[1];
            
            for (int next : node[curr]) {
                if (!visited[next]) {
                    if (next == target) return weight + 1;
                    
                    queue.offer(new int[] {next, weight + 1});
                    visited[next] = true;
                }
            }
        }
        
        return answer;
    }
}
