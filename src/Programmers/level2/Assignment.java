package Programmers.level2;

import java.util.Arrays;
import java.util.Stack;

/*
* 과제 진행하기 - scheduling
* */
public class Assignment {
    public String[] solution(String[][] plans) {
        Plan[] schedule = new Plan[plans.length];
        String[] answer = new String[plans.length];
        int answerIdx = 0;

        for (int i = 0; i < plans.length; i++) {
            schedule[i] = new Plan(plans[i][0], plans[i][1], plans[i][2]);
        }

        Arrays.sort(schedule, (p1, p2) -> p1.time - p2.time);
        Stack<Plan> stack = new Stack<>();

        for (int i = 0; i < schedule.length - 1; i++) {
            Plan current = schedule[i];
            Plan after = schedule[i + 1];

            int gap = after.time - (current.time + current.duration);

            if (gap > 0) {
                answer[answerIdx] = current.name;
                answerIdx++;

                while (!stack.isEmpty() && gap > 0) {
                    Plan p = stack.peek();
                    int g = gap - p.duration;

                    if (g >= 0) {
                        stack.pop();
                        answer[answerIdx] = p.name;
                        answerIdx++;
                        gap = g;
                    } else {
                        p.duration -= gap;
                        break;
                    }
                }
            } else if (gap == 0) {
                answer[answerIdx] = current.name;
                answerIdx++;
            } else {
                current.duration = Math.abs(gap);
                stack.push(current);
            }
        }

        answer[answerIdx] = schedule[schedule.length - 1].name;
        answerIdx++;

        while (!stack.isEmpty()) {
            answer[answerIdx] = stack.pop().name;
            answerIdx++;
        }

        return answer;
    }


    public static class Plan {
        String name;
        int time, duration;

        public Plan(String name, String time, String duration) {
            this.name = name;
            this.time = convertTimeToMinute(time);
            this.duration = Integer.parseInt(duration);
        }

        private int convertTimeToMinute(String time) {
            String[] t = time.split(":");
            int hour = Integer.parseInt(t[0]) * 60;
            int minute = Integer.parseInt(t[1]);
            int total = hour + minute;

            return total;
        }
    }
}
