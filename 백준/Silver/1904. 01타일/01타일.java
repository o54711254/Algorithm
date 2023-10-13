import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];

		if (N >= 2) {
			dp[1] = 1;
			dp[2] = 2;
		} else {
			System.out.println(1);
			System.exit(0);
		}

		for (int i = 3; i < N + 1; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
		}

		System.out.println(dp[N]);
	}
}