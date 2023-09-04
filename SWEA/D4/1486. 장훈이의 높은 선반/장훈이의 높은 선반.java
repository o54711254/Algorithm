import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];
			int ans = 987654321;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < (1 << N); i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) != 0) {
						sum += arr[j];
					}
				}
				if (sum >= B && sum < ans) {
					ans = sum;
				}
			}
			System.out.println("#" + tc +" "+ (ans - B));

		}
	}
}
