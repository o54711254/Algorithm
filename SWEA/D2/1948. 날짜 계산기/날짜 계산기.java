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

			int sum1 = 0;

			for (int i = 0; i < M1 - 1; i++) {
				sum1 += Month[i];
			}

			sum1 += D1;

			int sum2 = 0;

			for (int i = 0; i < M2 - 1; i++) {
				sum2 += Month[i];
			}

			sum2 += D2;

			System.out.println("#" + tc + " " + (sum2 - sum1 + 1));
		}
	}
}