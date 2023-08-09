

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[100][100];

		int times = sc.nextInt();

		int count = 0;
		for (int ea = 1; ea <= times; ea++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int i = x; i < 10 + x; i++) {
				for (int j = y; j < 10 + y; j++) {
					arr[i][j]++;
				}
			}
		}
		for(int i = 0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(arr[i][j]>=1) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

}