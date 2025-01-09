import java.util.*;
import java.io.*;

public class Main {
	static int[] coin, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		coin = new int[N];
		dp = new int[M + 1];

		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		Arrays.fill(dp, 10001);
		dp[0] = 0;
		
		for (int i = 0; i < N; i++) {
            for (int j = coin[i]; j <= M; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
            
//            System.out.println(Arrays.toString(dp));
        }
		System.out.println(dp[M] == 10001 ? -1 : dp[M]);

	}
}