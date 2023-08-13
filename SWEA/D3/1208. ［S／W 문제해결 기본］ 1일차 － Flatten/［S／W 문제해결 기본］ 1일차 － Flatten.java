import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {

			int[] arr = new int[100];

			int dump = sc.nextInt();
			
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}

			for(int d = 0; d<dump; d++) {
				
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = 1+i; j < arr.length; j++) {
					if (arr[i] < arr[j]) {
						int tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
					}
				}
			}
			arr[0]--;
			arr[arr.length-1]++;
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = 1+i; j < arr.length; j++) {
					if (arr[i] < arr[j]) {
						int tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
					}
				}
			}
			
			}
			int result = arr[0]-arr[arr.length-1];
			System.out.println("#"+tc+" "+result);

		}
	}
}