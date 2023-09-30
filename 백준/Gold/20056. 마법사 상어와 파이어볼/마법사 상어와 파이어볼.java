import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class fireBall {
	int r;
	int c;
	int m;
	int s;
	int d;

	public fireBall(int r, int c, int m, int s, int d) {
		super();
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}
}

public class Main {
	static ArrayList<fireBall> list;
	static ArrayList<fireBall>[][] map;
	static int N;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new ArrayList[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<fireBall>();
			}
		}

		list = new ArrayList<fireBall>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			list.add(new fireBall(r, c, m, s, d));
		}
		for (int i = 0; i < K; i++) {
			move();
			check();
		}
		int answer = 0;
		for (fireBall fb : list) {
			answer += fb.m;
		}
		System.out.println(answer);

	}

	static void check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (map[i][j].size() < 2) {
					map[i][j].clear();
					continue;
				}

				int mSum = 0, sSum = 0, oddCount = 0, evenCount = 0;
				int size = map[i][j].size();
				for (fireBall fb : map[i][j]) {
					mSum += fb.m;
					sSum += fb.s;
					if (fb.d % 2 == 1) {
						oddCount++;
					} else {
						evenCount++;
					}
					list.remove(fb);
				}
				map[i][j].clear();
				mSum /= 5;
				if (mSum == 0) {
					continue;
				}
				sSum /= size;
				if (oddCount == size || evenCount == size) {
					for (int dir = 0; dir < 8; dir += 2) {
						list.add(new fireBall(i, j, mSum, sSum, dir));
					}
				} else {
					for (int dir = 1; dir < 8; dir += 2) {
						list.add(new fireBall(i, j, mSum, sSum, dir));
					}
				}
			}
		}
	}

	static void move() {
		for (fireBall fb : list) {
			int nr = (fb.r + N + dr[fb.d] * (fb.s % N)) % N;
			int nc = (fb.c + N + dc[fb.d] * (fb.s % N)) % N;

			fb.r = nr;
			fb.c = nc;
			map[nr][nc].add(fb);
		}
	}
}