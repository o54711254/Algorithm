
import java.util.Scanner;

class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();

			char[][] arr = new char[N][N];

			for (int i = 0; i < N; i++) {
				String s = sc.next();
				arr[i] = s.toCharArray();
			}

			int result = 0;

			for (int i = 0; i < N; i++) {
				int countHorizon = 0;
				int countVertical = 0;

				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 'o') {
						countHorizon++;
						if (countHorizon >= 5) {
							result++;
						}
					} else {
						countHorizon = 0;
					}
					if (arr[j][i] == 'o') {
						countVertical++;
						if (countVertical >= 5) {
							result++;
						}
					} else {
						countVertical = 0;
					}
				}
			}

			for (int i = 0; i <= N - 5; i++) {
				for (int j = 0; j <= N - 5; j++) {

					int DiagnolRight = 0;
					int DiagnolLeft = 0;

					for (int k = 0; k < 5; k++) {
						if (arr[i + k][j + k] == 'o') {
							DiagnolRight++;
							if (DiagnolRight >= 5) {
								result++;
							}
						} else {
							DiagnolRight = 0;
						}
					}
					for (int k = 0; k < 5; k++) {
						if (arr[i + k][j + 4 - k] == 'o') {
							DiagnolLeft++;
							if (DiagnolLeft >= 5) {
								result++;
							}
						} else {
							DiagnolLeft = 0;
						}
					}
				}
			}
			if (result >= 1) {
				System.out.println("#" + tc + " " + "YES");
			} else {
				System.out.println("#" + tc + " " + "NO");
			}

		}
	}
}