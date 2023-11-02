import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int snow1 = arr[i] + arr[j];

				int start = 0;
				int end = N - 1;
				while (start < end) {
					if (start == i || start == j) {
						start++;
						continue;
					}
					if (end == i || end == j) {
						end--;
						continue;
					}
					int snow2 = arr[start] + arr[end];
					result = Math.min(result, Math.abs(snow1-snow2));
					if (snow1 > snow2) {
						start++;
					}
					else if (snow1 < snow2) {
						end--;
					}else {
						System.out.println(0);
						return;
					}
					
				}
			}
		}
		System.out.println(result);
	}

}