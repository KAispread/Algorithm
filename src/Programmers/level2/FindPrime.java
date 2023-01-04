package Programmers.level2;

/*
* 소수 찾기
* - DFS 활용
* - 소수찾기
* */
public class FindPrime {
    public static void main(String[] args) {
        solution("17");
    }

    static int answer = 0;
    static int[] visited;
    static int numLen;

    public static int solution(String numbers) {
        String[] nums = numbers.split("");
        numLen = nums.length;
        visited = new int[10];

        for (String n : nums) {
            visited[Integer.parseInt(n)]++;
        }

        for (int i = 1; i < visited.length; i++) {
            if (visited[i] > 0) {
                visited[i]--;
                DFS(i, 1);
                visited[i]++;
            }
        }

        return answer;
    }

    private static void DFS(int num, int depth) {
        if (depth > numLen) {
            return;
        }
        if (isPrime(num)) {
            answer++;
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] > 0) {
                visited[i]--;
                DFS((num * 10) + i, depth + 1);
                visited[i]++;
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
