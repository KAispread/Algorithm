package commuLearning.week3.step4;

/*
* 정수 삼각형 - 실패
* */
public class Question1 {
    private int[][] route;
    private int answer;

    public int solution(int[][] triangle) {
        answer = 0;
        route = new int[triangle.length][triangle.length];

        for (int i = 0; i < triangle.length; i++) {
            int idx = 0;
            for (int t : triangle[i]) {
                route[i][idx] = t;
                idx++;
            }
        }

        DFS(0, 0, route[0][0]);

        return answer;
    }

    private void DFS(int depth, int idx, int num) {
        if (depth == route.length - 1) {
            answer = Math.max(answer, num);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int a = route[depth+1][idx + i];
            DFS(depth+1, i, num + a);
        }
    }
}
