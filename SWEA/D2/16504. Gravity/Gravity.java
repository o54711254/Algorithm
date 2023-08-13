import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int size = sc.nextInt();

			int[] arr = new int[size];

			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}

			int max = 0;
			for (int i = 0; i < size-1; i++) {
				int num = 0;
				for (int j = i+1; j < size; j++) {
					if(arr[i]>arr[j]) {
						num++;
					}
				}
				if(max<num) {
					max = num;
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}