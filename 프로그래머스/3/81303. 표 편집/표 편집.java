import java.util.*;

class Solution {
    
    private static final char UP = 'U';
    private static final char DOWN = 'D';
    private static final char REMOVE = 'C';
    private static final char RESTORE = 'Z';
    
    public String solution(int n, int k, String[] cmd) {
        Stack<Node> remember = new Stack<>();
        Node[] nodes = new Node[n];
        
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        
            if (i == 0) continue;
            
            nodes[i - 1].next = nodes[i];
            nodes[i].prev = nodes[i - 1];
        }
        
        Node current = nodes[k];
        for (String command : cmd) {
            char flag = command.charAt(0);
            int count = 0;
            
            switch(flag) {
                case UP:
                    count = Integer.parseInt(command.split(" ")[1]);
                    current = current.movePrev(count);
                    break;
                case DOWN:
                    count = Integer.parseInt(command.split(" ")[1]);
                    current = current.moveNext(count);
                    break;
                case REMOVE:
                    remember.push(current);
                    current = current.remove();
                    break;
                case RESTORE:
                    remember.pop().restore();
                    break;
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for (Node node : nodes) {
            if (node.isRemoved) {
                answer.append("X");
                continue;
            }
            answer.append("O");
        }
        
        return answer.toString();
    }
    
    public class Node {
        Node prev;
        Node next;
        boolean isRemoved = false;
        
        public Node() {
        }
        
        public Node movePrev(int count) {
            Node n = this;
            
            for (int i = 0; i < count; i++) {
                if (n.prev == null) {
                    return n;
                }
                n = n.prev;
            }
            
            return n;
        }
        
        public Node moveNext(int count) {
            Node n = this;
            
            for (int i = 0; i < count; i++) {
                if (n.next == null) {
                    return n;
                }
                n = n.next;
            }
            
            return n;
        }
        
        public Node remove() {
            this.isRemoved = true;
            
            if (this.prev != null) {
                this.prev.next = next;
            }
            
            if (this.next != null) {
                this.next.prev = prev;
                return this.next;
            }
            
            return this.prev;
        }
        
        public void restore() {
            this.isRemoved = false;
            
            if (this.prev != null) {
                this.prev.next = this;
            }
            
            if (this.next != null) {
                this.next.prev = this;
            }
        }
    }
}
