
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int[][] map = new int[9][9];

			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int resultHorizon = 0;
			int resultVertical = 0;
			for (int i = 0; i < 9; i++) {
				int sumHorizon = 0;
				int sumVertical = 0;
				for (int j = 0; j < 9; j++) {
					sumHorizon += map[i][j];
					if (sumHorizon == 45) {
						resultHorizon++;
					}
					sumVertical += map[j][i];
					if (sumVertical == 45) {
						resultVertical++;
					}
				}
			}

			int resultRectangle = 0;
			for (int i = 0; i < 9; i += 3) {
				for (int j = 0; j < 9; j += 3) {
					int sumRectangle = 0;
					for (int x = 0; x < 3; x++) {
						for (int y = 0; y < 3; y++) {
							sumRectangle += map[i + x][j + y];
							if (sumRectangle == 45) {
								resultRectangle++;
							}
						}
					}
				}
			}

			if (resultHorizon == 9 && resultVertical == 9 && resultRectangle == 9) {
				System.out.println("#"+tc+" "+1);
			} else {
				System.out.println("#"+tc+" "+0);
			}

		}
	}
}