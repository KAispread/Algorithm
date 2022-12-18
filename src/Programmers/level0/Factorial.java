package Programmers.level0;

/*
* 팩토리얼
* */
public class Factorial {
    class Solution {
        public int solution(int n) {
            int factorial = 1, sum = 1;
            while (sum < n) {
                factorial++;
                sum *= factorial;
            }
            if (sum > n) {
                return --factorial;
            }
            return factorial;
        }
    }
}
