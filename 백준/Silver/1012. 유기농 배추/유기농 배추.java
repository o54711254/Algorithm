import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			// 가로길이
			int M = Integer.parseInt(st.nextToken());
			// 세로길이
			int N = Integer.parseInt(st.nextToken());
			// 배추의 개수
			int K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visit = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[y][x] = 1;
			}

			cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visit[i][j]) {
						bfs(new Point(i, j));
					}
				}
			}
			System.out.println(cnt);
		}
	}

	static void bfs(Point p) {
		cnt++;
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(p);
		visit[p.x][p.y] = true;
		int N = map.length;
		int M = map[0].length;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0 || visit[nr][nc]) {
					continue;
				}
				queue.add(new Point(nr, nc));
				visit[nr][nc] = true;
			}
		}
	}

}