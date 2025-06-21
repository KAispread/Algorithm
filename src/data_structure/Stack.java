package data_structure;

public class Stack<V> {

    private static final int DEFAULT_CAPACITY = 5;

    private Node<V>[] elements;
    private int size;
    private int head;
    private int tail;

    public Stack() {
        this.elements = new Node[DEFAULT_CAPACITY];
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }

    /*
    * insert
    * 1. add value to elements
    * 2. increase size
    * 3. if size is full -> increase array
    * */
    public void add(V value) {
        Node<V> current = new Node<>(value);

        if (size + 1 >= elements.length) {
            Node<V>[] newElements = new Node[elements.length * 2];

            int index = head;
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[index];
                index = nextIndex(index);
            }

            head = 0;
            tail = size - 1;

            elements = newElements;
        }

        size++;
        tail = nextIndex(tail);
        elements[tail] = current;
    }

    private int nextIndex(int index) {
        if (index + 1 < size) {
            return index + 1;
        }
        return 0;
    }

    private int prevIndex(int index) {
        if (index - 1 >= 0) {
            return index - 1;
        }
        return elements.length - 1;
    }

    /*
    * peek
    * */
    public V peek() {
        return elements[tail].value();
    }

    /*
    * delete -> LIFO
    * */
    public V pop() {
        return popNode().value();
    }

    private Node<V> popNode() {
        Node<V> popNode = elements[tail];

        elements[tail] = null;
        tail = prevIndex(tail);
        size--;
        return popNode;
    }

    /*
    * contains value
    * */
    public boolean contains(V value) {
        Node<V> current;
        int index = head;
        while ((current = elements[index]) != null) {
            if (current.value() == value) return true;
            index = nextIndex(index);
        }
        return false;
    }

    /*
    * for test
    * */
    public void print() {
        System.out.printf("size = %s, head = %s, tail = %s %n", size, head, tail);

        Node<V> current;
        int index = tail;
        System.out.println("--------- pop value ---------");
        while ((current = elements[index]) != null) {
            index = prevIndex(index);
            System.out.println(current.value());
        }
        System.out.println("--------- pop end ---------");
    }

    record Node<V>(V value) {
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("value");
        stack.add("apple");
        stack.add("skip");

        System.out.println("peek : " + stack.peek());

        stack.add("review");
        stack.add("ojo");

        System.out.println("pop : " + stack.pop());

        stack.print();

        stack.add("gang");
        stack.add("pang");
        stack.add("yield");

        stack.print();

        int size = stack.size;
        for (int i = 0; i < size; i++) {
            System.out.println("pop : " + stack.pop());
        }
    }
}
