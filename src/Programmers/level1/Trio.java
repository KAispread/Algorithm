package Programmers.level1;

/*
* 트리오
* */
public class Trio {
    class Solution {
        public int solution(int[] number) {
            int answer = 0;

            for (int i = 0; i < number.length - 2; i++) {
                for (int j = i + 1; j < number.length - 1; j++) {
                    for (int z = j + 1; z < number.length; z++) {
                        if (number[i] + number[j] + number[z] == 0) answer++;
                    }
                }
            }

            return answer;
        }
    }
}
