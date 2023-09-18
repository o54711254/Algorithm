import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static char[][] map2;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int normal;
	static int handi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		map2 = new char[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				map2[i][j] = str.charAt(j);
				if (map2[i][j] == 'G') {
					map2[i][j] = 'R';
				}
			}
		}


		normal = 0;
		handi = 0;
		// 노말
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'R' && !visit[i][j]) {
					bfs('R', new Point(i, j), map);
					normal++;
				}
				if (map[i][j] == 'G' && !visit[i][j]) {
					bfs('G', new Point(i, j), map);
					normal++;
				}
				if (map[i][j] == 'B' && !visit[i][j]) {
					bfs('B', new Point(i, j), map);
					normal++;
				}
			}
		}

		visit = new boolean[N][N];

		// 장애인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map2[i][j] == 'R' && !visit[i][j]) {

					bfs('R', new Point(i, j), map2);
					handi++;
				}

				if (map2[i][j] == 'B' && !visit[i][j]) {
					bfs('B', new Point(i, j), map2);
					handi++;

				}
			}
		}

		System.out.println(normal + " " + handi);

	}

	public static void bfs(char c, Point p, char[][] a) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(p);
		visit[p.x][p.y] = true;
		int N = map.length;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || a[nr][nc] != c || visit[nr][nc]) {
					continue;
				}
				queue.add(new Point(nr, nc));
				visit[nr][nc] = true;
			}
		}
	}
}