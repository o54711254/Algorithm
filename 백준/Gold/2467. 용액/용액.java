import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = N - 1;
		int mid = (N - 1) / 2;

		long result = Integer.MAX_VALUE;
		long left = 0;
		long right = 0;

		while (start < end) {

			long now = arr[start] + arr[end];
			if (result >= Math.abs(now)) {
				result = Math.abs(now);
				left = arr[start];
				right = arr[end];
			}
			if (now >= 0) {
				end--;
			} else if (now < 0) {
				start++;
			}
		}
		System.out.println(left + " " + right);
	}
}