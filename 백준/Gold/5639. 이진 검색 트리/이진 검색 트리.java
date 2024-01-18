import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        Node parent;
        Node left;
        Node right;
        int number;

        public Node(Node parent, int number) {
            this.parent = parent;
            this.number = number;
        }

        public void addLeft(Node left) {
            this.left = left;
        }

        public void addRight(Node right) {
            this.right = right;
        }
    }

    static Node root;

    // 전위 순회로 Node를 만듦
    // 후위 순회로 출력
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        root = new Node(null, Integer.parseInt(bf.readLine()));

        String input;
        while (true) {
            input = bf.readLine();
            if (input == null || input.equals(""))
                break;

            int next = Integer.parseInt(input);
            addNode(root, next);
        }

        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        System.out.println(sb);
    }

    private static void postOrder(Node node, StringBuilder sb) {
        if (node == null) return;

        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.number).append("\n");
    }

    private static void addNode(Node node, int number) {
        if (node.number < number) {
            if (node.right == null) {
                node.addRight(new Node(node, number));
            } else addNode(node.right, number);
        } else if (node.number > number) {
            if (node.left == null) {
                node.addLeft(new Node(node, number));
            } else addNode(node.left, number);
        }
    }
}

