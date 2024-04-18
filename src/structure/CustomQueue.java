package structure;

public class CustomQueue {

    public static void main(String[] args) {
        int[] test = new int[] {1,2,3,4,5,6,7,8,9};
        Queue<Integer> queue = new Queue<>();

        for (int t : test) {
            queue.offer(t);
        }

        for (int t = 0; t < test.length; t++) {
            System.out.print(queue.poll() + " ");
        }
    }

    public static class Queue<T> {
        private static final int DEFAULT_CAPACITY = 10;

        private T[] elements;
        private int capacity;
        private int size;
        private int front;
        private int rear;

        // 생성자
        public Queue() {
            capacity = DEFAULT_CAPACITY;
            elements = (T[]) new Object[capacity];
            size = 0;
            front = 0;
            rear = -1;
        }

        // 큐가 비어있는지 확인
        public boolean isEmpty() {
            return size == 0;
        }

        // 큐가 가득 찼는지 확인
        public boolean isFull() {
            return size == DEFAULT_CAPACITY;
        }

        // 큐에 요소 추가
        public void offer(T item) {
            if (isFull()) {
                System.out.println("Queue is full. Cannot enqueue.");
                return;
            }
            rear = (rear + 1) % capacity;
            elements[rear] = item;
            size++;
        }

        // 큐에서 요소 제거 및 반환
        public T poll() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Cannot dequeue.");
                return null;
            }
            T removedItem = elements[front];
            front = (front + 1) % capacity;
            size--;
            return removedItem;
        }

        // 큐의 현재 크기 반환
        public int size() {
            return size;
        }

        // 큐의 첫 번째 요소 반환
        public T peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Cannot peek.");
                return null;
            }
            return elements[front];
        }
    }
}
