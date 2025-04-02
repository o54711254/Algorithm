import java.io.*;
import java.util.*;

class Main {
	static int N;
	static final int INF = 200000000;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new int[1000001];
		Arrays.fill(dp, INF);
		dp[1] = 0;

		for (int i = 1; i <= N; i++) {
			if (i + 1 <= 1000000) {
				dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
			}
			if (i * 2 <= 1000000) {
				dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
			}
			if (i * 3 <= 1000000) {
				dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
			}
		}

		System.out.println(dp[N]);
	}
}