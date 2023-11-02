import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt;
	static int start = 1, end = 100;
	static boolean[] visited;
	static Map<Integer, Integer> things;

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[101];
		things = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			things.put(x, y);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			things.put(x, y);
		}

		bfs();

		System.out.println(cnt);

	}// main

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int take = q.poll();

				for (int j = 1; j <= 6; j++) {
					int next = take + j;

					if (next == end)
						return;
					if (visited[next])
						continue;

					visited[next] = true;
					if (things.containsKey(next)) {
						next = things.get(next);
					}
					q.add(next);
				}

			}

		} // while

	}// bfs

}