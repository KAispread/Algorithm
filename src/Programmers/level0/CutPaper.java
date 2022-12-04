package Programmers.level0;
/*
* 종이 자르기
* */
public class CutPaper {
    public static void main(String[] args) {

    }

    public static int solution(int M, int N) {
        int answer = 0;
        answer += M - 1;
        answer += (N - 1) * M;
        return answer;
    }
}
