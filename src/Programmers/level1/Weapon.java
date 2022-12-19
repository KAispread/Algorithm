package Programmers.level1;

import java.util.Comparator;

/*
* 기사단원의 무기
* - 소수의 개수 구하는 식 사용
* */
public class Weapon {
    public static void main(String[] args) {
        solution(5, 3, 2);
    }

    public static int solution(int number, int limit, int power) {
        int sum = 1;
        for (int num = 1; num <= number; num++) {
            int count = getNum(num);

            if (count > limit) {
                sum += power;
            } else {
                sum += count;
            }
        }
        return sum;
    }

    private static int getNum(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                count++;
                if (i * i < num) {
                    count++;
                }
            }
        }
        return count;
    }

}
