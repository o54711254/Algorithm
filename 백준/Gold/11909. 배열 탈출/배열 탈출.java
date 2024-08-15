import java.io.*;
import java.util.*;
import java.awt.*;

class Main {
	static int N;
	static int[][] map;
	static int[][] result;
	static int[] dr = { 1, 0 };
	static int[] dc = { 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		result = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				result[i][j] = 987654321;
			}
		}
		bfs(new Point(0, 0));
		System.out.println(result[N - 1][N - 1]);

	}

	static void bfs(Point start) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(start);
		result[start.x][start.y] = 0;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 2; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
					continue;
				}
				if (map[nr][nc] >= map[now.x][now.y]) {
					int need = map[nr][nc] + 1 - map[now.x][now.y];
					if (result[nr][nc] > result[now.x][now.y] + need) {
						result[nr][nc] = result[now.x][now.y] + need;
						queue.add(new Point(nr, nc));
					}
				} else {
					if (result[nr][nc] > result[now.x][now.y]) {
						result[nr][nc] = result[now.x][now.y];
						queue.add(new Point(nr, nc));
					}
				}
			}
		}
	}

	static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}