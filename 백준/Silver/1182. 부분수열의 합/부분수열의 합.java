import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static int[] result;
	static int S;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		visited = new boolean[N];

		for (int i = 1; i <= N; i++) {
			result = new int[i];
			combination(0, 0, i, 0);
		}
		System.out.println(count);
	}

	public static void combination(int depth, int start, int r, int sum) {
		if (depth == r) {
			if (sum == S) {
				count++;
			}
			return;
		}
		int N = arr.length;
		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				combination(depth + 1, i + 1, r, sum + result[depth]);
				visited[i] = false;
			}
		}
	}
}
