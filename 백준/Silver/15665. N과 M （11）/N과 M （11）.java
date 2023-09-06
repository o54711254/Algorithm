
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] result;
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
		func(0, M);
		StringBuilder sb = new StringBuilder();
		for(String s : set) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}

	public static void func(int depth, int r) {
		if (depth == r) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < r; i++) {
				sb.append(result[i] + " ");
			}
			set.add(sb.toString());
			return;
		}
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			result[depth] = arr[i];
			func(depth + 1, r);
		}
	}
}