import java.io.*;
import java.util.*;

class Object {
	int weight;
	int value;

	public Object(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
}

class Main {
	static int N, K;
	static int[] dp;
	static List<Object> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[K + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			list.add(new Object(weight, value));
		}

		knapsack();
		System.out.println(dp[K]);

	}

	static void knapsack() {
		for (Object object : list) {
			int weight = object.weight;
			int value = object.value;

			for (int i = K; i - weight >= 0; i--) {
				dp[i] = Math.max(dp[i], dp[i - weight] + value);
			}
		}
	}
}