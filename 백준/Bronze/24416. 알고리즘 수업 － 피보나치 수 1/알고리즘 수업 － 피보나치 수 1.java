import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	static int cnt;
	static int dpCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		dp = new int[N];

		func(N);
		dp(N);
		System.out.println(cnt);
		System.out.println(dpCnt);
	}

	public static int func(int N) {
		if (N == 1 || N == 2) {
			cnt++;
			return 1;
		}
		return func(N - 1) + func(N - 2);
	}

	public static int dp(int N) {
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < N; i++) {
			dpCnt++;
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[N - 1];
	}
}