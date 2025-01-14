import java.util.*;
import java.io.*;
import java.awt.*;

class Point {
	int x;
	int y;
	int flag;
	int cnt;
	int dist;

	public Point(int x, int y, int flag, int cnt, int dist) {
		this.x = x;
		this.y = y;
		this.flag = flag;
		this.cnt = cnt;
		this.dist = dist;
	}

}

public class Main {
	static int N, M, K;
	static int result = Integer.MAX_VALUE;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	/*
	 * N, M 좌표, 낮 밤, 부순 벽 갯수
	 */
	static boolean[][][][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		visit = new boolean[N][M][2][K + 1];

		bfs(new Point(0, 0, 0, 0, 1));

		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	static void bfs(Point start) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(start);
		visit[start.x][start.y][0][0] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			if (now.x == N - 1 && now.y == M - 1) {
				result = now.dist;
				return;
			}
			int newFlag = now.flag == 1 ? 0 : 1;

			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];

				// 같은 case로 방문한 적이 있거나 map의 범위를 벗어나면 continue
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc][newFlag][now.cnt]) {
					continue;
				}

				// 만약 다음 목적지가 벽일 때
				if (map[nr][nc] == '1') {

					// 벽을 부술 수 있는 횟수를 다 쓰먄
					if (now.cnt >= K) {
						continue;
					}
					// 횟수 남았으면
					else {
						// 만약 밤 이라면
						if (now.flag == 1) {
							// 낮밤 바꿔서 Queue에 넣기
							if (!visit[now.x][now.y][newFlag][now.cnt]) {
								visit[now.x][now.y][newFlag][now.cnt] = true;
								queue.add(new Point(now.x, now.y, newFlag, now.cnt, now.dist + 1));
							}
						}
						// 만약 낮이라
						else {
							if (!visit[nr][nc][newFlag][now.cnt + 1]) {
								visit[nr][nc][newFlag][now.cnt + 1] = true;
								queue.add(new Point(nr, nc, newFlag, now.cnt + 1, now.dist + 1));
							}
						}
					}
				}
				// 다음 목적지가 0일
				else {
					visit[nr][nc][newFlag][now.cnt] = true;
					queue.add(new Point(nr, nc, newFlag, now.cnt, now.dist + 1));
				}
			}
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}