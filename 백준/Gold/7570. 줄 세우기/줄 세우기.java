import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];

		int max = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			dp[num] = dp[num - 1] + 1;
			max = Math.max(dp[num], max);
		}

		System.out.println(N - max);
	}

}