
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] result;
	static boolean[] visit;
	static LinkedHashSet<String> set = new LinkedHashSet<String>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		result = new int[M];
		visit = new boolean[N];

		func(0, 0, M);

		for (String s : set) {
			System.out.println(s);
		}
	}

	public static void func(int depth, int start, int r) {
		if (depth == r) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < r; i++) {
				sb.append(result[i] + " ");
			}
			set.add(sb.toString());
			return;
		}
		int N = arr.length;
		for (int i = start; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				result[depth] = arr[i];
				func(depth + 1, i + 1, r);
				visit[i] = false;
			}
		}
	}
}