import java.util.Scanner;

class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int M1 = sc.nextInt();
			int D1 = sc.nextInt();

			int M2 = sc.nextInt();
			int D2 = sc.nextInt();

			int[] Month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

			int sumM1 = 0;
			for (int i = 0; i < M1 - 1; i++) {
				sumM1 += Month[i];
			}

			int sumM2 = 0;
			for (int i = 0; i < M2 - 1; i++) {
				sumM2 += Month[i];
			}

			int result = (sumM2 - sumM1) + (D2 - D1) + 1;

			System.out.println("#" + tc + " " + result);
		}
	}
}