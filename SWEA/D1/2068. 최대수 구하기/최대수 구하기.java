import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int[] arr = new int[10];
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i =0; i<arr.length-1; i++) {
				for(int j =1; j<arr.length-i; j++) {
					if(arr[j-1]<arr[j]) {
						int temp = arr[j-1];
						arr[j-1] = arr[j];
						arr[j] = temp;
					}
				}
			}
			System.out.println("#"+tc+" "+arr[0]);
		}
	}
}