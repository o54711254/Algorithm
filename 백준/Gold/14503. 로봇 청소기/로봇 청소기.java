import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] visit;
	static int N, M, dir;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int startR = Integer.parseInt(st.nextToken());
		int startC = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(new Point(startR, startC), dir);

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) {
					count++;
				}
			}
		}
		System.out.println(count);

	}

	static void dfs(Point p, int direction) {
		map[p.x][p.y] = -1;
		
		for (int i = 0; i < 4; i++) {
			direction = (direction + 3) % 4;
			int nr = p.x + dr[direction];
			int nc = p.y + dc[direction];
			if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
				dfs(new Point(nr, nc), direction);
				return;
			}
		}

		int back = (direction + 2) % 4;
		int br = p.x + dr[back];
		int bc = p.y + dc[back];
		if (br >= 0 && bc >= 0 && br < N && bc < M && map[br][bc] != 1) {
			dfs(new Point(br, bc), direction);
		}
	}
}