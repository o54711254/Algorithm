import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean visit[];
	static int[] result;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		visit = new boolean[N + 1];
		result = new int[N + 1];
		count = 1;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (int i = 0; i < graph.size(); i++) {
			Collections.sort(graph.get(i));
		}
		bfs(R);

		for (int i = 1; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}

	public static void bfs(int vertex) {
		Queue<Integer> queue = new LinkedList<>();
		visit[vertex] = true;
		result[vertex] = count++;
		queue.add(vertex);

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 0; i < graph.get(now).size(); i++) {
				int next = graph.get(now).get(i);
				if (!visit[next]) {
					queue.add(next);
					visit[next] = true;
					result[next] = count++;
				}
			}
		}
	}
}
