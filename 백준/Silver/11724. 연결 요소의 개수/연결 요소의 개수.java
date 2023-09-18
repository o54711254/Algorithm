import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visit;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}
		visit = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list.get(u).add(v);
			list.get(v).add(u);
		}
		count = 0;
		for (int i = 1; i <= N; i++) {
			if(!visit[i]) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}

	static void dfs(int vertex) {
		visit[vertex] = true;
		for (int i = 0; i < list.get(vertex).size(); i++) {
			int newVertex = list.get(vertex).get(i);
			if (!visit[newVertex]) {
				dfs(newVertex);
			}
		}
	}
}