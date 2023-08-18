import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int[] arr1 = new int[N];
			for (int i = 0; i < N; i++) {
				arr1[i] = i + 1;
			}

			int M = sc.nextInt();
			int[] arr2 = new int[M];
			for (int i = 0; i < M; i++) {
				arr2[i] = i + 1;
			}

			Queue<Integer> queue = new LinkedList<Integer>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					queue.add(arr1[i] + arr2[j]);
				}
			}

			int[] sum = new int[N + M + 1];

			while (!queue.isEmpty()) {
				sum[queue.poll()]++;
			}

			int max = 0;
			for (int i = 0; i < sum.length; i++) {
				if (max < sum[i]) {
					max = sum[i];
				}
			}
			
			System.out.print("#"+tc+" ");
			for (int i = 0; i < sum.length; i++) {
				if (sum[i] == max) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}
}
