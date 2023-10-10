import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Shark implements Comparable<Shark> {
	int r;
	int c;
	int s;
	int d;
	int z;

	public Shark(int r, int c, int s, int d, int z) {
		super();
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}

	@Override
	public String toString() {
		return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
	}

	@Override
	public int compareTo(Shark o) {
		// 먼저 r 값을 기준으로 오름차순으로 정렬
		if (this.c != o.c) {
			return this.c - o.c;
		} else {
			if (this.r != o.r) {
				return this.r - o.r;
			} else {
				return o.z - this.z;
			}
		}
	}
}

public class Main {
	static ArrayList<Shark> sharkList = new ArrayList<Shark>();
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 1, -1 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][M + 1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			sharkList.add(new Shark(r, c, s, d, z));
		}

		Collections.sort(sharkList);

		int result = 0;
		// 이동
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < sharkList.size(); j++) {
				if (sharkList.get(j).c == i) {
					result += sharkList.get(j).z;
					sharkList.remove(j);
					break;
				}
			}
			move();
			Collections.sort(sharkList);

			// 만약 두마리 있으면 잡아먹기
			map = new int[N + 1][M + 1];
			for (int j = 0; j < sharkList.size(); j++) {
				if (map[sharkList.get(j).r][sharkList.get(j).c] == 0) {
					map[sharkList.get(j).r][sharkList.get(j).c] += 1;
				} else {
					sharkList.remove(j);
					j--;
				}
			}

		}
		System.out.println(result);
	}

	static void move() {
		for (int i = 0; i < sharkList.size(); i++) {
			// 속력만큼 이동
			for (int j = 0; j < sharkList.get(i).s; j++) {
				int nr = sharkList.get(i).r + dr[sharkList.get(i).d];
				int nc = sharkList.get(i).c + dc[sharkList.get(i).d];
				// 벗어나면 방향전환
				if (nr < 1 || nc < 1 || nr > N || nc > M) {
					switch (sharkList.get(i).d) {
					case 1:
						sharkList.get(i).d = 2;
						break;
					case 2:
						sharkList.get(i).d = 1;
						break;
					case 3:
						sharkList.get(i).d = 4;
						break;
					case 4:
						sharkList.get(i).d = 3;
						break;
					}
					nr = sharkList.get(i).r + dr[sharkList.get(i).d];
					nc = sharkList.get(i).c + dc[sharkList.get(i).d];
				}
				sharkList.get(i).r = nr;
				sharkList.get(i).c = nc;
			}
		}
	}

	static void print() {
		for (int i = 0; i < sharkList.size(); i++) {
			System.out.println(sharkList.get(i).toString());
		}
	}
}