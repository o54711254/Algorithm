import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, B, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 테스트케이스
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			// 점원의 수
			N = Integer.parseInt(st.nextToken());
			// 선반 높이
			B = Integer.parseInt(st.nextToken());

			ans = 987654321;

			// 키 배열에 값 넣기
			arr = new int[N];
			int rs = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				rs += arr[i];
			}

			func(0, 0, rs);

			System.out.println("#"+tc+" "+(ans-B));
		}
	}

	static void func(int idx, int sum, int rsum) {
		if (sum > ans) {
			return;
		}
		if (sum + rsum < B) {
			return;
		}
		if (idx == N) {
			if (sum >= B) {
				ans = Math.min(ans, sum);
			}
			return;
		}

		func(idx + 1, sum + arr[idx], rsum - arr[idx]);
		func(idx + 1, sum, rsum - arr[idx]);
	}
}
