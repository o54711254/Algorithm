import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int times = sc.nextInt();
		for (int a = 1; a <= times; a++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int result = 0;
			for (int i = 0; i < N; i++) {
				int count = 0;
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						count++;
					}
					if (arr[i][j] == 0 || j == N - 1) {
						if (count == M) {
							result++;
						}
						count = 0;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				int count = 0;
				for (int j = 0; j < N; j++) {
					if (arr[j][i] == 1) {
						count++;
					}
					if (arr[j][i] == 0 || j == N - 1) {
						if (count == M) {
							result++;
						}
						count = 0;
					}
				}
			}
			System.out.println("#"+a+" "+result);
		}
	}
}
