
import java.util.Scanner;

class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			int[][] arr = new int[N][N];

			int r = 0, c = 0;

			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };

			int dir = 0;

			for (int i = 1; i <= N * N; i++) {

				arr[r][c] = i;

				int nr = r + dr[dir];
				int nc = c + dc[dir];

				if (nr < N && nr >= 0 && nc < N && nc >= 0 && arr[nr][nc] == 0) {
					r = r + dr[dir];
					c = c + dc[dir];
				} else {
					dir++;
					dir = dir % 4;
					r = r + dr[dir];
					c = c + dc[dir];
				}
			}
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}