package Programmers.kit.stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// 프로세스
public class Proccess {
    static class Try {
        static class Proc {
            int priority;
            int index;

            public Proc(int index, int priority) {
                this.index = index;
                this.priority = priority;
            }
        }

        public int solution(int[] priorities, int location) {
            Queue<Proc> queue = new LinkedList<>();
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < priorities.length; i++) {
                Proc proc = new Proc(i, priorities[i]);
                queue.offer(proc);
            }
            Arrays.sort(priorities);

            int order = 1;
            for (int i = priorities.length - 1; i >= 0; i--) {
                int highPriority = priorities[i];

                while (highPriority > queue.peek().priority) {
                    Proc p = queue.poll();
                    queue.offer(p);
                }
                Proc target = queue.poll();
                map.put(target.index, order);
                order++;
            }

            return map.get(location);
        }
    }


    static class Answer {
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
}
