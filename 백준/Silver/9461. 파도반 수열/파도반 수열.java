import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[101];

			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;

			for (int i = 4; i <= 100; i++) {
				dp[i] = dp[i - 3] + dp[i - 2];
			}

			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb);
	}
}