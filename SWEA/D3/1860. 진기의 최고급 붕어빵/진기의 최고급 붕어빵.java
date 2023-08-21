import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();

			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);
			int result = 0;
			int count = 0;
			int idx = 0;

			for (int i = 0; i <= arr[N - 1]; i++) {
				if (i >= 1 && i % M == 0) {
					count += K;
				}
				if (arr[idx] == i) {
					if (count > 0) {
						count--;
						idx++;
					} else {
						result++;
					}
				}
			}

			if (result >= 1) {
				System.out.println("#" + tc + " " + "Impossible");
			} else {
				System.out.println("#" + tc + " " + "Possible");
			}

		}
	}
}