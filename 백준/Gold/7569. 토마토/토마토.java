import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int z;
	int x;
	int y;

	public Tomato(int z, int x, int y) {
		super();
		this.z = z;
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int M, N, H;
	static int[][][] map;
	static boolean[][][] visit;
	static int[] dh = { -1, 1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 0, -1, 1 };
	static Queue<Tomato> queue;
	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][N][M];
		visit = new boolean[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		queue = new LinkedList<>();
		count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 1) {
						queue.add(new Tomato(i, j, k));
						visit[i][j][k] = true;
					}
				}
			}
		}
		count = count - 1;
		bfs();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 0) {
						count = -1;
					}
				}
			}
		}
		System.out.println(count);
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {

				Tomato now = queue.poll();
				for (int i = 0; i < 6; i++) {
					int nh = now.z + dh[i];
					int nr = now.x + dr[i];
					int nc = now.y + dc[i];
					if (nh < 0 || nr < 0 || nc < 0 || nh >= H || nr >= N || nc >= M || map[nh][nr][nc] == -1
							|| visit[nh][nr][nc]) {
						continue;
					}
					queue.add(new Tomato(nh, nr, nc));
					visit[nh][nr][nc] = true;
					map[nh][nr][nc] = 1;
				}
			}
			count++;
		}
	}

	static void print() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					System.out.print(map[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}