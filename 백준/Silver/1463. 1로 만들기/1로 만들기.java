import java.io.*;
import java.util.*;

public class Main {
	static int[] dp = new int[1000001];
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < 1000001; i++) {
			dp[i] = 987654321;
		}
		dp[0] = 0;
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