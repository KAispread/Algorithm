package Programmers.level0;

public class FindNumber {
    public static void main(String[] args) {
        String num = "1234";
        System.out.println(num.indexOf("5"));
    }

    public int solution(int num, int k) {
        int answer = 0;
        String stringNum = String.valueOf(num);
        String target = String.valueOf(k);
        answer = stringNum.indexOf(target);
        if (answer >= 0) {
            answer++;
        }
        return answer;
    }
}
