import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
	static int N;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[][] map;

	static ArrayList<Point> teacher = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] == 'T') {
					teacher.add(new Point(i, j));
				}
			}
		}

		combination(0);
		System.out.println("NO");

	}

	static void combination(int depth) {
		if (depth == 3) {
			if (check()) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'X') {
					map[i][j] = 'O';
					combination(depth + 1);
					map[i][j] = 'X';
				}
			}
		}
	}

	static boolean check() {
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < teacher.size(); i++) {
			queue.add(teacher.get(i));
		}

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = now.x;
				int nc = now.y;

				while (true) {
					nr += dr[i];
					nc += dc[i];

					if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 'O') {
						break;
					}

					if (map[nr][nc] == 'S') {
						return false;
					}
				}

			}
		}
		return true;
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}