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
						if (countHorizon == 5) {
							result++;
						}
					} else {
						countHorizon = 0;
					}

					if (arr[j][i] == 'o') {
						countVertical++;
						if (countVertical == 5) {
							result++;
						}
					} else {
						countVertical = 0;
					}
				}
			}

			for (int i = 0; i <= N - 5; i++) {
				for (int j = 0; j <= N - 5; j++) {

					int diagonalL = 0;
					int diagonalR = 0;

					for (int k = 0; k < 5; k++) {
						if (arr[i + k][j + k] == 'o') {
							diagonalL++;
							if (diagonalL == 5) {
								result++;
							}
						} else {
							diagonalL = 0;
						}

						if (arr[i + k][j + 4 - k] == 'o') {
							diagonalR++;
							if (diagonalR == 5) {
								result++;
							}
						} else {
							diagonalR = 0;
						}

					}
				}
			}

			System.out.print("#"+tc+ " ");
			if (result >= 1) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}

		}
	}
}