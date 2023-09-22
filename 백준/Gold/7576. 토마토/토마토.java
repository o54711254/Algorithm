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
	static int N, M;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt;
	static Queue<Point> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		queue = new LinkedList<Point>();
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					queue.add(new Point(i, j));
					visit[i][j] = true;
				}
			}
		}
		bfs();
		cnt = cnt - 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					cnt = -1;
				}
			}
		}
		System.out.println(cnt);

	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Point now = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nr = now.x + dr[i];
					int nc = now.y + dc[i];
					if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == -1 || visit[nr][nc]) {
						continue;
					}
					queue.add(new Point(nr, nc));
					visit[nr][nc] = true;
					map[nr][nc] = 1;
				}
			}

			cnt++;

		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}