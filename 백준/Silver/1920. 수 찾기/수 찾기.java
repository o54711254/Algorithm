
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		sb = new StringBuilder();
		
		Arrays.sort(arr);
		
		for (int i = 0; i < M; i++) {
			sb.append(binarySearch(arr, Integer.parseInt(st.nextToken()))).append("\n");
		}
		System.out.println(sb);

	}

	static int binarySearch(int[] arr, int num) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (num < arr[mid]) {
				end = mid - 1;
			} else if (arr[mid] < num) {
				start = mid + 1;
			} else {
				return 1;
			}
		}
		return 0;
	}
}
