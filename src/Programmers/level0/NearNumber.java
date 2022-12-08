package Programmers.level0;
/*
* 가까운 수
* */
public class NearNumber {
    public static void main(String[] args) {

    }

    public int solution(int[] array, int n) {
        int answer = 0;
        int gap = Integer.MAX_VALUE;

        for (int num : array) {
            int between = Math.abs(num - n);
            if (gap > between) {
                answer = num;
                gap = between;
            } else if (gap == between && num < answer) {
                answer = num;
            }
        }
        return answer;
    }
}
