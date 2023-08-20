import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int N = Integer.parseInt(s);
		
		String s2 = br.readLine();
		int num = Integer.parseInt(s2);
		
		

		int[][] arr = new int[N][N];

		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int dir = 0;

		int r = 0, c = 0;

		for (int i = N * N; i >= 1; i--) {
			arr[r][c] = i;

			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 0) {
				r = r + dr[dir];
				c = c + dc[dir];
			} else {
				dir++;
				dir = dir % 4;
				r = r + dr[dir];
				c = c + dc[dir];
			}
		}

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] == num) {
					sb.append((i+1)+" " + (j+1));
				}
			}
		}
		System.out.println(sb);
		
	}
}