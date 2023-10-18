import java.util.*;

// Union & Find
class Solution {
    
    private boolean[] visited;
    List<Integer> answer = new ArrayList<>();
    
    public int solution(int[] cards) {
        visited = new boolean[cards.length];
        
        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int s = search(i, 1, cards);
                answer.add(s);
            }
        }
        
        if (answer.size() == 1) return 0;
        answer.sort(Comparator.reverseOrder());
        return answer.get(0) * answer.get(1);
    }
    
    public int search(int n, int num, int[] cards) {
        int next = cards[n] - 1;
        if (!visited[next]) {
            num += 1;
            visited[next] = true;
            return search(next, num, cards);
        }
        return num;
    }
}