package data_structure;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, Node> nodeMap;
    private final Node head;
    private final Node tail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.nodeMap = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    /*
    * insert
    * */
    public void add(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            Node node = new Node(key, value);
            insertToFront(node);
            nodeMap.put(node.key, node);

            if (capacity < nodeMap.size()) {
                removeLRU();
            }
        }
    }

    private void moveToFront(Node node) {
        cutChain(node);
        insertToFront(node);
    }

    private void insertToFront(Node node) {
        Node next = head.next;
        next.prev = node;
        head.next = node;
    }

    private void cutChain(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void removeLRU() {
        Node last = tail.prev;
        Node prev = last.prev;
        prev.next = tail;
        tail.prev = prev;
        nodeMap.remove(last.key);
    }

    /*
    * get
    * */
    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        Node node = nodeMap.get(key);
        moveToFront(node);
        return node.value;
    }

    /*
    * delete
    * */
    public void evict(int key) {
        if (!nodeMap.containsKey(key)) {
            return;
        }
        Node node = nodeMap.get(key);
        cutChain(node);
        nodeMap.remove(key);
    }

    /*
    * for test
    * */
    public void print() {
        System.out.println("size : " + nodeMap.size());
        for (Map.Entry<Integer, Node> node : nodeMap.entrySet()) {
            System.out.println("key : %s, value : %s".formatted(node.getKey(), node.getValue().value));
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.add(1, 10);
        lruCache.add(2, 11);
        lruCache.add(3, 8);
        lruCache.print();

        lruCache.add(5, 11);
        lruCache.print();

        lruCache.add(2, 14);
        lruCache.print();

        lruCache.get(3);
        lruCache.add(7, 99);
        lruCache.print();
    }
}
