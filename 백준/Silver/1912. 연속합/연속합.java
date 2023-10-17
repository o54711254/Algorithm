import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		// 기본숫자 배열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 결과값을 담을 dp 배열
		int[] dp = new int[N];
		dp[0] = arr[0];

		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
		}

		Arrays.sort(dp);

		System.out.println(dp[N-1]);
	}
}