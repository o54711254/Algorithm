import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				String s = st.nextToken();
				arr[a] = s;
			}
			System.out.print("#"+tc+" ");
			preorder(arr, 1);
			System.out.println();
		}

	}

	public static void preorder(String[] arr, int i) {
		if (i < arr.length) {
			if (arr[i] != " ") {
				preorder(arr, i * 2);
				System.out.print(arr[i]);
				preorder(arr, i * 2 + 1);
			}
		}
	}
}
