import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] map = new boolean[101][101];
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			// 좌표 햇갈리니까 반대로 받기
			dragonCurv(y, x, d, g);
		}
		int result = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
					result++;
				}
			}
		}
		System.out.println(result);
	}

	static void dragonCurv(int x, int y, int d, int g) {
		// 방향을 저장할 리스트
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(d);
		for (int i = 1; i <= g; i++) {
			for (int j = list.size() - 1; j >= 0; j--) {
				list.add((list.get(j) + 1) % 4);
			}
		}
		map[x][y] = true;
		for (int dir : list) {
			x += dr[dir];
			y += dc[dir];
			map[x][y] = true;
		}
	}
}