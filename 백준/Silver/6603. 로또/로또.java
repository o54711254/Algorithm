import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] result = new int[6];
	static boolean[] visit;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			String str = br.readLine();
			if (str.equals("0")) {
				break;
			}

			st = new StringTokenizer(str);
			int k = Integer.parseInt(st.nextToken());

			arr = new int[k];
			visit = new boolean[k];

			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			sb = new StringBuilder();
			combination(0, 0, 6);
			System.out.println(sb);
		}
	}

	public static void combination(int depth, int start, int r) {
		if (depth == r) {
			for (int i = 0; i < r; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		int k = arr.length;
		for (int i = start; i < k; i++) {
			if (!visit[i]) {
				visit[i] = true;
				result[depth] = arr[i];
				combination(depth + 1, i + 1, r);
				visit[i] = false;
			}
		}
	}

}