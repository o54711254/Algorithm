import java.io.*;
import java.util.*;

class Spot {
	int r, c;
	public Spot(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static int N;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { -1, 1, 1, -1 };
	static List<Spot> blackList = new ArrayList<>();
	static List<Spot> whiteList = new ArrayList<>();
	static int blackResult = 0, whiteResult = 0;
	static boolean[][] checkMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		checkMap = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int val = Integer.parseInt(st.nextToken());
				if (val == 1) {
					if ((i + j) % 2 == 0) {
						blackList.add(new Spot(i, j));
					} else {
						whiteList.add(new Spot(i, j));
					}
				}
			}
		}

		dfs(0, blackList, 0);
		dfs(0, whiteList, 0);

		System.out.println(blackResult + whiteResult);
	}

	static void dfs(int start, List<Spot> list, int count) {
		if (start == list.size()) {
			if (list == blackList) {
				blackResult = Math.max(blackResult, count);
			} else {
				whiteResult = Math.max(whiteResult, count);
			}
			return;
		}

		Spot next = list.get(start);
		if (checkStatus(next)) {
			checkMap[next.r][next.c] = true;
			dfs(start + 1, list, count + 1);
			checkMap[next.r][next.c] = false;
		}

		// 현재 비숍을 놓지 않고 넘어가는 경우도 탐색
		dfs(start + 1, list, count);
	}

	static boolean checkStatus(Spot next) {
		for (int i = 0; i < 4; i++) {
			int nr = next.r, nc = next.c;
			while (true) {
				nr += dr[i];
				nc += dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N) break;
				if (checkMap[nr][nc]) return false;
			}
		}
		return true;
	}
}