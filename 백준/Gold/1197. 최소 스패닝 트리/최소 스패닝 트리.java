import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Edge {
	int from;
	int to;
	int w;

	public Edge(int from, int to, int w) {
		super();
		this.from = from;
		this.to = to;
		this.w = w;
	}
}

public class Main {
	static ArrayList<Edge> edgeList;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		edgeList = new ArrayList<Edge>();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edgeList.add(new Edge(u, v, w));
		}

		Collections.sort(edgeList, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.w - o2.w;
			}
		});

		int sum = 0;
		int count = 0;
		for (int i = 0; i < M; i++) {
			int a = edgeList.get(i).from;
			int b = edgeList.get(i).to;

			if (union(a, b)) {
				sum += edgeList.get(i).w;
				count++;
				if (count == M - 1) {
					break;
				}
			}
		}
		System.out.println(sum);
	}

	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) {
			return false;
		}
		if (x >= y) {
			parent[x] = y;
		} else {
			parent[y] = x;
		}
		return true;
	}
}