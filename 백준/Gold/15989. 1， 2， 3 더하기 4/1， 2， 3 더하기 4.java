import java.util.*;
import java.io.*;

public class Main {

	static Integer[] dp = new Integer[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 4;
		dp[5] = 5;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {

			int N = Integer.parseInt(br.readLine());
			sb.append(find(N)).append("\n");

		}
		
		System.out.println(sb);

	}

	private static int find(int N) {

		if (dp[N] == null) {
			dp[N] = 1 + (N / 2) + find(N-3);
		}

		return dp[N];
	}
}