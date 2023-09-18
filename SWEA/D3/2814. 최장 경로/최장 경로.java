import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visit;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			// N+1개만큼 추가, 인덱스 햇갈리니까
			for (int i = 0; i < N + 1; i++) {
				graph.add(new ArrayList<>());
			}

			max = Integer.MIN_VALUE;
			// 간선 정보 입력
			// 방향 없으므로 양방향으로 추가
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			for (int i = 1; i < N + 1; i++) {
				visit = new boolean[N + 1];
				dfs(i, 1);
			}
			System.out.println("#" + tc + " " + max);

		}
	}

	public static void dfs(int vertex, int count) {
		visit[vertex] = true;
		max = Math.max(max, count);

		for (int i : graph.get(vertex)) {
			if (!visit[i]) {
				dfs(i, count + 1);
				visit[i] = false;
			}
		}
	}
}