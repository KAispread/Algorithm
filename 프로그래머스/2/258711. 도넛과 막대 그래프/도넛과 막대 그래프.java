import java.util.*;

class Solution {
    static int[] answer = new int[4];
    static int newNode = 0;
    static int[] fromforces;
    static int[] toforces;
    static List<Integer>[] nodes;
    
    public int[] solution(int[][] edges) {
        nodes = new List[1_000_000];
        
        fromforces = new int[1_000_000];
        toforces = new int[1_000_000];
        
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            
            nodes[from].add(to);
            
            fromforces[from] += 1;
            toforces[to] += 1;
            
            if (fromforces[from] >= 2) queue.add(from);
        }
        
        while (!queue.isEmpty()) {
            int point = queue.poll();
            
            // 새로운 노드 체크
            if (fromforces[point] > 2 || toforces[point] == 0) {
                answer[0] = point;
                newNode = point;
                break;
            }
        }
        
        for (int next : nodes[newNode]) {
            answer[getTypeOfGraph(next, next)] += 1;
        }
        
        return answer;
    }
    
    private int getTypeOfGraph(int start, int current) {
        for (int next : nodes[current]) {
            if (fromforces[next] == 2) return 3;
            if (next == start) return 1;
            
            return getTypeOfGraph(start, next);
        }
        
        return 2;
    }
}