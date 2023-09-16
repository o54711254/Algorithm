import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][] dist;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// map
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(new Point(0, 0));

		System.out.println(dist[N-1][M-1]+1);

	}

	public static void bfs(Point p) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(p);
		visit[p.x][p.y] = true;
		int N = map.length;
		int M = map[0].length;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			if (now.x == N - 1 && now.y == M - 1) {
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0 || visit[nr][nc] == true) {
					continue;
				}
				queue.add(new Point(nr, nc));
				visit[nr][nc] = true;
				dist[nr][nc] = dist[now.x][now.y] + 1;
			}
			count++;
		}
	}
}