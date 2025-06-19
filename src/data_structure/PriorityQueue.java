package data_structure;

import java.util.Arrays;
import java.util.Comparator;

public class PriorityQueue<V> {

    private static final int DEFAULT_CAPACITY = 10;

    private final Comparator<V> priorityComparator;

    private Node<V>[] buffer;
    private int size;

    public PriorityQueue(Comparator<V> comparator) {
        this.priorityComparator = comparator;
        this.buffer = new Node[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /*
    * insert
    * */
    public void offer(V value) {
        int index = size;
        buffer[index] = new Node<>(value);

        V parent = getParent(index);
        while (parent != null) {
            if (isBiggerOrEqual(parent, value)) {
                break;
            }

            swap(index, getParentIndex(index));
            index = getParentIndex(index);
            parent = getParent(index);
        }

        size++;
        if (size >= buffer.length) {
            buffer = Arrays.copyOf(buffer, size * 2);
        }
    }

    private void swap(int indexA, int indexB) {
        Node temp = buffer[indexB];
        buffer[indexB] = buffer[indexA];
        buffer[indexA] = temp;
    }

    /*
    * peek
    * */
    public V peek() {
        return buffer[0].getValue();
    }

    /*
    * delete
    * */
    public V pop() {
        V targetValue = buffer[0].getValue();

        if (size == 1) {
            size = 0;
            return targetValue;
        }

        buffer[0] = buffer[size - 1];
        buffer[size - 1] = null;

        int currentIndex = 0;
        Node<V> currentNode = buffer[0];

        heapify(currentNode, currentIndex);

        size--;
        return targetValue;
    }

    private void heapify(Node<V> currentNode, int currentIndex) {
        while (currentNode != null) {
            V left = getLeft(currentIndex);
            V right = getRight(currentIndex);
            V currentValue = currentNode.getValue();

            if (left == null && right == null) {
                break;
            }
            if (right == null) {
                if (isSmaller(currentValue, left)) {
                    swap(currentIndex, getLeftIndex(currentIndex));
                }
                break;
            }
            if (isBiggerOrEqual(currentValue, left) && isBiggerOrEqual(currentValue, right)) {
                break;
            }

            if (isBigger(left, right)) {
                swap(currentIndex, getLeftIndex(currentIndex));
                currentIndex = getLeftIndex(currentIndex);
                currentNode = buffer[currentIndex];
            } else if (isSmaller(left, right)) {
                swap(currentIndex, getRightIndex(currentIndex));
                currentIndex = getRightIndex(currentIndex);
                currentNode = buffer[currentIndex];
            } else {
                swap(currentIndex, getRightIndex(currentIndex));
                currentIndex = getRightIndex(currentIndex);
                currentNode = buffer[currentIndex];
            }
        }
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    private boolean isBiggerOrEqual(V valueA, V valueB) {
        return priorityComparator.compare(valueA, valueB) <= 0;
    }

    private boolean isBigger(V valueA, V valueB) {
        return priorityComparator.compare(valueA, valueB) < 0;
    }

    private boolean isSmaller(V valueA, V valueB) {
        return priorityComparator.compare(valueA, valueB) > 0;
    }

    /*
    * for test
    * */
    public void print() {
        Node<V>[] newNode = Arrays.copyOf(buffer, size);

        System.out.println("pq size : " + size);

        System.out.println("--- print elements in order ---");
        int bufferSize = size;
        for (int i = 0; i < bufferSize; i++) {
            V pop = this.pop();
            System.out.println(pop);
        }
        System.out.println("--- print elements end ---");
        buffer = newNode;
        size = newNode.length;
    }

    private V getLeft(int index) {
        int leftIndex = getLeftIndex(index);
        if (size <= leftIndex) {
            return null;
        }
        return buffer[leftIndex] == null ? null : buffer[leftIndex].getValue();
    }

    private static int getLeftIndex(int index) {
        return index * 2 + 1;
    }

    private V getRight(int index) {
        int rightIndex = getRightIndex(index);
        if (size <= rightIndex) {
            return null;
        }
        return buffer[rightIndex] == null ? null : buffer[rightIndex].getValue();
    }

    private static int getRightIndex(int index) {
        return index * 2 + 2;
    }

    private V getParent(int index) {
        if (index <= 0) {
            return null;
        }
        if (index == 1 || index == 2) {
            return buffer[0].getValue();
        }

        int parentIndex = getParentIndex(index);
        return buffer[parentIndex] == null ? null : buffer[parentIndex].getValue();
    }

    private static int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    static class Node<V> {
        private final V value;

        public Node(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println("----------- max heap -----------");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        addNumber(maxHeap);
        maxHeap.print();
        while (!maxHeap.isEmpty()) {
            System.out.println("peek : %s, pop : %s".formatted(maxHeap.peek(), maxHeap.pop()));
        }

        System.out.println("----------- min heap -----------");
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Comparator.naturalOrder());
        addNumber(minHeap);
        minHeap.print();
        while (!minHeap.isEmpty()) {
            System.out.println("peek : %s, pop : %s".formatted(minHeap.peek(), minHeap.pop()));
        }
    }

    private static void addNumber(PriorityQueue<Integer> heap) {
        heap.offer(8);
        heap.offer(2);
        heap.offer(4);
        heap.offer(9);
        heap.offer(10);
        heap.offer(7);
        heap.offer(6);
        heap.offer(1);
        heap.offer(4);
    }
}
