
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;
	static int N;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			count = 0;
			func(0);

			System.out.println("#" + tc + " " + count);
		}

	}

	public static void func(int depth) {
		if (depth == N) {
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			if (check(depth)) {
				func(depth + 1);
			}
		}

	}

	public static boolean check(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i]) {
				return false;
			} else if (Math.abs(i - col) == Math.abs(arr[i] - arr[col])) {
				return false;
			}
		}
		return true;
	}

}
