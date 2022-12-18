package Programmers.level0;

/*
* 주사위의 개수
* */
public class DiceAmount {
    class Solution {
        public int solution(int[] box, int n) {
            int maxX = box[0] / n;
            int maxY = box[1] / n;
            int maxZ = box[2] / n;

            return maxX * maxY * maxZ;
        }
    }
}
