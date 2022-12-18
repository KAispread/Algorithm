package Programmers.level0;

/*
* 합성수 찾기
* */
public class CompositeNumber {
    class Solution {
        public int solution(int n) {
            if (n <= 3) {
                return 0;
            }
            int count = 0;
            for (int i = 4; i <= n; i++) {
                for (int j = 2; j < i / 2 + 1; j++) {
                    if (i % j == 0) {
                        count++;
                        break;
                    }
                }
            }
            return count;
        }
    }
}
