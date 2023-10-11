import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int M, K, N, ans;
	private static int[][] map;
	private static boolean finish = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];

		int x, y;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[x][y + 1] = 2;
		}

		for (int i = 0; i <= 3; i++) {
			ans = i;
			dfs(1, 0);
			if (finish) {
				break;
			}
		}

		System.out.println((finish) ? ans : -1);
	}

	private static void dfs(int x, int count) {
		if (finish) {
			return;
		}
		if (ans == count) {
			if (check()) {
				finish = true;
			}
			return;
		}

		for (int i = x; i < N + 1; i++) {
			for (int j = 1; j < M; j++) {
				if (map[i][j] == 0 && map[i][j + 1] == 0) {
					map[i][j] = 1;
					map[i][j + 1] = 2;
					dfs(i, count + 1);
					map[i][j] = map[i][j + 1] = 0;
				}
			}
		}
	}

	static boolean check() {
		for (int i = 1; i <= M; i++) {
			if (i != move(new Point(1, i))) {
				return false;
			}
		}
		return true;
	}

	static int move(Point p) {
		while (p.x <= N) {
			if (map[p.x][p.y] == 1) {
				p.y++;
			} else if (map[p.x][p.y] == 2) {
				p.y--;
			}
			p.x++;
		}
		return p.y;

	}
}