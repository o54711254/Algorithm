import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int v;
	int w;

	public Node(int v, int w) {
		super();
		this.v = v;
		this.w = w;
	}

}

public class Main {
	static ArrayList<ArrayList<Node>> graph;
	static boolean visit[];
	static int[] dist;
	static final int INF = 200000000;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N + 1];
		dist = new int[N + 1];
		graph = new ArrayList<>();

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
			dist[i] = INF;
		}

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph.get(u).add(new Node(v, w));
		}
		prim(new Node(K, 0));

		for (int i = 1; i < N + 1; i++) {
			if (dist[i] == INF) {
				System.out.println("INF");
			}else {
				
			System.out.println(dist[i]);
			}
		}

	}

	public static void prim(Node start) {
		PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.w - o2.w;
			}
		});
		queue.add(start);
		dist[start.v] = start.w;
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if (!visit[now.v]) {
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

	}
}