import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[] dp = new int[12];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			dp[4] = 7;

			for (int i = 5; i <= 11; i++) {
				dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) + dp[i - 2] - dp[i - 3] + dp[i - 3] - dp[i - 4];
			}
			
			System.out.println(dp[N]);

		}
	}
}