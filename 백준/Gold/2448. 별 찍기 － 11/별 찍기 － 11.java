import java.util.Arrays;
import java.util.Scanner;

// 별 찍기 - 11
public class Main {
	static char[][] stars;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		stars = new char[N][N * 2 - 1]; // 꼭대기 별이 (0,N-1)에 찍힘
		for (int i = 0; i < N; i++) {
			Arrays.fill(stars[i], ' '); // 공백으로 채움
		}
		
		star(0, N-1, N);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N - 1; j++) {
				sb.append(stars[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void star(int r, int c, int N) {
		if (N == 3) { // k=0인 가장 작은 삼각형일 때 별찍기
			stars[r][c] = '*';
			stars[r + 1][c - 1] = stars[r + 1][c + 1] = '*';
			stars[r + 2][c - 2] = stars[r + 2][c - 1] = stars[r + 2][c] = stars[r + 2][c + 1] = stars[r + 2][c + 2] = '*';
			return;
		} else { // 큰 삼각형 세개로 다시 쪼갬
			int cut = N / 2;
			star(r, c, cut); // 제일 위에 삼각형
			star(r + cut, c - cut, cut); // 아래 왼쪽 삼각형
			star(r + cut, c + cut, cut); // 아래 오른쪽 삼각형
		}
	}
}