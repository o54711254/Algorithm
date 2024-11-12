import java.io.*;
import java.util.*;
import java.awt.*;

/*
 * 1. 바이러스 시작 위치 정해야 함 -> 조합을 이용(ㅇ)
 * 2. bfs 를 이용하여 탐색 
 * 3. 최소시간 구해야 함 */

class Virus {
	int r;
	int c;

	public Virus(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static int M;
	static int result = Integer.MAX_VALUE;

	static int[][] map;
	static int[][] moveMap;
	static boolean[][] visit;
	static ArrayList<Virus> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		moveMap = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list.add(new Virus(i, j));
				}
			}
		}

		int[] arr = new int[M];
		combination(arr, 0, 0);

		System.out.println(result == Integer.MAX_VALUE ? -1 : result);

	}

	static void combination(int[] selected, int start, int depth) {
		if (depth == M) {
			solution(selected);
			return;
		}

		for (int i = start; i < list.size(); i++) {
			selected[depth] = i;
			combination(selected, i + 1, depth + 1);
		}
	}

	static void solution(int[] selected) {
		moveMap = new int[N][N];
		fillMap(moveMap);

		for (int i = 0; i < M; i++) {
			Virus start = list.get(selected[i]);
			bfs(start);
		}

		result = Math.min(result, findMinTime(moveMap));
	}

	static void bfs(Virus start) {
		visit = new boolean[N][N];

		Queue<Virus> queue = new LinkedList<>();
		queue.add(start);
		visit[start.r][start.c] = true;
		moveMap[start.r][start.c] = 0;

		while (!queue.isEmpty()) {
			Virus now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] == 1
						|| moveMap[nr][nc] == -1) {
					continue;
				}

				queue.add(new Virus(nr, nc));
				visit[nr][nc] = true;
				if (moveMap[nr][nc] > moveMap[now.r][now.c] + 1) {
					moveMap[nr][nc] = moveMap[now.r][now.c] + 1;
				}
			}
		}

	}

	static void fillMap(int[][] moveMap) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					moveMap[i][j] = -1;
				} else {
					moveMap[i][j] = Integer.MAX_VALUE;
				}
			}
		}
	}

	static int findMinTime(int[][] map) {
		int temp = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (Main.map[i][j] != 1) {
					if (map[i][j] == -1) {
						continue;
					}
					if (map[i][j] == Integer.MAX_VALUE) {
						return Integer.MAX_VALUE;
					}
					temp = Math.max(temp, map[i][j]);
				}
			}
		}
		return temp;
	}

	static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == Integer.MAX_VALUE) {
					System.out.print('#' + " ");
				} else {

					System.out.print(map[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}