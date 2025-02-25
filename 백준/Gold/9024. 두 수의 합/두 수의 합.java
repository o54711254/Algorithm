import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {
			int count = 0;

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			int start = 0;
			int end = N - 1;

			long best = Integer.MAX_VALUE;
			while (start < end) {
				long sum = arr[start] + arr[end];
				if (Math.abs(K - best) == Math.abs(K - sum)) {
					count++;
				}
				if (Math.abs(K - best) > Math.abs(K - sum)) {
					best = sum;
					count = 1;
				}

				if (sum <= K) {
					start++;
				} else {
					end--;
				}

			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
}