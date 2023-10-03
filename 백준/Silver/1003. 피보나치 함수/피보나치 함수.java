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
			int N = Integer.parseInt(br.readLine());
			int[] dp0 = new int[41];
			int[] dp1 = new int[41];

			dp0[0] = 1;
			dp0[1] = 0;
			dp1[0] = 0;
			dp1[1] = 1;

			for (int i = 2; i <= N; i++) {
				dp0[i] = dp0[i - 1] + dp0[i - 2];
				dp1[i] = dp1[i - 1] + dp1[i - 2];
			}
			System.out.println(dp0[N]+" "+dp1[N]);

		}
	}

}