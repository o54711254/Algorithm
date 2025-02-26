import java.io.*;
import java.util.*;

class Main {
	static int N, M, H;
	static int[][] dp;
	static List<List<Integer>> blockList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		dp = new int[N + 1][H + 1];

		blockList.add(new ArrayList<Integer>());

		for (int i = 1; i <= N; i++) {
			blockList.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				blockList.get(i).add(num);
			}
		}

		makeDP();
		System.out.println((dp[N][H] % 10007));
	}

	static void makeDP() {
		dp[0][0] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= H; j++) {
				dp[i][j] += dp[i - 1][j];
			}

			List<Integer> student = blockList.get(i);
			for (int j = H; j >= 0; j--) {
				if (dp[i - 1][j] > 0) {
					for (int num : student) {
						if (j + num <= H) {
							dp[i][j + num] = (dp[i][j + num] + dp[i - 1][j]) % 10007;
						}
					}
				}
			}

		}
	}

	static void print() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= H; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}