import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dust {
	int x;
	int y;
	int w;

	public Dust(int x, int y, int w) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
	}
}

public class Main {
	static int[][] map;
	static boolean[][] check;
	static int R, C;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int airFilter1;
	static int airFilter2;
	static Queue<Dust> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		check = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == -1) {
					airFilter2 = i;
				}
			}
		}
		airFilter1 = airFilter2 - 1;
		for (int i = 1; i <= T; i++) {
			check();
			diffusion();
			move();
		}

		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					sum += map[i][j];
				}
			}
		}
		System.out.println(sum);
	}

	public static void check() {
		queue = new LinkedList<Dust>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					queue.add(new Dust(i, j, map[i][j]));
				}
			}
		}
	}

	static void diffusion() {
		while (!queue.isEmpty()) {
			Dust now = queue.poll();
			int count = 0;
			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == -1) {
					continue;
				}
				map[nr][nc] += now.w / 5;
				count++;
			}
			map[now.x][now.y] -= count * (now.w / 5);
		}
	}

	static void move() {
		int top = airFilter1;
		for (int i = top - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		for (int i = 0; i < top; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) {
			map[top][i] = map[top][i - 1];
		}
		map[top][1] = 0;

		int down = airFilter2;

		for (int i = down + 1; i < R - 1; i++)
			map[i][0] = map[i + 1][0];
		for (int i = 0; i < C - 1; i++)
			map[R - 1][i] = map[R - 1][i + 1];
		for (int i = R - 1; i > down; i--)
			map[i][C - 1] = map[i - 1][C - 1];
		for (int i = C - 1; i > 1; i--)
			map[down][i] = map[down][i - 1];
		map[down][1] = 0;

	}

}