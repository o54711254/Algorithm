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
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N;
	static boolean flag;
	static int ans;
	static final int INF = 200000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
				dist[i][j] = INF;
			}
		}
		bfs(new Point(0, 0));
		System.out.println(dist[N - 1][N - 1]);
	}

	static void bfs(Point p) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(p);
		dist[p.x][p.y] = 0;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
					continue;
				}
				if (dist[nr][nc] > dist[now.x][now.y]) {
					if (map[nr][nc] == 1) {
						dist[nr][nc] = dist[now.x][now.y];
					} else {
						dist[nr][nc] = dist[now.x][now.y] + 1;
					}
					queue.add(new Point(nr, nc));
				}

			}
		}

	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}
}