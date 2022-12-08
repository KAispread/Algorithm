package Programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class Test1Level1 {
    /*
    * 3진수 뒤집기
    * */
    public static void main(String[] args) {
        System.out.println(solution2(3, 1, 20));
    }
    private static final int KEY = 3;
    public static int solution(int n) {
        if (n == 2 || n == 1 || n == 0) {
            return n;
        }
        int count = 1;
        double current = 1;
        while (n >= current) {
            count++;
            current = Math.pow(KEY, count);
        }
        int[] KEY_arr = new int[count];

        int buffer = n;
        for (int i = KEY_arr.length - 1; i >= 0; i--) {
            int curr = (int) Math.pow(KEY, i);
            if (buffer >= curr * 2) {
                KEY_arr[i] = 2;
                buffer -= curr * 2;
            } else if (buffer < curr * 2 && buffer >= curr) {
                KEY_arr[i] = 1;
                buffer -= curr;
            }
            if (buffer == 0) {
                break;
            }
        }
        List<Integer> swap = new ArrayList<>();
        for (int i = KEY_arr.length - 1; i >= 0; i--) {
            swap.add(KEY_arr[i]);
        }
        int sum = 0;
        for (int i = 0; i < swap.size(); i++) {
            int curr = (int) Math.pow(KEY, i);
            int result = curr * swap.get(i);
            sum += result;
        }
        return sum;
    }

    /*
    * 콜라문제
    * */
    public static int solution2(int a, int b, int n) {
        Bowl coke = new Bowl(a, b, n, 0);
        int answer = 0;
        while (coke.isRemaining()) {
            answer += coke.runOneCycle();
        }
        return answer;
    }

    static class Bowl {
        private final int standard;
        private final int award;
        private int full;
        private int empty;

        public Bowl(int standard, int award, int full, int empty) {
            this.standard = standard;
            this.award = award;
            this.full = full;
            this.empty = empty;
        }

        public int getFull() {
            return full;
        }

        public int getEmpty() {
            return empty;
        }

        public int runOneCycle() {
            empty += full;
            this.full = 0;
            return getFullFromEmpty();
        }

        private int getFullFromEmpty() {
            int recycleEmpty = empty / standard;
            recycleEmpty *= standard;
            int reward = empty / standard * award;
            this.full += reward;
            this.empty -= recycleEmpty;
            return reward;
        }

        public boolean isRemaining() {
            if (full + empty < standard) {
                return false;
            }
            return true;
        }
    }
}
