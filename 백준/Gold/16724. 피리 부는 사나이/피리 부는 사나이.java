import java.io.*;
import java.awt.*;
import java.util.*;

public class Main {
	static int N, M, result;
	static char[][] map;
	static int[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visit = new int[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j] != 0) {
					continue;
				}
				dfs(new Point(i, j));
//				printVisit();
			}
		}

		System.out.println(result);

	}

	static void dfs(Point now) {

		visit[now.x][now.y] = 1;
		int nr = 0;
		int nc = 0;
		switch (map[now.x][now.y]) {
		case 'U':
			nr = now.x - 1;
			nc = now.y;
			break;
		case 'D':
			nr = now.x + 1;
			nc = now.y;
			break;
		case 'R':
			nr = now.x;
			nc = now.y + 1;
			break;
		case 'L':
			nr = now.x;
			nc = now.y - 1;
			break;
		default:
			break;
		}

		if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
			return;
		} else {
			if (visit[nr][nc] == 0) {
				dfs(new Point(nr, nc));
			} else if (visit[nr][nc] == 1) {
				result++;
			}
		}
		visit[now.x][now.y] = 2;
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static void printVisit() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(visit[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}