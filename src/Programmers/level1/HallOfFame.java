package Programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* 프로그래머스 레벨 1 - 명예의 전당
* */
public class HallOfFame {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[] {10, 100, 20, 150, 1, 100, 200})));
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        Fame hallOfFame = new Fame(k);

        for (int count = 0; count < score.length; count++) {
            int todayScore = score[count];
            hallOfFame.addScoreToFame(todayScore);
            answer[count] = hallOfFame.getMinScoreInFame();
        }
        return answer;
    }

    static class Fame {
        private final int k;
        private final List<Integer> fames = new ArrayList<>();

        public Fame(int k) {
            this.k = k;
        }

        public void addScoreToFame(int score) {
            if (fames.size() < k) {
                fames.add(score);
                Collections.sort(fames);
                return;
            }

            if (fames.get(0) < score) {
                fames.remove(fames.get(0));
                fames.add(score);
            }
            Collections.sort(fames);
        }

        public int getMinScoreInFame() {
            return fames.get(0);
        }
    }
}
