import java.util.*;
import java.io.*;

public class Main {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		int[] sensor = new int[N];
		int[] diff = new int[N - 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sensor);

		for (int i = 0; i < N - 1; i++) {
			diff[i] = sensor[N - 1 - i] - sensor[N - 2 - i];
		}
		Arrays.sort(diff);

		int result = 0;

		for (int i = 0; i < N - K; i++) {
			result += diff[i];
		}

		System.out.println(result);
	}
}