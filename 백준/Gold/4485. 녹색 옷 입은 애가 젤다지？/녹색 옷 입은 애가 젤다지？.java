import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt;
	static int[][] map, weights;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		cnt = 0;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());

			if (N == 0) {
				break;
			}

			map = new int[N][N];
			weights = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				Arrays.fill(weights[i], Integer.MAX_VALUE);
			} // 최댓값으로 채워주기

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 끝

			// 시작점은 가중치 넣어주기
			weights[0][0] = map[0][0];

			for (int t = 0; t < N * N; t++) {
				// 배열 돌면서 방문하지 않은 곳 중에서 가중치가 가장 작은 칸을 찾아
				int min = Integer.MAX_VALUE;
				Point find = null; // 가장 작은 칸의 행,열 좌표
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!visited[i][j] && weights[i][j] < min) {
							min = weights[i][j];
							find = new Point(i, j);
						}
					}
				}

				visited[find.x][find.y] = true; // 방문표시
				for (int d = 0; d < 4; d++) {
					int nextR = find.x + dr[d];
					int nextC = find.y + dc[d];

					if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && !visited[nextR][nextC]) {
						if (weights[find.x][find.y] + map[nextR][nextC] < weights[nextR][nextC]) {
							weights[nextR][nextC] = weights[find.x][find.y] + map[nextR][nextC];
						}
					}
				}
			}

			// 출력
			cnt++;
			System.out.println("Problem " + cnt + ": " + weights[N - 1][N - 1]);

		}

	}// main

}