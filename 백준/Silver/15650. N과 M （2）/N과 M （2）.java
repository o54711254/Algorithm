import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] result;
	static boolean[] visit;
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		result = new int[M];
		visit = new boolean[N + 1];
		sb = new StringBuilder();
		permutation(0,0, M);

		System.out.println(sb);

	}

	public static void permutation(int depth, int start, int r) {
		if (depth == r) {
			for (int i = 0; i < r; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				result[depth] = arr[i];
				permutation(depth + 1, i + 1, r);
				visit[i] = false;
			}
		}
	}
}