package Programmers.level2;

import java.util.Map;
import java.util.TreeMap;

public class MBTI {
    public static void main(String[] args) {
        solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
    }

    public static String solution(String[] survey, int[] choices) {
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
                int sc = score.get(negative);
                score.put(negative, sc + 4 - choice);
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
}
