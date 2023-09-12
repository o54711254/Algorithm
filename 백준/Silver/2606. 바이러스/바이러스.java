import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visit;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 컴퓨터의 수
		int N = Integer.parseInt(br.readLine());

		// 간선의 수
		int M = Integer.parseInt(br.readLine());

		// 컴퓨터의 수+1 만큼 ArrayList 추가 -> 인덱스 안했갈리게
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}

		// 연결정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		visit = new boolean[N + 1];
		count = 0;

		dfs(1);

		System.out.println(count);
	}

	public static void dfs(int vertex) {
		visit[vertex] = true;

		for (int i = 0; i < graph.get(vertex).size(); i++) {
			int newVertex = graph.get(vertex).get(i);

			if (visit[newVertex] == false) {
				count++;
				dfs(newVertex);
			}
		}

	}
}
