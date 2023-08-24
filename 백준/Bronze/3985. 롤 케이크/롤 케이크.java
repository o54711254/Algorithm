import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int L = Integer.parseInt(br.readLine());
		int[] arr = new int[L];

		int T = Integer.parseInt(br.readLine());

		int[] expect = new int[T];

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			expect[tc - 1] = K - P;
			for (int i = P - 1; i < K; i++) {
				if (arr[i] != 0) {
					continue;
				}
				arr[i] = tc;
			}
		}

		int[] result = new int[T + 1];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				result[arr[i]]++;
			}
		}
		int max1 = 0;
		for (int i = 0; i < result.length; i++) {
			if (max1 < result[i]) {
				max1 = result[i];
			}
		}
		int max2 = 0;
		for (int i = 0; i < expect.length; i++) {
			if (max2 < expect[i]) {
				max2 = expect[i];
			}
		}

		for (int i = 0; i < expect.length; i++) {
			if (expect[i] == max2) {
				System.out.println(i + 1);
				break;
			}
		}
		for (int i = 0; i < result.length; i++) {
			if (result[i] == max1) {
				System.out.println(i);
				break;
			}
		}

	}
}