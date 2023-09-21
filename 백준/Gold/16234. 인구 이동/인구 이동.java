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
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, L, R;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		while (true) {
			visit = new boolean[N][N];
			flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						bfs(new Point(i, j));
					}
				}
			}
			if(!flag) {
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}

	public static void bfs(Point p) {
		Queue<Point> queue = new LinkedList<Point>();
		Queue<Point> result = new LinkedList<Point>();
		queue.add(p);
		result.add(p);
		visit[p.x][p.y] = true;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && R >= Math.abs(map[nr][nc] - map[now.x][now.y])
						&& L <= Math.abs(map[nr][nc] - map[now.x][now.y]) && !visit[nr][nc]) {
					queue.add(new Point(nr, nc));
					result.add(new Point(nr, nc));
					visit[nr][nc] = true;
				}
			}

		}

		int sum = 0;
		int count = result.size();
		
		if(count >= 2) {
			flag = true;
		}
		for (Point x : result) {
			sum += map[x.x][x.y];
		}
		sum = sum / count;
		while (!result.isEmpty()) {
			Point nowResult = result.poll();
			map[nowResult.x][nowResult.y] = sum;
		}
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}