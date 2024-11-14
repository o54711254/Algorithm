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
	static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();

	static int maxNode;
	static int maxDistance;

	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}

		visit = new boolean[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int nodeNum = Integer.parseInt(st.nextToken());

			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if (num == -1) {
					break;
				} else {
					int distance = Integer.parseInt(st.nextToken());
					list.get(nodeNum).add(new Node(num, distance));
				}
			}
		}

		maxDistance = 0;

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