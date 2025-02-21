import java.io.*;
import java.util.*;

class App {
	int memory;
	int cost;

	public App(int memory, int cost) {
		this.memory = memory;
		this.cost = cost;
	}
}

class Main {
	static int N, M, total;
	static int[] dp;

	static List<App> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		total = 0;

		int[] memory = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		int[] cost = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			total += cost[i];
		}

		for (int i = 0; i < N; i++) {
			list.add(new App(memory[i], cost[i]));
		}

		dp = new int[total + 1];

		knapsack();

		for (int i = 0; i <= total; i++) {
			if (dp[i] >= M) {
				System.out.println(i);
				break;
			}
		}
	}

	static void knapsack() {

		for (App app : list) {
			int memory = app.memory;
			int cost = app.cost;

			for (int i = total; i - cost >= 0; i--) {
				dp[i] = Math.max(dp[i], dp[i - cost] + memory);
			}
		}
	}
}