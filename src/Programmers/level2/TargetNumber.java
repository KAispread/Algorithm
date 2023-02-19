package Programmers.level2;

/*
* 타겟 넘버
* */
public class TargetNumber {
    private int answer;
    private int t;

    public int solution(int[] numbers, int target) {
        answer = 0;

        t = target;
        DFS(numbers, 0, 0);

        return answer;
    }

    private void DFS(int[] num, int sum, int idx) {
        if (idx == num.length) {
            if (sum == t) answer++;
            return;
        }

        DFS(num, sum + num[idx], idx + 1);
        DFS(num, sum - num[idx], idx + 1);
    }
}
