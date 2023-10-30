import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] A = new int[N];
			int[] B = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(B);
			int result = 0;

			for (int i = 0; i < N; i++) {
				int first = 0;
				int end = M - 1;
				int index = 0;

				while (first <= end) {
					int mid = (first + end) / 2;
					if (B[mid] < A[i]) {
						first = mid + 1;
						index = mid + 1;
					} else {
						end = mid - 1;
					}
				}
				result += index;
			}
			System.out.println(result);
		}
	}
}