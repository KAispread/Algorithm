import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 왼쪽 위 꼭지점의 경우의 수
    // 세로 N, 가로 M
    // (N - 8) * (M - 8)
    // 42 * 42 = 1800 정도? * 128
    // 완탐으로 풀자
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int answer = Integer.MAX_VALUE;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = bf.readLine().split("");

            for (int j = 0; j < M; j++) {
                if (line[j].equals("B")) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = -1;
                }
            }
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                answer = Math.min(answer, calcMoveCountTopBlack(map, i, j));
                answer = Math.min(answer, calcMoveCountTopWhite(map, i, j));
            }
        }

        System.out.println(answer);
    }

    private static int calcMoveCountTopBlack(int[][] map, int topY, int topX) {
        int count = 0;
        int answer = 0;

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                int current = map[topY + y][topX + x];

                if (count % 2 == 0) {
                    if (current != 1) {
                       answer++;
                    }
                } else {
                    if (current != -1) {
                        answer++;
                    }
                }

                count++;

            }
            count++;
        }

        return answer;
    }

    private static int calcMoveCountTopWhite(int[][] map, int topY, int topX) {
        int count = 0;
        int answer = 0;

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                int current = map[topY + y][topX + x];

                if (count % 2 == 0) {
                    if (current != -1) {
                        answer++;
                    }
                } else {
                    if (current != 1) {
                        answer++;
                    }
                }

                count++;

            }
            count++;
        }

        return answer;
    }

}

