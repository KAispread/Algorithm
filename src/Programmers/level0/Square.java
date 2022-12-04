package Programmers.level0;
/*
* 제곱수 판별하기
* */
public class Square {
    public int solution(int n) {
        int temp = 0;
        int N = 2;

        do {
            temp = N * N;
            N++;
        } while (temp < n);

        if (temp == n) {
            return 1;
        }
        return 2;
    }
}
