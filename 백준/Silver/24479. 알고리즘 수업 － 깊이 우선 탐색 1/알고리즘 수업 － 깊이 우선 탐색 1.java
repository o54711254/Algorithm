import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	// 그래프 생성
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	// 방문확인용 배열
	static int[] check;
	// 방문 순서
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 정점의 수
		int N = Integer.parseInt(st.nextToken());
		// 간선의 수
		int M = Integer.parseInt(st.nextToken());
		// 시작 정점
		int R = Integer.parseInt(st.nextToken());

		check = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			// 정점 생성
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// 출발
			int u = Integer.parseInt(st.nextToken());
			// 도착
			int v = Integer.parseInt(st.nextToken());

			// 값 넣어줌
			graph.get(u).add(v);
			// 무방향이므로 반대로도 넣어줌
			graph.get(v).add(u);
		}

		for (int i = 1; i < graph.size(); i++) {
			Collections.sort(graph.get(i));
		}

		count = 1;

		dfs(R);

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < check.length; i++) {
			sb.append(check[i]).append("\n");
		}
		System.out.println(sb);

	}

	public static void dfs(int vertex) {
		check[vertex] = count;

		for (int i = 0; i < graph.get(vertex).size(); i++) {
			int newVertex = graph.get(vertex).get(i);

			if (check[newVertex] == 0) {
				count++;
				dfs(newVertex);
			}
		}
	}
}
