import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int result = Integer.MAX_VALUE;
	static int[] people;
	static boolean[] select;
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		people = new int[N];
		select = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph.get(i).add(num - 1);
			}
		}
		dfs(0);
		if (result == Integer.MAX_VALUE)
			result = -1;
		System.out.println(result);
	}

	static void dfs(int depth) {
		if (depth == N) {
			ArrayList<Integer> aList = new ArrayList<Integer>();
			ArrayList<Integer> bList = new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				if (select[i]) {
					aList.add(i);
				} else {
					bList.add(i);
				}
			}
			if (aList.size() == 0 || bList.size() == 0) {
				return;
			}
			if (bfs(aList) && bfs(bList)) {
				getDiff();
			}
			return;
		}
		select[depth] = true;
		dfs(depth + 1);
		select[depth] = false;
		dfs(depth + 1);
	}

	static boolean bfs(ArrayList<Integer> list) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visit = new boolean[N];
		visit[list.get(0)] = true;
		queue.add(list.get(0));

		int count = 1;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < graph.get(now).size(); i++) {
				int next = graph.get(now).get(i);
				if (list.contains(next) && !visit[next]) {
					queue.add(next);
					visit[next] = true;
					count++;
				}
			}
		}
		if (count == list.size()) {
			return true;
		} else {
			return false;
		}
	}

	static void getDiff() {
		int a = 0;
		int b = 0;
		for (int i = 0; i < N; i++) {
			if (select[i]) {
				a += people[i];
			} else {
				b += people[i];
			}
		}
		int diff = Math.abs(a - b);
		result = Math.min(result, diff);
	}
}