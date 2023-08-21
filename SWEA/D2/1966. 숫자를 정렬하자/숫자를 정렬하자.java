import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();

			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i =1; i<N; i++) {
				int key = arr[i];
				int j;
				for(j = i-1; j>=0 && key<arr[j]; j--) {
					arr[j+1] = arr[j];
				}
				arr[j+1] = key;
			}
			
			System.out.print("#"+tc+" ");
			for(int i = 0; i<arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
				
			
		}
	}
}
