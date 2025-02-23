import java.io.*;
import java.util.*;

class Point {
	int r;
	int c;

	Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class Main {
	static int[] dr = { 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1 };
	static int[][] map = new int[19][19];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (map[i][j] != 0) {
					if (search(new Point(i, j), map[i][j])) {
						return;
					}
				}
			}
		}
		System.out.println(0);
	}

	static boolean search(Point start, int color) {
		for (int dir = 0; dir < 4; dir++) {
			int nr = start.r;
			int nc = start.c;

			int cnt = 1;

			while (true) {
				nr += dr[dir];
				nc += dc[dir];

				if (nr < 0 || nc < 0 || nr >= 19 || nc >= 19 || map[nr][nc] != color) {
	                break;
	            }
	            
	            cnt++;
			}
			if (cnt == 5) {
				int checkR = start.r - dr[dir];
				int checkC = start.c - dc[dir];

				if (checkR < 0 || checkR >= 19 || checkC < 0 || checkC >= 19) {
					System.out.println(color);
					System.out.println((start.r + 1) + " " + (start.c + 1));
					return true;
				}
				if (map[checkR][checkC] != color) {
					System.out.println(color);
					System.out.println((start.r + 1) + " " + (start.c + 1));
					return true;
				}
			}
		}
		return false;
	}

	static void print() {
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}