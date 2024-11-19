import java.io.*;
import java.util.*;
import java.awt.*;

class Main {
	static int N;
	static final int INF = 2000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N + 1][3];
		int[][] dp = new int[N + 1][3];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = INF;

		for (int i = 0; i < 3; i++) {
			initDP(dp);
			dp[1][i] = arr[1][i];

			for (int j = 2; j <= N; j++) {
				dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
				dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
				dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
			}

			for (int j = 0; j < 3; j++) {
				if (i != j) {
					result = Math.min(result, dp[N][j]);
				}
			}
		}

		System.out.println(result);

	}

	static void initDP(int[][] dp) {
		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] = INF;
			}
		}
	}
}