package Programmers.level2;

import java.util.Arrays;

// 통과
public class LevelTest {
    // 최소 누적 값
    class Solution
    {
        public int solution(int []A, int []B)
        {
            int answer = 0;

            Arrays.sort(A);
            Arrays.sort(B);

            int BIdx = B.length - 1;
            for (int i = 0; i < A.length; i++) {
                answer += A[i] * B[BIdx];
                BIdx--;
            }

            return answer;
        }
    }

    // 던전 피로도
    class Solution2 {
        int answer = 0;
        int length;

        public int solution(int k, int[][] dungeons) {
            length = dungeons.length;

            for (int i = 0; i < length; i++) {
                boolean[] visited = new boolean[length];
                DFS(dungeons, visited, 0, k);
            }

            return answer;
        }

        private void DFS(int[][] dungeons, boolean[] visited, int depth, int tired) {
            for (int i = 0; i < length; i++) {
                if (tired >= dungeons[i][0] && !visited[i]) {
                    visited[i] = true;
                    DFS(dungeons, visited, depth + 1, tired - dungeons[i][1]);
                    visited[i] = false;
                }
            }

            answer = Math.max(answer, depth);
        }
    }
}
