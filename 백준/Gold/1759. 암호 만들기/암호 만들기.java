import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[] arr;
	static boolean[] visit;
	static char[] result;
	static ArrayList<Character> list = new ArrayList<Character>();
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new char[M];
		visit = new boolean[M];
		result = new char[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = st.nextToken().charAt(0);
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
				list.add(arr[i]);
			}
		}
		sb = new StringBuilder();
		Arrays.sort(arr);
		dfs(0, 0);
		System.out.println(sb);

	}

	static void dfs(int depth, int start) {
		if (depth == N) {
			if (check()) {
				for (int i = 0; i < N; i++) {
					sb.append(result[i]);
				}
				sb.append("\n");
				return;
			} else {
				return;
			}
		}

		for (int i = start; i < M; i++) {
			result[depth] = arr[i];
			dfs(depth + 1, i+1);
		}
	}

	static boolean check() {
		int cnt1 = 0;
		int cnt2 = 0;

		for (int i = 0; i < N; i++) {
			if (list.contains(result[i])) {
				cnt1++;
			} else {
				cnt2++;
			}
		}

		if (cnt1 >= 1 && cnt2 >= 2) {
			return true;
		} else {
			return false;
		}
	}
}