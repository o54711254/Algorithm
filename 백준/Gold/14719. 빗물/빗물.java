import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[M + 1];
		int mid = 0;
		int maxHeight = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < M + 1; i++) {
			int height = Integer.parseInt(st.nextToken());
			arr[i] = height;
			if (height > maxHeight) {
				mid = i;
				maxHeight = height;
			}
		}

		int result = 0;

		int wall = 0;
		for (int i = 1; i < mid; i++) {
			if (wall < arr[i]) {
				wall = arr[i];
			}
			result += (wall - arr[i]);
		}

		wall = 0;
		for (int i = M; i > mid; i--) {
			if (wall < arr[i]) {
				wall = arr[i];
			}
			result += (wall - arr[i]);
		}

		System.out.println(result);
	}
}