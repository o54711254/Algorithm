import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int num = sc.nextInt();
			
			int map[][] = new int[100][100];
			
			for(int r = 0; r<100; r++) {
				for(int c=0; c<100; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			int N = map.length;
			int max = 0;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += map[i][j];
				}
				if (max < sum) {
					max = sum;
				}
			}
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += map[j][i];
				}
				if (max < sum) {
					max = sum;
				}
			}
			for (int i = 0; i < N; i++) {
				int sum = 0;
				sum += map[i][i];
				if (max < sum) {
					max = sum;
				}
			}
			for (int i = 0; i < N; i++) {
				int sum = 0;
				sum += map[i][(N - 1) - i];
				if (max < sum) {
					max = sum;
				}
			}
			System.out.println("#"+num+" "+max);
		}
	}
}
