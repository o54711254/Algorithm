import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[][] map, visit;
	static int N, diagnolCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 물 받을 맵
		map = new int[N][N];

		// 물 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 구름 체크할 배열
		visit = new int[N][N];

		// 구름 처음 생성
		visit[N - 1][0] = 1;
		visit[N - 1][1] = 1;
		visit[N - 2][0] = 1;
		visit[N - 2][1] = 1;

		// 구름 이동
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int move = Integer.parseInt(st.nextToken());
			func(dir, move);
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}

		System.out.println(sum);
	}

	static void func(int dir, int move) {
		Queue<Point> cloud = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == 1) {
					int nr = i + move * dr[dir];
					int nc = j + move * dc[dir];
					if (nr < 0) {
						nr = (nr + 50*N) % N;
					} else if (nr >= N) {
						nr = nr % N;
					}
					if (nc < 0) {
						nc = (nc + 50*N) % N;
					} else if (nc >= N) {
						nc = nc % N;
					}
					visit[i][j] = 0;
					cloud.add(new Point(nr, nc));
				}
			}
		}

		for (Point p : cloud) {
			visit[p.x][p.y] = 2;
		}

		// 구름이 이동한 곳 물 1씩 증가
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == 2) {
					map[i][j]++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				diagnolCount = 0;
				if (visit[i][j] == 2) {
					diagnol(new Point(i, j));
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] != 2 && map[i][j] >= 2) {
					visit[i][j] = 1;
					map[i][j] -= 2;
				}
				if (visit[i][j] == 2) {
					visit[i][j] = 0;
				}
			}
		}

	}

	static void diagnol(Point p) {
		for (int i = 2; i <= 8; i = i + 2) {
			int nr = p.x + dr[i];
			int nc = p.y + dc[i];
			if (nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] > 0) {
				diagnolCount++;
			}
		}
		map[p.x][p.y] += diagnolCount;
	}
}