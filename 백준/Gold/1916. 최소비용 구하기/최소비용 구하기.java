import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
	static boolean[] visit;
	static int[] dist;
	static final int INF = 200000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		visit = new boolean[N + 1];
		dist = new int[N + 1];
		graph = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Node>());
			dist[i] = INF;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, c));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		Dijkstra(new Node(start, 0));


		System.out.println(dist[end]);

	}

	public static void Dijkstra(Node start) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.w - o2.w;
			}
		});

		queue.add(start);
		
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if (!visit[now.v]) {
				visit[now.v] = true;
				dist[now.v] = now.w;
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