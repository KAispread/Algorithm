package commuLearning.week4;

import java.util.*;

/*
* 선수과목 -> 91점
* */
public class Question2 {
    Map<String, Node> connect = new HashMap<>();

    public  String[] solution(String[] s1, String[] s2, String k) {
        for (int i = 0; i < s1.length; i++) {
            connect.put(s1[i], connect.getOrDefault(s1[i], new Node(s1[i])));
            connect.put(s2[i], connect.getOrDefault(s2[i], new Node(s2[i])));
            Node n2 = connect.get(s2[i]);
            Node n1 = connect.get(s1[i]);
            n2.addInOrder(n1);
            n1.reverseOrder.add(n2);
        }

        Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(o -> o.name));

        Node node = connect.get(k);
        List<String> answer = new ArrayList<>();
        Set<String> require = addLeafNode(queue, node);
        require.add(k);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            answer.add(n.name);

            if (n.name.equals(k)) break;

            for (Node transfer : n.reverseOrder) {
                Node t = connect.get(transfer.name);
                t.count -= 1;

                if (t.count <= 0 && require.contains(t.name)) {
                    require.remove(t.name);
                    queue.offer(t);
                }
            }
        }

        return answer.toArray(new String[0]);
    }

    private Set<String> addLeafNode(Queue<Node> queue, Node node) {
        Queue<Node> buffer = new LinkedList<>();
        Set<String> require = new HashSet<>();

        for (Node node1 : node.inOrder) {
            buffer.offer(node1);
        }

        while (!buffer.isEmpty()) {
            Node n = buffer.poll();
            if (n.count == 0 && !require.contains(n.name)) {
                queue.offer(n);
                require.add(n.name);
                continue;
            }
            require.add(n.name);

            for (Node next : n.inOrder) {
                buffer.offer(next);
            }
        }

        return require;
    }

    class Node {
        String name;
        List<Node> inOrder = new ArrayList<>();
        List<Node> reverseOrder = new ArrayList<>();
        int count = 0;

        public Node(String name) {
            this.name = name;
        }

        public void addInOrder(Node n) {
            inOrder.add(n);
            count++;
        }
    }
}
