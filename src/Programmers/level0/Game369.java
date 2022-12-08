package Programmers.level0;
/*
* 369 게임
* */
public class Game369 {
    public static void main(String[] args) {

    }

    public int solution(int order) {
        int answer = 0;
        char[] nums = String.valueOf(order).toCharArray();
        for (char num : nums) {
            int integerNum = num - 48;
            if (integerNum == 3 || integerNum == 6 || integerNum  == 9) {
                answer++;
            }
        }
        return answer;
    }
}
