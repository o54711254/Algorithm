import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M, K, N;
	static int[][] map;
	static boolean[][] ladder;
	static int[] dr = { 1, 0, 0 };
	static int[] dc = { 0, 1, -1 };
	static int answer = 4;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		ladder = new boolean[N + 1][M + 1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			ladder[a][b] = true;
		}

		dfs(1, 0);
		 System.out.println((answer != 4) ? answer : -1);

	}

	private static void dfs(int x, int count) {
		if (answer <= count)
			return;
		else {
			if (check()) {
				answer = count;
				return;
			}
		}

		for (int i = x; i < N + 1; i++) {
			for (int j = 1; j < M; j++) {
				if (!ladder[i][j]) {
					ladder[i][j] = true;
					dfs(i, count + 1);
					ladder[i][j] = false;
				}
			}
		}
	}

	static boolean check() {
		int cnt = 0;

		for (int i = 1; i <= M; i++) {
			if (i == bfs(new Point(1, i))) {
				cnt++;
			}
		}

		if (M == cnt) {
			return true;
		} else {
			return false;
		}

	}

	static int bfs(Point p) {
		while (p.x <= N) {
			if (ladder[p.x][p.y]) {
				p.y++;
			} else if (p.y > 1 && ladder[p.x][p.y - 1]) {
				p.y--;
			}
			p.x++;
		}
		return p.y;
	}
}