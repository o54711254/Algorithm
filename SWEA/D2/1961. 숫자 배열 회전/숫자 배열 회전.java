import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] first = rotation(arr);
		int[][] second = rotation(first);
		int[][] third = rotation(second);
		
		System.out.println("#"+tc+" ");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(first[i][j]);
			}
			System.out.print(" ");
			for (int j = 0; j < N; j++) {
				System.out.print(second[i][j]);
			}
			System.out.print(" ");
			for (int j = 0; j < N; j++) {
				System.out.print(third[i][j]);
			}
			System.out.println();
		}
	}
}

	public static int[][] rotation(int[][] arr) {
		int N = arr.length;
		int[][] result = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result[j][N - i - 1] = arr[i][j];
			}
		}
		return result;
	}

}