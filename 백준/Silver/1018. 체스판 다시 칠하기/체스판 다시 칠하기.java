import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			arr[i] = str.toCharArray();
		}

		char[][] compare1 = new char[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0 && j % 2 == 0) {
					compare1[i][j] = 'W';
				} else if (i % 2 == 1 && j % 2 == 1) {
					compare1[i][j] = 'W';
				} else {
					compare1[i][j] = 'B';
				}
			}
		}

		char[][] compare2 = new char[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0 && j % 2 == 0) {
					compare2[i][j] = 'B';
				} else if (i % 2 == 1 && j % 2 == 1) {
					compare2[i][j] = 'B';
				} else {
					compare2[i][j] = 'W';
				}
			}
		}

		int Min = 999999;

		for (int r = 0; r <= N - 8; r++) {
			for (int c = 0; c <= M - 8; c++) {
				int count1 = 0;
				int count2 = 0;
				
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (arr[i+r][j+c] == compare1[i][j]) {
							count1++;
						}
						if (arr[i+r][j+c] == compare2[i][j]) {
							count2++;
						}
					}
				}
				Min = Math.min(Min, count1);
				Min = Math.min(Min, count2);
				
			}
		}
		System.out.println(Min);

	}
}
