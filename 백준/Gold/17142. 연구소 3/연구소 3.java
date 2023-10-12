import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int sec;

	public Point(int x, int y, int sec) {
		super();
		this.x = x;
		this.y = y;
		this.sec = sec;
	}
}

public class Main {
	static int N, M, zero;
	static int result = Integer.MAX_VALUE;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static int[][] virus;
	static boolean[] select;
	static ArrayList<Point> list;
	static Queue<Point> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list.add(new Point(i, j, 0));
				}
				if (map[i][j] == 0) {
					zero++;
				}
			}
		}

		// 어떤거 쓸지 결정
		select = new boolean[list.size()];
		dfs(0, 0);
		if (result == Integer.MAX_VALUE) {
			result = -1;
		}
		System.out.println(result);
	}

	static void dfs(int depth, int start) {
		if (depth == M) {
			queue = new LinkedList<>();
			for (int i = 0; i < select.length; i++) {
				if (select[i]) {
					queue.add(list.get(i));
				}
			}
			bfs();
			return;
		}
		for (int i = start; i < list.size(); i++) {
			select[i] = true;
			dfs(depth + 1, i + 1);
			select[i] = false;
		}
	}

	static void bfs() {
		boolean[][] visit = new boolean[N][N];
		virus = new int[N][N];

		int count = 0;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			visit[now.x][now.y] = true;
			virus[now.x][now.y] = now.sec;
			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1 || visit[nr][nc]) {
					continue;
				}
				if (map[nr][nc] == 0) {
					count++;
				}
				queue.add(new Point(nr, nc, now.sec + 1));
				visit[nr][nc] = true;
			}
		}
		if (count != zero) {
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			virus[list.get(i).x][list.get(i).y] = 0;
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, virus[i][j]);
			}
		}
		result = Math.min(result, max);
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}