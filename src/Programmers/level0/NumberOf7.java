package Programmers.level0;

/*
* 7의 개수
* */
public class NumberOf7 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {7, 77, 17}));
    }

    public static int solution(int[] array) {
        int answer = 0;
        for (int num : array) {
            answer += numberOf7(num);
        }
        return answer;
    }

    private static int numberOf7(int num) {
        String numString = String.valueOf(num);
        char[] numChars = numString.toCharArray();
        int answer = 0;
        for (char chars : numChars) {
            if (chars == '7') {
               answer++;
            }
        }
        return answer;
    }
}
