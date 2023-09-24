import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] arr;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList<ArrayList<Integer>>();
		arr = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			arr[v]++;
		}
		for (int i = 1; i < N + 1; i++) {
			if (arr[i] == 0) {
				queue.add(i);
			}
		}
		sb = new StringBuilder();
		bfs();
		System.out.println(sb);

	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now + " ");
			for (int next : graph.get(now)) {
				arr[next]--;
				if (arr[next] == 0) {
					queue.add(next);
				}
			}
		}
	}
}