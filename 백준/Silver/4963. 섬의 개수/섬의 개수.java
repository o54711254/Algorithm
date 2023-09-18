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
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			if (c == 0 && r == 0) {
				break;
			}
			map = new int[r][c];
			visit = new boolean[r][c];

			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] == 1 && !visit[i][j]) {
						dfs(new Point(i, j));
						count++;
					}
				}
			}
			System.out.println(count);

		}
	}

	public static void dfs(Point p) {
		visit[p.x][p.y] = true;

		int r = map.length;
		int c = map[0].length;

		for (int i = 0; i < 8; i++) {
			int nr = p.x + dr[i];
			int nc = p.y + dc[i];
			if (nr < 0 || nc < 0 || nr >= r || nc >= c || map[nr][nc] == 0 || visit[nr][nc]) {
				continue;
			}
			dfs(new Point(nr, nc));

		}
	}
}