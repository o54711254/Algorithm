
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] map = new int[1001][1001];

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());

			int Horizon1 = Integer.parseInt(st.nextToken());
			int Vertical1 = Integer.parseInt(st.nextToken());
			int Horizon2 = Integer.parseInt(st.nextToken());
			int Vertical2 = Integer.parseInt(st.nextToken());

			for (int i = Vertical1; i < Vertical1 + Vertical2; i++) {
				for (int j = Horizon1; j < Horizon1 + Horizon2; j++) {
					map[i][j] = tc;
				}
			}
		}

		for (int k = 1; k <= T; k++) {
			int sum = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (map[i][j] == k) {
						sum++;
					}
				}
			}
			System.out.println(sum);
		}
	}
}