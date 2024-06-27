import java.io.*;
import java.util.*;
import java.util.List;
import java.awt.*;

public class Main {
	static int N, M, K;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static List<Integer> result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int j = x1 + 1; j <= x2; j++) {
				for (int k = y1 + 1; k <= y2; k++) {
					map[k][j]++;
				}
			}
		}

		result = new ArrayList<Integer>();

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				if (map[i][j] == 0 && !visit[i][j]) {
					bfs(new Point(i, j));
				}
			}
		}

		Collections.sort(result);

		sb = new StringBuilder();
		int size = result.size();
		sb.append(size).append("\n");

		for (int i = 0; i < size; i++) {
			sb.append(result.get(i)).append(" ");
		}

		System.out.println(sb);
	}

	static void bfs(Point start) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(start);
		visit[start.x][start.y] = true;
		int number = 1;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			int nr = 0;
			int nc = 0;
			for (int i = 0; i < 4; i++) {
				nr = now.x + dr[i];
				nc = now.y + dc[i];
				if (nr < 1 || nc < 1 || nr >= N + 1 || nc >= M + 1 || map[nr][nc] != 0 || visit[nr][nc]) {
					continue;
				}
				visit[nr][nc] = true;
				number++;
				queue.add(new Point(nr, nc));
			}
		}
		result.add(number);
		return;
	}

	static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}