import java.util.*;

class Solution {
    /*
    root node = 0
    8 -> 5 일경우 5와 하위 노드들의 위상 +1
    
    위상이 0인 노드의 하위 노드를 전부 방문하며 위상을 줄여줌
    위상을 줄인 이후 위상이 0이라면 해당 노드도 Queue에 넣음
    
    하나의 노드를 방문할 때마다 count + 1
    방문 count가 노드의 크기와 같다면 true;
    */
    
    private List<Integer>[] nodes;
    private int[] needs;
    private int[] needsBack;
    private int[] save;
    private int[] forces;
    
    public boolean solution(int n, int[][] path, int[][] order) {
        forces = new int[n];
        needs = new int[n];
        save = new int[n];
        needsBack = new int[n];
        
        nodes = new List[n];
        
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        // 경로 설정
        for (int i = 0; i < path.length; i++) {
            int start = path[i][0];
            int end = path[i][1];
            
            nodes[start].add(end);
            nodes[end].add(start);
        }
            
        // 위상 설정
        for (int i = 0; i < order.length; i++) {
            int before = order[i][0];
            int target = order[i][1];
            
            needs[target] = before;
            needsBack[before] = target;
        }
        
        if (needs[0] > 0) return false;
        
        // 0번 노드부터 시작
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        count++;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : nodes[current]) {
                if (visited[next]) continue;
                
                if (!visited[needs[next]]) {
                    save[needs[next]] = next;
                    continue;
                }
                
                queue.offer(next);
                visited[next] = true;
                count++;
                
                if (save[next] != 0 && !visited[save[next]]) {
                    queue.offer(save[next]);
                    visited[save[next]] = true;
                    count++;
                }
            }
        }
        
        return count >= n ? true : false;
    }

}