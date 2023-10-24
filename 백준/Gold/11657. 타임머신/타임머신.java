import java.util.*;
import java.io.*;

class Edge {
	int start;
	int end;
	int cost;

	public Edge(int start, int end, int cost) {
		super();
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Edge [start=" + start + ", end=" + end + ", cost=" + cost + "]";
	}

}

public class Main {
	static int N, M;
	static int INF = 200000000;
	static long[] dist;
	static ArrayList<Edge> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edges = new ArrayList<>();
		dist = new long[N + 1];
		Arrays.fill(dist, INF);
		dist[1] = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges.add(new Edge(a, b, c));
		}

		if (!bellmanFord()) {
			System.out.println(-1);
		} else {
			StringBuilder sb = new StringBuilder();

			for (int i = 2; i <= N; i++) {
				if (dist[i] == INF) {

					sb.append(-1).append("\n");
				} else {
					sb.append(dist[i]).append("\n");
				}
			}
			System.out.println(sb);
		}

	}

	static boolean bellmanFord() {
		// 정점의 개수만큼
		for (int i = 0; i < N; i++) {
			// 간선의 개수만큼
			for (int j = 0; j < M; j++) {
				Edge edge = edges.get(j);

				if (dist[edge.start] != INF) {
					if (dist[edge.end] > dist[edge.start] + edge.cost) {
						dist[edge.end] = dist[edge.start] + edge.cost;
					}
				}
			}
		}

		// 음수 가중치 확인
		// 값이 바뀌면 false
		for (int i = 0; i < M; i++) {
			Edge edge = edges.get(i);

			if (dist[edge.start] != INF) {
				if (dist[edge.end] > dist[edge.start] + edge.cost) {
					return false;
				}
			}
		}
		return true;
	}
}