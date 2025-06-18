package data_structure;

import java.util.Arrays;

public class HashMap<K, V> {

    private static final int CAPACITY = 10;
    private static final float LOAD_FACTOR = 0.75f;

    private Node<K, V>[] hashBucket;
    private int currentCapacity;
    private int currentSize;

    public HashMap() {
        this.hashBucket = new Node[CAPACITY];
        this.currentSize = 0;
        this.currentCapacity = CAPACITY;
    }

    public void put(K key, V value) {
        Node<K, V> node = Node.of(key, value);
        int index = getIndex(key);

        addNodeToBucket(index, node);
    }

    public void delete(K key) {
        int index = getIndex(key);

        Node<K, V> node = findNodeFromKey(index, key);

        if (node != null) {
            Node<K, V> nextNode = node.getNextNode();
            Node<K, V> prevNode = node.getPrevNode();

            if (prevNode != null) {
                prevNode.setNextNode(nextNode);
            }
            if (nextNode != null) {
                nextNode.setPrevNode(prevNode);
            }

            if (hashBucket[index] == node) {
                hashBucket[index] = nextNode;

                if (nextNode == null) {
                    currentSize--;
                }
            }
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = findNodeFromKey(index, key);

        if (node == null) {
            return null;
        }

        return node.getValue();
    }

    private Node<K, V> findNodeFromKey(int index, K key) {
        Node<K, V> node = hashBucket[index];
        if (node == null) {
            return node;
        }
        while (node != null && !node.getKey().equals(key)) {
            node = node.getNextNode();
        }
        return node;
    }

    private void addNodeToBucket(int index, Node<K, V> node) {
        if (hashBucket[index] == null) {
            hashBucket[index] = node;
            currentSize++;

            double loadFactor = (double) currentSize / currentCapacity;
            if (loadFactor > LOAD_FACTOR) {
                rearrangeHashBucket(currentCapacity * 2);
            }
            return;
        }

        Node<K, V> currentNode = hashBucket[index];
        if (currentNode.getKey().equals(node.getKey())) {
            currentNode.updateValue(node.getValue());
            return;
        }

        while (currentNode.hasNext()) {
            currentNode = currentNode.getNextNode();

            if (currentNode.getKey().equals(node.getKey())) {
                currentNode.updateValue(node.getValue());
                return;
            }
        }

        currentNode.setNextNode(node);
        node.setPrevNode(currentNode);
    }

    private void rearrangeHashBucket(int capacity) {
        System.out.println("rearranged hashBucket to : " + capacity);
        Node<K, V>[] beforeHashBucket = Arrays.copyOf(hashBucket, hashBucket.length);

        this.hashBucket = new Node[capacity];
        this.currentCapacity = capacity;
        this.currentSize = 0;

        for (Node<K, V> beforeNode : beforeHashBucket) {
            if (beforeNode == null) {
                continue;
            }

            Node<K, V> current = beforeNode;
            do {
                K key = current.getKey();
                int index = getIndex(key);

                addNodeToBucket(index, beforeNode);
            } while ((current = current.getNextNode()) != null);
        }
    }

    private int getIndex(K key) {
        return key.hashCode() % currentCapacity;
    }

    /*
    * for test
    * */
    public void print() {
        System.out.println("---- info ----");
        System.out.println("bucket length : " + hashBucket.length);
        System.out.println("capacity : " + currentCapacity);
        System.out.println("size : " + currentSize);
        System.out.println();

        System.out.println("---- data ----");
        for (int i = 0; i < hashBucket.length; i++) {
            Node<K, V> kvNode = hashBucket[i];
            while (kvNode != null) {
                System.out.println("index = %s / Key = %s / Value = %s".formatted(i, kvNode.getKey(), kvNode.getValue()));
                kvNode = kvNode.getNextNode();
            }
        }
    }

    static class Node<K, V> {

        private Node<K, V> nextNode;
        private Node<K, V> prevNode;

        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public static <K, V> Node<K, V> of(K key, V value) {
            return new Node<>(key, value);
        }

        public void updateValue(V value) {
            this.value = value;
        }

        public void setNextNode(Node<K, V> nextNode) {
            this.nextNode = nextNode;
        }

        public void setPrevNode(Node<K, V> prevNode) {
            this.prevNode = prevNode;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public Node<K, V> getNextNode() {
            return nextNode;
        }

        public Node<K, V> getPrevNode() {
            return prevNode;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> stringHashMap = new HashMap<>();

        stringHashMap.put("a", 1);
        stringHashMap.put("b", 2);
        stringHashMap.put("c", 3);
        stringHashMap.put("d", 4);
        stringHashMap.put("e", 5);

        stringHashMap.put("f", 6);
        stringHashMap.put("g", 7);
        stringHashMap.put("h", 8);
        stringHashMap.put("i", 9);
        stringHashMap.put("j", 10);
        stringHashMap.put("k", 11);

        stringHashMap.put("a", 11);
        stringHashMap.put("k", 101);

        stringHashMap.delete("k");
        stringHashMap.delete("a");
        stringHashMap.delete("c");

        stringHashMap.print();

        System.out.println();
        System.out.println(stringHashMap.get("j"));
        System.out.println(stringHashMap.get("k"));
        System.out.println(stringHashMap.get("d"));
    }
}
