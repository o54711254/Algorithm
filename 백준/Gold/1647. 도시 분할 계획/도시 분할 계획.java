import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static boolean[] visit;
	static int sum;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		visit = new boolean[N + 1];
		graph = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Node>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		sum = 0;
		prim(new Node(1, 0));
		System.out.println(sum-max);
	}

	public static void prim(Node start) {
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
				sum += now.w;
				max = Math.max(max, now.w);
				for (int i = 0; i < graph.get(now.v).size(); i++) {
					Node next = graph.get(now.v).get(i);
					queue.add(next);
				}
			}
		}
	}
}