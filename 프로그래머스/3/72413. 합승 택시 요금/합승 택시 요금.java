import java.util.*;

class Solution {
    
    static class Node {
        int index;
        int length;
        
        public Node(int index, int length) {
            this.index = index;
            this.length = length;
        }
    }
    
    private List<Node>[] nodes;
    private boolean[] visited;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        nodes = new List[n + 1];
        
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();    
        }
        
        // 노드 생성
        for (int[] fare : fares) {
            int spotA = fare[0];
            int spotB = fare[1];
            int length = fare[2];
            
            nodes[spotA].add(new Node(spotB, length));
            nodes[spotB].add(new Node(spotA, length));
        }
        
        // A에서 모든 노드로의 최단 거리 구함
        int[] diikstraA = diikstra(a, n);
        
        // B에서 모든 노드로의 최단 거리 구함
        int[] diikstraB = diikstra(b, n);
        
        // S에서 모든 노드로의 최단 거리 구함
        int[] diikstraS = diikstra(s, n);
        
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, diikstraA[i] + diikstraB[i] + diikstraS[i]);
        }
        
        return answer;
    }
    
    private int[] diikstra(int pivot, int n) {
        visited = new boolean[n + 1];
        int[] minimum = new int[n + 1];
        Arrays.fill(minimum, 100_000 * 200 + 1);
        
        minimum[pivot] = 0;
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.length - o2.length);
        queue.offer(new Node(pivot, 0));
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (minimum[current.index] >= current.length) {        
                
                for (Node node : nodes[current.index]) {
                    int cost = current.length + node.length;
                    if (minimum[node.index] > cost) {
                        minimum[node.index] = cost;
                        queue.offer(new Node(node.index, cost));
                    }
                }
            }
        }
        
        return minimum;
    } 
}


