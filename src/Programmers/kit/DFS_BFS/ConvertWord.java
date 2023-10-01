package Programmers.kit.DFS_BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LEVEL3 - 단어 변환
public class ConvertWord {

    private int answer = Integer.MAX_VALUE;
    private Map<String, Boolean> visited;
    private Map<String, List<String>> route;

    public int solution(String begin, String target, String[] words) {
        route = new HashMap<>();
        visited = new HashMap<>();

        for (int i = 0; i <= words.length; i++) {
            String pivot;
            if (i >= words.length) {
                pivot = begin;
            } else {
                pivot = words[i];
            }

            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                String comp = words[j];

                // 두 단어가 알파벳 하나 차이라면 DFS 탐색 가능
                if (getDiff(pivot, comp) == 1) {
                    // System.out.println("pivot :: " + pivot + " / comp :: " + comp );
                    List<String> pivotList = route.getOrDefault(pivot, new ArrayList<>());
                    pivotList.add(comp);
                    route.put(pivot, pivotList);
                }
            }
        }

        for (String word : words) {
            visited.put(word, false);
        }

        visited.put(begin, false);
        DFS(begin, target, 0);

        if (answer == Integer.MAX_VALUE) return 0;
        return answer;
    }

    private void DFS(String begin, String target, int count) {
        if (begin.equals(target)) {
            answer = Math.min(count, answer);
            return;
        }

        // 기준 단어와 알파벳 하나 차이나는 단어 목록
        List<String> beginRouteList = route.getOrDefault(begin, null);
        if (beginRouteList == null || beginRouteList.isEmpty()) {
            return;
        }

        for (String convert : beginRouteList) {
            if (!visited.get(convert)) {
                // 같은 단어는 반복해서 탐색하지 않도록 표시
                visited.put(convert, true);
                DFS(convert, target, count + 1);
                visited.put(convert, false);
            }
        }
    }

    private int getDiff(String pivot, String comp) {
        if (pivot.length() != comp.length()) throw new AssertionError();
        int count = 0;

        for (int i = 0; i < pivot.length(); i++) {
            if (pivot.charAt(i) != comp.charAt(i)) {
                count++;
            }
        }

        return count;
    }

}
