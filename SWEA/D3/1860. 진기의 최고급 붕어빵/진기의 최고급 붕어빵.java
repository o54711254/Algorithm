import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);
			
			int count = 0;
			int idx = 0;
			int result = 0;
			for (int i = 0; i <= arr[N - 1]; i++) {
				if (i > 0 && i % M == 0) {
					count += K;
				}
				if (arr[idx] == i) {
					if (count > 0) {
						count--;
						idx++;
					} else {
						result++;
					}
				}
			}
			if (result >= 1) {
				sb.append("#" + tc + " " + "Impossible");
			} else {
				sb.append("#" + tc + " " + "Possible");
			}
			sb.append("\n");

		}
		System.out.println(sb);
	}
}