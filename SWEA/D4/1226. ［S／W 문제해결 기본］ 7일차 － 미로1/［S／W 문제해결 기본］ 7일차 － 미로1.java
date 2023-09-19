import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static boolean[][] visit;
	static int N = 16;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			int test = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 2 && !visit[i][j]) {
						dfs(new Point(i, j));
					}
				}
			}
			System.out.println("#" + test + " " + ans);

		}
	}

	public static void dfs(Point p) {
		visit[p.x][p.y] = true;

		for (int i = 0; i < 4; i++) {
			int nr = p.x + dr[i];
			int nc = p.y + dc[i];
			if (map[nr][nc] == 3) {
				ans = 1;
				return;
			}
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1 || visit[nr][nc]) {
				continue;
			}
			dfs(new Point(nr, nc));
		}
	}
}