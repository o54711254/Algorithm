import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[] visit;
	static int N;
	static Deque<Integer> deque = new LinkedList<>();
	static int Max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);
		System.out.println(Max);
	}

	static void Right() {
		for (int i = 0; i < N; i++) {
			int index = N - 1;
			int block = 0;

			for (int j = N - 1; j >= 0; j--) {
				if (map[i][j] != 0) {
					if (map[i][j] == block) {
						map[i][j] = 0;
						map[i][index + 1] = block * 2;
						block = 0;
					} else {
						block = map[i][j];
						map[i][j] = 0;
						map[i][index] = block;
						index--;
					}
				}
			}
		}
	}

	static void Left() {
		for (int i = 0; i < N; i++) {
			int index = 0;
			int block = 0;

			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					if (map[i][j] == block) {
						map[i][j] = 0;
						map[i][index - 1] = block * 2;
						block = 0;
					} else {
						block = map[i][j];
						map[i][j] = 0;
						map[i][index] = block;
						index++;
					}
				}
			}
		}
	}

	static void Up() {
		for (int i = 0; i < N; i++) {
			int index = 0;
			int block = 0;

			for (int j = 0; j < N; j++) {
				if (map[j][i] != 0) {
					if (map[j][i] == block) {
						map[index - 1][i] = block * 2;
						block = 0;
						map[j][i] = 0;
					} else {
						block = map[j][i];
						map[j][i] = 0;
						map[index][i] = block;
						index++;
					}
				}
			}
		}
	}

	static void Down() {
		for (int i = 0; i < N; i++) {
			int index = N - 1;
			int block = 0;

			for (int j = N - 1; j >= 0; j--) {
				if (map[j][i] != 0) {
					if (map[j][i] == block) {
						map[index + 1][i] = block * 2;
						block = 0;
						map[j][i] = 0;
					} else {
						block = map[j][i];
						map[j][i] = 0;
						map[index][i] = block;
						index--;
					}
				}
			}
		}
	}

	static void dfs(int depth) {
		if (depth == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Max = Math.max(Max, map[i][j]);
				}
			}
			return;
		}
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			copy[i] = map[i].clone();
		}

		for (int i = 0; i < 4; i++) {
			move(i);
			dfs(depth + 1);
			for (int j = 0; j < N; j++) {
				map[j] = copy[j].clone();
			}
		}
	}

	static void move(int i) {
		switch (i) {
		case 0:
			Up();
			break;
		case 1:
			Down();
			break;
		case 2:
			Right();
			break;
		case 3:
			Left();
			break;
		default:
			break;
		}
	}
}