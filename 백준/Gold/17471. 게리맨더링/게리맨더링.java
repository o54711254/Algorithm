import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] people;
	static boolean[] select;
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> graph;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		// 인구수 배열
		people = new int[N + 1];
		// 구역 나누는데 쓰일 체크 배열
		select = new boolean[N + 1];
		// bfs용 visit배열
		visit = new boolean[N + 1];

		// 인구수 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		// 그래프 입력
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph.get(i).add(num);
			}
		}
		dfs(1);
		if (result == Integer.MAX_VALUE) {
			result = -1;
		}
		System.out.println(result);
	}

	static void dfs(int depth) {
		if (depth == N + 1) {
			ArrayList<Integer> aList = new ArrayList<Integer>();
			ArrayList<Integer> bList = new ArrayList<Integer>();
			for (int i = 1; i <= N; i++) {
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
		visit = new boolean[N + 1];
		visit[list.get(0)] = true;
		queue.add(list.get(0));

		int count = 1;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < graph.get(now).size(); i++) {
				int next = graph.get(now).get(i);
				if (!list.contains(next) || visit[next]) {
					continue;
				}
				queue.add(next);
				visit[next] = true;
				count++;
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
		for (int i = 1; i <= N; i++) {
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