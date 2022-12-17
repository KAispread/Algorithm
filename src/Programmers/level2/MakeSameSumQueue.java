package Programmers.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MakeSameSumQueue {
    public static void main(String[] args) {
        solution(new int[]{1,2,1,2}, new int[]{1,10,1,2});
    }

    public String soul(String[] survey, int[] choices) {
        Map<String, Integer> score = new TreeMap<>();
        String[] group = {"RT", "CF", "JM", "AN"};
        score.put("R", 0);
        score.put("T", 0);
        score.put("C", 0);
        score.put("F", 0);
        score.put("J", 0);
        score.put("M", 0);
        score.put("A", 0);
        score.put("N", 0);

        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            String[] st = survey[i].split("");
            String negative = st[0];
            String positive = st[1];
            if (choice == 4) {
                continue;
            } else if (choice > 4) {
                int sc = score.get(positive);
                score.put(positive, sc + choice - 4);
            } else {
                int sc = score.get(positive);
                score.put(positive, sc + 4 - choice);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < group.length; i++) {
            String[] sur = group[i].split("");
            String surA = sur[0];
            String surB = sur[1];
            int aScore = score.get(surA);
            int bScore = score.get(surB);
            if (aScore == bScore) {
                builder.append(surA);
            } else if (aScore > bScore) {
                builder.append(surA);
            } else {
                builder.append(surB);
            }
        }
        return builder.toString();
    }
    public static int solution(int[] queue1, int[] queue2) {
        long sum = 0;
        long queue1Sum = 0;
        long queue2Sum = 0;
        for (int i = 0; i < queue1.length; i++) {
            queue1Sum += queue1[i];
            queue2Sum += queue2[i];
            sum += queue1[i] + queue2[i];
        }
        if (sum % 2 != 0) {
            return -1;
        }
        if (queue1Sum == queue2Sum) {
            return 0;
        }

        long value = sum / 2;

        int count;
        if (queue1Sum > value) {
            count = getWorkCount(queue1, queue2, queue1Sum, queue2Sum, value);
        } else {
            count = getWorkCount(queue2, queue1, queue2Sum, queue1Sum, value);
        }

        if (count == 0) {
            return -1;
        }
        return count;
    }

    private static int getWorkCount(int[] queue1, int[] queue2, long queue1Sum, long queue2Sum, long value) {
        int count = 0;
        long pop1 = 0;
        for (int i = 0; i < queue1.length; i++) {
            pop1 += queue1[i];
            long remain = queue1Sum - pop1;
            long pop2 = 0;
            if (remain < value) {
                for (int j = 0; j < queue2.length + i; j++) {
                    if (j >= queue2.length) {
                        pop2 += queue1[j - queue2.length];
                    } else {
                        pop2 += queue2[j];
                    }
                    long remain2 = queue2Sum - pop2;

                    if (pop2 + remain == value && pop1 + remain2 == value) {
                        return i + j + 2;
                    }
                }
            } else if (remain == value) {
                if (queue2Sum + pop1 == value) {
                    return i + 1;
                }
            }
        }

        return count;
    }
}
