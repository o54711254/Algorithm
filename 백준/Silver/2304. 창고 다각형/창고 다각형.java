import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int maxHeight = Integer.MIN_VALUE;
		int mid = 0;

		int[] arr = new int[1001];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());

			if (maxHeight < H) {
				mid = L;
				maxHeight = Math.max(H, maxHeight);
			}
			arr[L] = H;
		}

		int result = 0;
		int now = 0;

		for (int i = 1; i < mid; i++) {
			if (arr[i] > now) {
				now = arr[i];
			}
			result += now;
		}

		now = 0;
		for (int i = 1000; i > mid; i--) {
			if (arr[i] > now) {
				now = arr[i];
			}
			result += now;
		}

		result += arr[mid];

		System.out.println(result);
	}

}