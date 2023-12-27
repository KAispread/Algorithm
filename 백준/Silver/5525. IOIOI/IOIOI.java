import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char s[] = br.readLine().toCharArray();

		int result = 0;
		int count = 0;

		for(int i=1; i < M - 1; i++) {
		if(s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I') {
				count++;

				if(count == N) {
					count--;
					result++;
				}
                i++;
			}
			else {
				count = 0;
			}
		}

		System.out.println(result);

	} // End of main
} // End of class