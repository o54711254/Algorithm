import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int k = 0; k < tc; k++) {

			int N = Integer.parseInt(br.readLine());

			String[] arr = new String[N];
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine();
			}

			if (checkNumber(N, arr)) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean checkNumber(int N, String[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < N - 1; i++) {
			if (arr[i + 1].startsWith(arr[i])) {
				return false;
			}
		}
		return true;
	}
}