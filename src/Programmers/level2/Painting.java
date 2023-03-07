package Programmers.level2;

/*
* 덧칠하기
* */
public class Painting {
    public int solution(int n, int m, int[] section) {
        int roll = section[0] + m - 1;
        int answer = 1;

        for(int i = 1; i < section.length; i++) {
            if (roll < section[i]) {
                roll = section[i] + m - 1;
                answer++;
            }
        }

        return answer;
    }
}
