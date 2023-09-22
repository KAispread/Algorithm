package Programmers.kit.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// LEVEL2 -> 기능 개발
public class FeatureDevelopment {

    static class Answer {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Process> runProcess = new LinkedList<>();
            for (int i = 0; i < progresses.length; i++) {
                runProcess.offer(new Process(progresses[i], speeds[i]));
            }
            List<Integer> deploy = new ArrayList<>();
            while (!runProcess.isEmpty()) {
                while (!runProcess.peek().isDone()) {
                    for (Process prc : runProcess) {
                        prc.run();
                    }
                }

                int count = 0;
                while (!runProcess.isEmpty() && runProcess.peek().isDone()) {
                    runProcess.poll();
                    count++;
                }
                deploy.add(count);
            }


            return deploy.stream().mapToInt(i -> i).toArray();
        }

        static class Process {
            private int progress;
            private int speed;

            public Process(int progress, int speed) {
                this.progress = progress;
                this.speed = speed;
            }

            public void run() {
                this.progress += speed;
            }

            public boolean isDone() {
                if (progress >= 100) {
                    return true;
                }
                return false;
            }
        }
    }
}
