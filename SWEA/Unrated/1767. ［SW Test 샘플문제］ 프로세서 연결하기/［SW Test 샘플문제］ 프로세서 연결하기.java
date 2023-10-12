
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int result;
	static boolean[] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static ArrayList<Point> coreList;
	static ArrayList<Point> useList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			coreList = new ArrayList<>();

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						coreList.add(new Point(i, j));
					}
				}
			}
			result = Integer.MAX_VALUE;
			for (int i = coreList.size(); i >= 0; i--) {
				visit = new boolean[coreList.size()];
				combination(0, i, 0);
				if (result != Integer.MAX_VALUE) {
					break;
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}

	static void combination(int depth, int r, int start) {
		if (depth == r) {
			useList = new ArrayList<>();
			for (int i = 0; i < coreList.size(); i++) {
				if (visit[i]) {
					useList.add(coreList.get(i));
				}
			}
			dfs(0);
			return;
		}
		for (int i = start; i < coreList.size(); i++) {
			visit[i] = true;
			combination(depth + 1, r, i + 1);
			visit[i] = false;
		}
	}

	static void dfs(int depth) {
		if (depth == useList.size()) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == -1) {
						sum++;
					}
				}
			}
			result = Math.min(result, sum);
			return;
		}
		int[][] copy = new int[N][N];

		Point p = useList.get(depth);
		for (int dir = 0; dir < 4; dir++) {
			copy(copy, map);
			if (connect(p, dir)) {
				dfs(depth + 1);
			}
			copy(map, copy);
		}
	}

	static boolean connect(Point p, int dir) {
		int x = p.x;
		int y = p.y;
		while (true) {
			x += dr[dir];
			y += dc[dir];
			if (x < 0 || y < 0 || x >= N || y >= N) {
				return true;
			}
			if (map[x][y] == 1 || map[x][y] == -1) {
				return false;
			}
			map[x][y] = -1;
		}
	}

	static void copy(int[][] copy, int[][] map) {
		for (int i = 0; i < N; i++) {
			copy[i] = map[i].clone();
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
}