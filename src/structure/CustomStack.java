package structure;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomStack {

    public static void main(String[] args) {
        int[] test = new int[] {1,2,3,4,5,6,7,8,9};
        Stack<Integer> stack = new Stack<>();

        for (int t : test) {
            stack.push(t);
        }

        for (int t = 0; t < test.length; t++) {
            System.out.print(stack.pop() + " ");
        }
    }

    static class Stack<T> {
        private static final int DEFAULT_CAPACITY = 10;
        private final List<T> stackArr;

        private AtomicInteger lastIndex = new AtomicInteger(0);

        public Stack() {
            stackArr = new CopyOnWriteArrayList<>();
        }

        public void push(T data) {
            stackArr.add(data);
            lastIndex.incrementAndGet();
        }

        public T pop() {
            int idx = lastIndex.getAndDecrement() - 1;
            return stackArr.remove(idx);
        }

        public T peek() {
            return stackArr.get(lastIndex.getAcquire() - 1);
        }

        public int size() {
            return lastIndex.getAcquire();
        }
    }
}
