import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] coin, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		coin = new int[N];
		dp = new int[M + 1];

		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 1;

		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j <= M; j++) {
				if (j >= coin[i])
					dp[j] += dp[j - coin[i]];
			}
			
		}
		System.out.println(dp[M]);
	}
}