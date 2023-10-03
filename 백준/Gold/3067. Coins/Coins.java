import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 테스트케이스
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			// 동전 개수
			int N = Integer.parseInt(br.readLine());

			// 동전 배열
			int[] arr = new int[N + 1];
			dp = new int[N + 1][10001];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i] = num;
				dp[i][num]++;
			}

			int amount = Integer.parseInt(br.readLine());

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= amount; j++) {
					if (j - arr[i] < 0) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] += dp[i - 1][j] + dp[i][j - arr[i]];
					}
				}
			}
			System.out.println(dp[N][amount]);
		}
	}

}