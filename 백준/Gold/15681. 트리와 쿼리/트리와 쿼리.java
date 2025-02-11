import java.io.*;
import java.util.*;

//class Node {
//	int u;
//	int v;
//
//	public Node(int u, int v) {
//		this.u = u;
//		this.v = v;
//	}
//}

public class Main {
	static int[] dp;
	static boolean[] visit;
	static List<List<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		dp = new int[N + 1];
		visit = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		dfs(R);

		for (int i = 0; i < Q; i++) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		
		System.out.println(sb);
	}

	static int dfs(int start) {
		
		dp[start] = 1;
		visit[start] = true;

		for (int i = 0; i < graph.get(start).size(); i++) {
			int next = graph.get(start).get(i);
			if (!visit[next]) {
				dp[start] += dfs(next);
			}
		}

		return dp[start];
	}
}