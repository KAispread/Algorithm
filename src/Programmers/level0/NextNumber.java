package Programmers.level0;

/*
 * 입력 값으로 등차 혹은 등비 수열이 주어질 때 다음에 올 숫자를 판별
 *
 * */
public class NextNumber {
    public static void main(String[] args) {
        solution(new int[] {1, 2, 3, 4}); // result = 5
    }

    public static int solution(int[] common) {
        int answer = 0;
        int lastIndex = common.length - 1;
        if (isGeometric(common)) {
            int ratio = common[lastIndex] / common[lastIndex - 1];
            answer = common[lastIndex] * ratio;
            return answer;
        }

        int gap = common[lastIndex] - common[lastIndex - 1];
        answer = common[lastIndex] + gap;
        return answer;
    }

    // 등비 수열 판별
    private static boolean isGeometric(int[] common) {
        int gap = 0;
        int temp = common[0];
        for (int i = 1; i < common.length; i++) {
            if (gap != 0 && gap != common[i] - common[i - 1]) {
                return true;
            }
            gap = common[i] - common[i - 1];
        }
        return false;
    }
}

