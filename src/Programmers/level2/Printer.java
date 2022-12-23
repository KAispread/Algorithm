package Programmers.level2;

import java.util.*;

/*
* 프린터
* */
public class Printer {
    public int solution(int[] priorities, int location) {
        Queue<Work> process = new LinkedList<>();
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            if (i == location) {
                process.add(new Work(true, priorities[i]));
            } else {
                process.add(new Work(false, priorities[i]));
            }
            sequence.add(priorities[i]);
        }
        sequence.sort(Comparator.reverseOrder());

        int max = sequence.get(0);
        int count = 0;
        while (!process.isEmpty()) {
            Work work = process.poll();
            if (work.getPriority() == max) {
                count++;
                if (work.getMark()) {
                    return count;
                }
                sequence.remove(0);
                max = sequence.get(0);
            } else {
                process.add(work);
            }
        }
        return 0;
    }

    static class Work {
        private boolean mark;
        private int priority;

        public Work(boolean mark, int priority) {
            this.mark = mark;
            this.priority = priority;
        }

        public boolean getMark() {
            return mark;
        }

        public int getPriority() {
            return priority;
        }
    }

}
