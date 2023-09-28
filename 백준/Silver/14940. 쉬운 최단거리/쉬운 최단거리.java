import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] result;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		result = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					bfs(new Point(i, j), 0);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && result[i][j] == 0) {
					result[i][j] = -1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void bfs(Point p, int dist) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(p);
		result[p.x][p.y] = dist++;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Point now = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nr = now.x + dr[i];
					int nc = now.y + dc[i];
					if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] != 1 || result[nr][nc] != 0) {
						continue;
					}
					queue.add(new Point(nr, nc));
					result[nr][nc] = dist;
				}
			}
			dist++;
		}
	}
}