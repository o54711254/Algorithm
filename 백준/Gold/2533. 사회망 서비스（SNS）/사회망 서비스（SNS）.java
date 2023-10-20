import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> graph;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		dp = new int[N + 1][2];

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		dfs(1, 1);

		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

	static void dfs(int now, int start) {
		dp[now][0] = 0;
		dp[now][1] = 1;

		for (int i = 0; i < graph.get(now).size(); i++) {
			int next = graph.get(now).get(i);
			if (next != start) {
				dfs(next, now);
				dp[now][0] += dp[next][1];
				dp[now][1] += Math.min(dp[next][0], dp[next][1]);
			}
		}
	}

}