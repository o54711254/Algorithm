import java.io.*;
import java.util.*;

class Main {
	static int N;
	static final int INF = 2000000000;
	static int resultValue = INF;
	static int[] arr;
	static int[] result;
	static boolean[] visit;
	static List<List<Integer>> graph = new ArrayList<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		while (true) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (A == -1 && B == -1) {
				break;
			}

			graph.get(A).add(B);
			graph.get(B).add(A);
		}

		arr = new int[N + 1];
		visit = new boolean[N + 1];
		result = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			initArr();
			bfs(i);
			checkResult(i);
		}

		makeResult();
		System.out.println(sb);

	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		arr[start] = 0;
		visit[start] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < graph.get(now).size(); i++) {
				int next = graph.get(now).get(i);
				if (!visit[next]) {
					queue.add(next);
					visit[next] = true;
					arr[next] = arr[now] + 1;
				}
			}
		}
	}

	static void initArr() {
		for (int i = 1; i <= N; i++) {
			arr[i] = INF;
			visit[i] = false;
		}
	}

	static void checkResult(int num) {
		int temp = 0;

		for (int i = 1; i <= N; i++) {
			temp = Math.max(temp, arr[i]);
		}
		resultValue = Math.min(temp, resultValue);

		result[num] = temp;
	}

	static void makeResult() {
		List<Integer> temp = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			if (resultValue == result[i]) {
				temp.add(i);
			}
		}

		sb.append(resultValue).append(" ").append(temp.size()).append("\n");
		for (int i = 0; i < temp.size(); i++) {
			sb.append(temp.get(i)).append(" ");
		}
	}
}