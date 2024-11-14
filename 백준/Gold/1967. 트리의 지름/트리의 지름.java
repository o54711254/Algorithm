import java.io.*;
import java.util.*;
import java.awt.*;

class Node {
	int num;
	int distance;

	public Node(int num, int distance) {
		this.num = num;
		this.distance = distance;
	}
}

class Main {
	static int N;

	static int maxNode;
	static int maxDistance;

	static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		N = Integer.parseInt(br.readLine());

		visit = new boolean[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			list.get(start).add(new Node(end, distance));
			list.get(end).add(new Node(start, distance));
		}
		visit = new boolean[N + 1];

		dfs(1, 0);

		visit = new boolean[N + 1];

		dfs(maxNode, 0);
		System.out.println(maxDistance);

	}

	static void dfs(int start, int distance) {
		visit[start] = true;
		if (distance > maxDistance) {
			maxNode = start;
			maxDistance = distance;
		}

		for (int i = 0; i < list.get(start).size(); i++) {
			Node next = list.get(start).get(i);
			if (!visit[next.num]) {
				dfs(next.num, distance + next.distance);
			}
		}
	}
}