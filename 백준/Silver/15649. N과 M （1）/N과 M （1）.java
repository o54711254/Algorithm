import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		result = new int[M];
		visited = new boolean[N];
		sb = new StringBuilder();
		permutation(0, M);
		System.out.println(sb);

	}

	public static void permutation(int depth, int r) {
		if (depth == r) {
			for (int i = 0; i < r; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}

		int size = arr.length;

		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				permutation(depth + 1, r);
				visited[i] = false;
			}
		}
	}
}
