import java.io.*;
import java.util.*;
import java.awt.*;

class Spot {
	int r;
	int c;

	public Spot(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class Main {
	static int[][] map;
	static int N = 9;
	static ArrayList<Spot> spotList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[N][N];
		spotList = new ArrayList<Spot>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					spotList.add(new Spot(i, j));
				}
			}
		}
		dfs(0, spotList.size());
	}

	static void dfs(int depth, int end) {
		if (depth == end) {
			print();
			System.exit(0);
			return;
		}

		Spot now = spotList.get(depth);
		boolean[] checkS = checkSquare(now.r, now.c);
		boolean[] checkR = checkRow(now.r, now.c);
		boolean[] checkC = checkColumn(now.r, now.c);

		for (int j = 1; j <= N; j++) {
			if (!checkS[j] && !checkR[j] && !checkC[j]) {
				map[now.r][now.c] = j;
				dfs(depth + 1, end);
				map[now.r][now.c] = 0;
			}
		}
	}

	static boolean[] checkSquare(int r, int c) {
		boolean[] result = new boolean[11];
		int rSection = (r / 3) * 3;
		int cSection = (c / 3) * 3;

		for (int i = rSection; i < rSection + 3; i++) {
			for (int j = cSection; j < cSection + 3; j++) {
				if (map[i][j] != 0) {
					result[map[i][j]] = true;
				}
			}
		}
		return result;
	}

	static boolean[] checkRow(int r, int c) {
		boolean[] result = new boolean[11];

		for (int i = 0; i < N; i++) {
			if (map[r][i] != 0) {
				result[map[r][i]] = true;
			}
		}
		return result;
	}

	static boolean[] checkColumn(int r, int c) {
		boolean[] result = new boolean[11];
		for (int i = 0; i < N; i++) {
			if (map[i][c] != 0) {
				result[map[i][c]] = true;
			}
		}
		return result;
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}