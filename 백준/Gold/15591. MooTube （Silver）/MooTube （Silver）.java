import java.util.*;
import java.io.*;

class Path {
	int destination;
	int usado;

	public Path(int destination, int usado) {
		this.destination = destination;
		this.usado = usado;
	}
}

public class Main {
	static List<List<Path>> pathList = new ArrayList<>();
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		visit = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			pathList.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			pathList.get(p).add(new Path(q, r));
			pathList.get(q).add(new Path(p, r));
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			visit = new boolean[N + 1];
			int count = bfs(v, k);
			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}

	private static int bfs(int start, int k) {
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visit[start] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (Path path : pathList.get(now)) {
				if (!visit[path.destination]) {
					visit[path.destination] = true;
					if (path.usado >= k) {
						count++;
						queue.add(path.destination);
					}
				}
			}
		}
		return count;
	}
}