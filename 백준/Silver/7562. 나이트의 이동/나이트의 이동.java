import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -2, -2, 2, 2, -1, 1, -1, 1 };
	static int[] dc = { -1, 1, -1, 1, -2, -2, 2, 2 };
	static int count;
	static int end1;
	static int end2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			visit = new boolean[N][N];

			st = new StringTokenizer(br.readLine());
			int start1 = Integer.parseInt(st.nextToken());
			int start2 = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			end1 = Integer.parseInt(st.nextToken());
			end2 = Integer.parseInt(st.nextToken());

			count = 0;
			bfs(new Point(start1, start2));
			System.out.println(count);
		}
	}

	public static void bfs(Point p) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(p);
		visit[p.x][p.y] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				size--;
				Point now = queue.poll();

				if (now.x == end1 && now.y == end2) {
					return;
				}
				for (int i = 0; i < 8; i++) {
					int nr = now.x + dr[i];
					int nc = now.y + dc[i];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc]) {
						continue;
					}
					queue.add(new Point(nr, nc));
					visit[nr][nc] = true;
				}
			}
			count++;
		}
	}
}