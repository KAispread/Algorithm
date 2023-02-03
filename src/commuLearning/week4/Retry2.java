package commuLearning.week4;

import java.util.*;

public class Retry2 {
    // 노드 클래스
    class MapList {
        private Map<String, List<String>> node = new HashMap<>();

        public List<String> get(String key) {
            create(key);
            return node.get(key);
        }

        public void add(String key, String value) {
            create(key);
            node.get(key).add(value);
        }

        private void create(String key) {
            if (!node.containsKey(key)) {
                node.put(key, new ArrayList<>());
            }
        }
    }

    // 진입 차수 클래스
    static class CountMap {
        Map<String, Integer> count = new HashMap<>();

        public Integer get(String key) {
            create(key);
            return count.get(key);
        }

        public void add(String key) {
            count.put(key, count.getOrDefault(key, 0) + 1);
        }

        public void minus(String key) {
            count.put(key, count.get(key) - 1);
        }

        private void create(String key) {
            if (!count.containsKey(key)) {
                count.put(key, 0);
            }
        }
    }

    public String[] solution(String[] s1, String[] s2, String k) {
        MapList node = new MapList();

        for (int i = 0; i < s1.length; i++) {
            node.add(s2[i], s1[i]);
        }

        // 역노드 저장용
        MapList nodeK = new MapList();
        CountMap indegree = new CountMap();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        Queue<String> Pqueue = new PriorityQueue<>();
        queue.offer(k);

        // 역노드 저장 & 진입 차수 기록
        while (!queue.isEmpty()) {
            String t = queue.poll();

            List<String> next = node.get(t);
            if (next.isEmpty()) {
                Pqueue.offer(t);
                continue;
            }

            for (String n : next) {
                indegree.add(t);
                nodeK.add(n, t);

                if (!visited.contains(n)) {
                    visited.add(n);
                    queue.offer(n);
                }
            }
        }

        List<String> answer = new ArrayList<>();

        // 큐를 순회하며 연결된 노드의 진입차수 -1 -> 진입 차수가 0이면 queue에 추가
        while (!Pqueue.isEmpty()) {
            String t = Pqueue.poll();
            answer.add(t);

            List<String> next = nodeK.get(t);
            for (String n : next) {
                indegree.minus(n);
                if (indegree.get(n) == 0) {
                    Pqueue.offer(n);
                }
            }
        }

        return answer.toArray(new String[0]);
    }
}
