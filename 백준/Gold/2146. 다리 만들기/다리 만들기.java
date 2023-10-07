import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int cnt;

	public Point(int x, int y, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

}

public class Main {
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N;
	static int temp = 2;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 섬 이름 붙이기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					numbering(new Point(i, j, 0));
					temp++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					visit = new boolean[N][N];
					bfs(new Point(i, j, 0), map[i][j]);
				}
			}
		}
		System.out.println(min);

	}

	static void bfs(Point p, int x) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(p);
		visit[p.x][p.y] = true;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == x || visit[nr][nc]) {
					continue;
				}
				visit[nr][nc] = true;
				if (map[nr][nc] > 0 && map[nr][nc] != x) {
					min = Math.min(min, now.cnt);
					return;
				} else {
					queue.add(new Point(nr, nc, now.cnt+1));
				}
			}
		}
	}

	static void numbering(Point p) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(p);
		visit[p.x][p.y] = true;
		map[p.x][p.y] = temp;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 0 || visit[nr][nc]) {
					continue;
				}
				map[nr][nc] = temp;
				visit[nr][nc] = true;
				queue.add(new Point(nr, nc, 0));
			}
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}