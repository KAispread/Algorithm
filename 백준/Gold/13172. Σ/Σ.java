import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static long MOD = 1_000_000_007L;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(br.readLine());
		long ans = 0;
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int g = gcd(Math.max(N, S), Math.min(N, S));
			N /= g;
			S /= g;
			ans += S * f(N,MOD-2) % MOD;
			ans %= MOD;
		}
		System.out.println(ans);
	}
	static int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}
	static long f(long b, long n) {
		if(n == 1) return b;
		long p = f(b,n/2);
		long ret = p*p%MOD;
		if(n%2 == 1) {
			ret = ret*b%MOD;
		}
		return ret;
	}
}