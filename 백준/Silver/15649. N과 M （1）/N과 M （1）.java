import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] visit;
	static int[] result;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		visit = new boolean[N];
		result = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		sb = new StringBuilder();
		permutation(0);
		System.out.println(sb);

	}

	static void permutation(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				result[depth] = arr[i];
				permutation(depth + 1);
				visit[i] = false;
			}
		}
	}
}