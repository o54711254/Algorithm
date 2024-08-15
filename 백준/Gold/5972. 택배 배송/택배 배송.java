import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int dir;
	int value;

	public Node(int dir, int value) {
		this.dir = dir;
		this.value = value;
	}

	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "dir : " + dir + " " + "value : " + value;
	}
}

class Main {
	static int N, M;
	static ArrayList<ArrayList<Node>> graph;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			result[i] = 987654321;
		}

		graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			graph.get(A).add(new Node(B, C));
			graph.get(B).add(new Node(A, C));
		}

		bfs(new Node(1, 0));
		System.out.println(result[N]);

	}

	static void bfs(Node start) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(start);
		result[start.dir] = 0;
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			for (Node next : graph.get(now.dir)) {
				if (result[next.dir] > result[now.dir] + next.value) {
					result[next.dir] = result[now.dir] + next.value;
					queue.add(next);
				}
			}
		}
	}
}