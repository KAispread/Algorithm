package commuLearning.week3.step3;

public class Question1 {
    private int answer;
    private int max;

    public int solution(int n) {
        answer = 0;
        max = n * 2;

        DFS(1, 0, 1);

        return answer;
    }

    private void DFS(int left, int right, int depth) {
        if (left < right) {
            return;
        }
        if (depth == max) {
            if (left == right) answer++;
            return;
        }
        DFS(left + 1, right, depth + 1);
        DFS(left, right + 1, depth + 1);
    }
}
