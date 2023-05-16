package Programmers.level2;

/*
* 연속된 부분 수열의 합
* */
public class PartialSequences {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int sum = sequence[0];
        int idx = 0;
        int length = Integer.MAX_VALUE;

        if (sum == k) return answer;

        // 부분 수열 찾기
        for (int i = 1; i < sequence.length; i++) {
            sum += sequence[i];

            while (sum > k && idx < i) {
                sum -= sequence[idx];
                idx++;
            }

            if (sum == k && i - idx < length) {
                answer[0] = idx;
                answer[1] = i;
                length = i - idx;
            }
        }

        return answer;
    }
}
