import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int r = 0;
			int c = 0;

			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };
			int dir = 0;

			for (int i = 1; i <= N * N; i++) {
				map[r][c] = i;

				int nr = r + dr[dir];
				int nc = c + dc[dir];

				if (nr < N && nr >= 0 && nc < N && nc >= 0 && map[nr][nc] == 0) {
					r = nr;
					c = nc;
				} else {
					dir++;
					dir = dir % 4;
					r = r + dr[dir];
					c = c + dc[dir];
				}
			}
			System.out.println("#" + tc);
			for(int i=0; i<map.length; i++) {
				for(int j =0; j<map.length; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
