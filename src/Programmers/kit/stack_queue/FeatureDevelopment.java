package Programmers.kit.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// LEVEL2 -> 기능 개발
public class FeatureDevelopment {

    /*
    1. 각 작업당 얼마의 날짜가 필요한지 차례대로 Queue에 저장
    2. 첫 번째 작업이 끝나는 날을 계산하고 Queue에서 해당 작업을 뺌
    2-1 첫 번째 작업이 끝나는 날이 그 다음 Queue에 있는 날짜보다 크다면 작업을 뺌
    2-2 Queue에 들어있는 작업이 더 많은 시간이 필요할 경우 count를 멈추고 List에 추가함
    3. Queue에 모든 원소가 빌때까지 반복
    */
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int requireDays = remain / speeds[i];

            if (remain % speeds[i] != 0) requireDays++;
            queue.add(requireDays);
        }

        List<Integer> list = new ArrayList<>();
        int count = 0;
        int day = queue.peek();

        while (!queue.isEmpty()) {
            if (day >= queue.peek()) {
                queue.poll();
                count++;
            } else {
                list.add(count);
                count = 0;
                day = queue.peek();
            }
        }

        if (count != 0) {
            list.add(count);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

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
