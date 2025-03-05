import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int[] dp, T, P;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		dp = new int[N + 2];
		T = new int[N + 2];
		P = new int[N + 2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int period = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			T[i] = period;
			P[i] = cost;
		}

		for (int i = 1; i <= N + 1; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1]);

			int next = i + T[i];
			if (next < N + 2) {
				dp[next] = Math.max(dp[next], dp[i] + P[i]);
			}			
		}

		System.out.println(dp[N + 1]);
	}
}