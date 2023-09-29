package Programmers.kit.DFS_BFS;

// LEVEL2 - 타겟 넘버
public class TargetNumber {

    static class Try {
        int t;
        int answer = 0;

        public int solution(int[] numbers, int target) {
            t = target;

            DFS(numbers, 0, 0);
            return answer;
        }

        public void DFS(int[] numbers, int sum, int idx) {
            if (idx == numbers.length) {
                if (sum == t) {
                    answer++;
                }
                return;
            }

            DFS(numbers, sum + numbers[idx], idx + 1);
            DFS(numbers, sum - numbers[idx], idx + 1);
        }
    }

    static class Answer {
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
}
