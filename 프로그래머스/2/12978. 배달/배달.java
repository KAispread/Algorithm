import java.util.*;

class Solution {
    // 다익스트라 알고리즘 -> 순회하며 k 이하인 것만 카운트
    
    static class Node {
        int index;
        int cost;
        
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
    
    private List<Node>[] nodes;
    private boolean[] visited;
    
    public int solution(int N, int[][] road, int K) {
        nodes = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            int spotA = r[0];
            int spotB = r[1];
            int cost = r[2];
            
            nodes[spotA].add(new Node(spotB, cost));
            nodes[spotB].add(new Node(spotA, cost));
        }
        
        int[] minimum = dijkstra(1, N);
        int answer = 0;
        
        for (int m : minimum) {
            if (m <= K) answer++;
        }

        return answer;
    }
    
    private int[] dijkstra(int pivot, int N) {
        visited = new boolean[N + 1];
        int[] minimum = new int[N + 1];
        Arrays.fill(minimum, 500_000 * 100);
        
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        queue.offer(new Node(1, 0));
        minimum[1] = 0;
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (!visited[current.index]) {
                visited[current.index] = true;
                
                for (Node node : nodes[current.index]) {
                    int cost = current.cost + node.cost;
                    
                    if (!visited[node.index] && minimum[node.index] > cost) {
                        minimum[node.index] = cost;
                        queue.offer(new Node(node.index, cost));
                    }
                }
            }
        }
        
        return minimum;
    }
}