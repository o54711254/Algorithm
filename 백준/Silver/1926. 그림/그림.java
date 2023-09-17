import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					bfs(new Point(i, j));
					list.add(cnt);
					cnt = 0;
				}
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		if(list.isEmpty()) {
			System.out.println(0);
		}else {
			System.out.println(list.get(list.size() - 1));
		}
	}

	static void bfs(Point p) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(p);
		visit[p.x][p.y] = true;
		cnt = 1;

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0 || visit[nr][nc]) {
					continue;
				}
				queue.add(new Point(nr, nc));
				visit[nr][nc] = true;
				cnt++;
			}
		}

	}
}