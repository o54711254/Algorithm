import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visit;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M;
	static int Max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(new Point(i, j), 0, 0);
			}
		}

		System.out.println(Max);

	}

	public static void dfs(Point p, int sum, int depth) {
		if (depth == 4) {
			Max = Math.max(sum, Max);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = p.x + dr[i];
			int nc = p.y + dc[i];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc]) {
				continue;
			}
			if (depth == 2) {
				visit[nr][nc] = true;
				dfs(p, sum + map[nr][nc], depth + 1);
				visit[nr][nc] = false;
			}
			visit[nr][nc] = true;
			dfs(new Point(nr, nc), sum + map[nr][nc], depth + 1);
			visit[nr][nc] = false;
		}

	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(visit[i][j] + " ");
			}
			System.out.println();
		}
	}
}