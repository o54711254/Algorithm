import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visit;
	static int[] dist;
	static ArrayList<ArrayList<Node>> graph;
	static final int INF = 200000000;
	static int N, count, Max;

	public static class Node implements Comparable<Node> {
		int v;
		int w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			graph = new ArrayList<>();
			visit = new boolean[N + 1];
			dist = new int[N + 1];
			for (int i = 0; i < N + 1; i++) {
				graph.add(new ArrayList<>());
				dist[i] = INF;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				graph.get(b).add(new Node(a, s));
			}
			count = 0;
			Max = 0;

			bfs(new Node(start, 0));
			System.out.println(count + " " + Max);

		}
	}

	public static void bfs(Node start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(start);

		dist[start.v] = 0;
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if (!visit[now.v]) {
				count++;
				visit[now.v] = true;
				for (int i = 0; i < graph.get(now.v).size(); i++) {
					Node next = graph.get(now.v).get(i);
					if (dist[next.v] > dist[now.v] + next.w) {
						dist[next.v] = dist[now.v] + next.w;
						queue.add(new Node(next.v, dist[next.v]));
					}
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (dist[i] > Max && visit[i]) {
				Max = dist[i];
			}
		}
	}
}