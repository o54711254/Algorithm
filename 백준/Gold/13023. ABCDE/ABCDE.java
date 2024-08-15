import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	static int N, M;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visit;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph.get(A).add(B);
			graph.get(B).add(A);
		}

		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			visit[i] = true;
			search(0, i);
			visit[i] = false;
			if (flag) {
				break;
			}
		}

		if (flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	static void search(int depth, int now) {
		if (depth == 4) {
			flag = true;
			return;
		}

		for (int i = 0; i < graph.get(now).size(); i++) {
			int next = graph.get(now).get(i);
			if (!visit[next]) {
				visit[next] = true;
				search(depth + 1, next);
				visit[next] = false;
			}
		}
	}

	static boolean check(boolean[] visit) {
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				return false;
			}
		}
		return true;
	}
}