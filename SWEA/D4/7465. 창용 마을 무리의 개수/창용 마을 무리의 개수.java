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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			for (int i = 0; i < N + 1; i++) {
				graph.add(new ArrayList<>());
			}
			visit = new boolean[N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				graph.get(u).add(v);
				graph.get(v).add(u);
			}

			int count = 0;
			for (int i = 1; i < N + 1; i++) {
				if (!visit[i]) {
					bfs(i);
					count++;
				}
			}
			System.out.println("#" + tc + " " + count);
		}
	}

	public static void bfs(int vertex) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(vertex);
		visit[vertex] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 0; i < graph.get(now).size(); i++) {
				int next = graph.get(now).get(i);
				if (!visit[next]) {
					queue.add(next);
					visit[next] = true;
				}
			}
		}
	}
}