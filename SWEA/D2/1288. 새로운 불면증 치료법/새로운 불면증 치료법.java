import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			
		boolean[] visited = new boolean[10];

		int N = sc.nextInt();
		int M = N;
		int result = 0;

		int K = 1;

		while (true) {
			N = K * M;
			
			while (true) {
				if (N == 0) {
					break;
				}
				int tmp = N % 10;
				N = N / 10;
				if (!visited[tmp]) {
					visited[tmp] = true;
					result++;
				}
			}
			if(result==10) {
				break;
			}
			
			K++;

		}
		System.out.println("#"+tc+" "+K*M);
		}
	}
	

}